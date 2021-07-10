package suhailmohd.idf;

import org.apache.calcite.adapter.java.AbstractQueryableTable;
import org.apache.calcite.linq4j.AbstractEnumerable;
import org.apache.calcite.linq4j.Enumerable;
import org.apache.calcite.linq4j.Enumerator;
import org.apache.calcite.linq4j.QueryProvider;
import org.apache.calcite.linq4j.Queryable;
import org.apache.calcite.linq4j.Linq4j;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.QueryableTable;
import org.apache.calcite.schema.TranslatableTable;
import org.apache.calcite.schema.impl.AbstractTableQueryable;
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.rel.RelNode;
import java.util.ArrayList;
import org.checkerframework.checker.nullness.qual.Nullable;
import java.io.IOException;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.plan.RelTraitSet;
import suhailmohd.idf.nutanixdb.IDF;
import suhailmohd.idf.nutanixdb.IDFTableDesc;
import org.apache.calcite.adapter.java.JavaTypeFactory;
import org.apache.calcite.rel.type.RelDataType;
import java.util.List;
import org.apache.calcite.util.Pair;
import com.nutanix.insights.ifc.InsightsInterfaceProto.GetEntitiesWithMetricsRet;
import com.nutanix.insights.ifc.InsightsInterfaceProto.GetEntitiesWithMetricsArg;
import com.nutanix.insights.ifc.InsightsInterfaceProto.Query;
import com.nutanix.insights.ifc.InsightsInterfaceProto.EntityGuid;
import com.nutanix.insights.ifc.InsightsInterfaceProto.QueryGroupBy;
import com.nutanix.insights.ifc.InsightsInterfaceProto.QueryRawColumn;
import com.nutanix.insights.ifc.InsightsInterfaceProto.EntityWithMetric;
import com.nutanix.insights.ifc.InsightsInterfaceProto.TimeValuePair;
import com.nutanix.insights.ifc.InsightsInterfaceProto.DataValue;
import com.nutanix.insights.ifc.InsightsInterfaceProto.MetricData;
import com.nutanix.insights.ifc.InsightsInterfaceProto.BooleanExpression;
import com.nutanix.insights.ifc.InsightsInterfaceProto.QueryGroupResult;
import com.nutanix.insights.exception.InsightsInterfaceException;
import com.google.protobuf.TextFormat.ParseException;
import com.google.protobuf.TextFormat;

public class IDFTable extends AbstractQueryableTable implements TranslatableTable {

    IDF idf;
    IDFTableDesc desc;
    ArrayList<String> fieldNames;
    ArrayList<IDFFieldType> fieldTypes;
    RelDataType rowType;

    IDFTable(IDF idf, IDFTableDesc desc) {
        super(Object[].class);
        this.idf = idf;
        this.desc = desc;
        this.rowType = null;
    }

