package suhailmohd.tartarus;

import org.apache.calcite.adapter.file.CsvEnumerator;
import org.apache.calcite.adapter.java.JavaTypeFactory;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rel.type.RelProtoDataType;
import org.apache.calcite.schema.impl.AbstractTable;
import org.apache.calcite.util.Source;
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.util.Pair;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class TartarusTable extends AbstractTable {
  TartarusTableDescription tableDesc;
  private @Nullable List<RelDataType> fieldTypes;
  private @Nullable RelDataType rowType;


  /** Creates a TartarusTable. */
  TartarusTable(TartarusTableDescription tableDesc) {
    this.tableDesc = tableDesc;
  }

  @Override public RelDataType getRowType(RelDataTypeFactory typeFactory) {
    if (rowType == null) {
      rowType = buildRowType(typeFactory, null);
    }
    return rowType;
  }

  /** Returns the field types of this CSV table. */
  public RelDataType buildRowType(RelDataTypeFactory typeFactory, @Nullable List<RelDataType> fieldTypes) {
    final List<RelDataType> types = new ArrayList<>();
    final List<String> names = new ArrayList<>();

    for (String string: tableDesc.rowDescs) {
      final String name;
      final TartarusFieldType fieldType;
      final int colon = string.indexOf(':');
      // name:type
      if (colon >= 0) {
        name = string.substring(0, colon);
        String typeString = string.substring(colon + 1);
        fieldType = TartarusFieldType.of(typeString);
        if (fieldType == null) {
          System.err.println("WARNING: Found unknown type: "
              + typeString
              + " for column: " + name
              + ". Will assume the type of column is string");
        }
      } else {
        name = string;
        fieldType = null;
      }

      final RelDataType type;
      if (fieldType == null) {
        type = typeFactory.createSqlType(SqlTypeName.VARCHAR);
      } else {
        type = fieldType.toType((JavaTypeFactory) typeFactory);
      }
      names.add(name);
      types.add(type);

      if (fieldTypes != null) {
        fieldTypes.add(type);
      }
    }

    return typeFactory.createStructType(Pair.zip(names, types));
  }

  /** Returns the field types of this CSV table. */
  public List<RelDataType> getFieldTypes(RelDataTypeFactory typeFactory) {
    if (fieldTypes == null) {
      fieldTypes = new ArrayList<>();
      buildRowType(typeFactory, fieldTypes);
    }
    return fieldTypes;
  }


  /** Returns whether the table represents a stream. */
  protected boolean isStream() {
    return false;
  }

  // /** Various degrees of table "intelligence". */
  // public enum Flavor {
  //   SCANNABLE, FILTERABLE, TRANSLATABLE
  // }
}