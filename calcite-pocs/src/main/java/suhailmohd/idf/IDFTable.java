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


public class IDFTable extends AbstractQueryableTable implements TranslatableTable {

    IDFTable() {
        super(Object[].class);
    }

    @Override public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        RelDataTypeFactory.Builder builder = typeFactory.builder();
        builder.add("id", typeFactory.createSqlType(SqlTypeName.INTEGER));
        builder.add("disk_size", typeFactory.createSqlType(SqlTypeName.INTEGER));
        return builder.build();
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

    public Enumerable<@Nullable Object[]> query() {

        ArrayList<Object[]> rows = new ArrayList<Object[]>();
        Object[] row = new Object[2];
        row[0] = 123;
        row[1] = 90;

        rows.add(row);

        return new AbstractEnumerable<@Nullable Object[]>() {
            @Override public Enumerator<@Nullable Object[]> enumerator() {
                return Linq4j.iterableEnumerator(rows);
            }
        };
    }

    public static class IDFQueryable<T> extends AbstractTableQueryable<T> {
  
        public IDFQueryable(QueryProvider queryProvider, SchemaPlus schema,
            IDFTable table, String tableName) {
    
            super(queryProvider, schema, table, tableName);
        }
    
        @Override public Enumerator<T> enumerator() {
            final Enumerable<T> enumerable = (Enumerable<T>) getTable().query();
            return enumerable.enumerator();
        }
    
        public Enumerable<Object[]> query() {
            return getTable().query();
        }

        private IDFTable getTable() {
            return (IDFTable) table;
        }
    }
}