    @Override public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        if (rowType == null) {
            fieldNames = new ArrayList<String>();
            fieldTypes = new ArrayList<IDFFieldType>();
            rowType = buildRowType(typeFactory, fieldNames, fieldTypes);
        }
        return rowType;
    }
    
    RelDataType buildRowType(RelDataTypeFactory typeFactory, ArrayList<String> fieldNames, ArrayList<IDFFieldType> fieldTypes) {
        final List<RelDataType> types = new ArrayList<>();
        final List<String> names = new ArrayList<>();
    
        names.add("ENTITY_ID");
        types.add(IDFFieldType.of("string").toType((JavaTypeFactory) typeFactory));
        fieldNames.add("entity_id");
        fieldTypes.add(IDFFieldType.of("string"));

        for (IDFTableDesc.FieldDesc fieldDesc: desc.fieldDescs) {
            IDFFieldType fieldType = IDFFieldType.of(fieldDesc.type);

            if (fieldType == null) {
                System.err.println("WARNING: Found unknown type: "
                    + fieldDesc.type
                    + " for column: " + fieldDesc.name
                    + ". Ignoring it");
                continue;
            }

            final RelDataType type;
            if (fieldType == null) {
              type = typeFactory.createSqlType(SqlTypeName.VARCHAR);
            } else {
              type = fieldType.toType((JavaTypeFactory) typeFactory);
            }
            names.add(fieldDesc.name.toUpperCase());
            types.add(type);
            fieldNames.add(fieldDesc.name);
            fieldTypes.add(fieldType);
        }
        return typeFactory.createStructType(Pair.zip(names, types));
    }

    @Override public <T> Queryable<T> asQueryable(QueryProvider queryProvider,
      SchemaPlus schema, String tableName) {
        return new IDFQueryable<>(queryProvider, schema, this, tableName);
    }

    // TODO: what is cluster????
    @Override public RelNode toRel(RelOptTable.ToRelContext context, RelOptTable relOptTable) {
        final RelOptCluster cluster = context.getCluster();
        return new IDFTableScan(cluster, cluster.traitSetOf(IDFRel.CONVENTION),
            relOptTable, this);    
    }

    public Enumerable<@Nullable Object[]> query(String whereString) throws InsightsInterfaceException {

        ArrayList<Object[]> rows = new ArrayList<Object[]>();

        GetEntitiesWithMetricsArg.Builder builder = GetEntitiesWithMetricsArg.newBuilder();

        Query.Builder queryBuilder = builder.getQueryBuilder();

        // Specify entity type
        queryBuilder.addEntityList(
            EntityGuid.newBuilder().setEntityTypeName(this.desc.tableName).build()
        );

        // Set where clause
        if (whereString != "") {
            BooleanExpression expr = null;
            System.err.println("Where: " + whereString.toString());
            try {
                expr = TextFormat.parse(whereString, BooleanExpression.class);
            } catch (ParseException e) {
                System.err.println("Invalid where clause: " + whereString);
            }
            if (expr != null) {
                queryBuilder.setWhereClause(expr);
            }
        }

        // Specify columns to query
        QueryGroupBy.Builder groupBy = queryBuilder.getGroupByBuilder();
        for (String name: fieldNames) {
            groupBy.addRawColumns(
                QueryRawColumn.newBuilder().setColumn(name)
            );
        }

        // Make query
        GetEntitiesWithMetricsRet res = idf.QueryTable(builder.build());

        // Convert query to rows
        for (QueryGroupResult singleGroup: res.getGroupResultsListList()) {
            for (EntityWithMetric e: singleGroup.getRawResultsList()) {
                List<MetricData> metrics = e.getMetricDataListList();
                Object[] row = new Object[metrics.size() + 1];

                int idx = 0;
                for (MetricData metric: metrics) {
                    System.err.println("metrics" + metric.getName());
                    List<TimeValuePair> timeValuePairList = metric.getValueListList();
                    if (timeValuePairList.size() > 0) {
                        System.err.println("herere");
                        DataValue value = timeValuePairList.get(0).getValue();
                        row[idx] = this.getValue(value);
                    } else {
                        row[idx] = null;
                    }
                    idx += 1;
                }
                row[0] = e.getEntityGuid().getEntityId();

                rows.add(row);
            }
        }

        return new AbstractEnumerable<@Nullable Object[]>() {
            @Override public Enumerator<@Nullable Object[]> enumerator() {
                return Linq4j.iterableEnumerator(rows);
            }
        };
    }

    public static Object getValue(DataValue value) {
        if (value.hasStrValue()) {
            return value.getStrValue();
        }
        if (value.hasInt64Value()) {
            return value.getInt64Value();
        }
        if (value.hasBoolValue()) {
            return value.getBoolValue();
        }
        if (value.hasUint64Value()) {
            return value.getUint64Value();
        }
        if (value.hasFloatValue()) {
            return value.getFloatValue();
        }
        if (value.hasDoubleValue()) {
            return value.getDoubleValue();
        }
        return "Invalid";
    }

    public static class IDFQueryable<T> extends AbstractTableQueryable<T> {
  
        public IDFQueryable(QueryProvider queryProvider, SchemaPlus schema,
            IDFTable table, String tableName) {
    
            super(queryProvider, schema, table, tableName);
        }
    
        @Override public Enumerator<T> enumerator() {
            try {
                final Enumerable<T> enumerable = (Enumerable<T>) getTable().query("");
                return enumerable.enumerator();
            } catch (InsightsInterfaceException e) {
                return null;
            }
        }
    
        public Enumerable<Object[]> query(String whereString) {
            try {
                return getTable().query(whereString);
            } catch (InsightsInterfaceException e) {
                System.err.println("Error executing query");
                return null;
            }
        }

        private IDFTable getTable() {
            return (IDFTable) table;
        }
    }
}

