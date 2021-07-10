package suhailmohd.idf;

import org.apache.calcite.adapter.java.JavaTypeFactory;
import org.apache.calcite.linq4j.tree.Primitive;
import org.apache.calcite.rel.type.RelDataType;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Type of a field in a tartarus file.
 *
 * <p>Usually, and unless specified explicitly in the header row, a field is
 * of type {@link #STRING}. But specifying the field type in the header row
 * makes it easier to write SQL.</p>
 */

/*
##     - bool
##     - int64
##     - uint64
##     - float
##     - double
##     - string
##     - bytes
*/
public enum IDFFieldType {
  BOOLEAN(Boolean.class, "bool"),
  LONG(Long.class, "int64"),
  // TODO: Evaluate whether this works
  ULONG(Long.class, "uint64"),
  FLOAT(Float.class, "float"),
  DOUBLE(Double.class, "double"),
  STRING(String.class, "string"),
  BYTES(String.class, "bytes");

  private final Class clazz;
  private final String simpleName;

  private static final Map<String, IDFFieldType> MAP = new HashMap<>();

  static {
    for (IDFFieldType value : values()) {
      MAP.put(value.simpleName, value);
    }
  }

  IDFFieldType(Primitive primitive) {
    this(primitive.boxClass, primitive.primitiveName);
  }

  IDFFieldType(Class clazz, String simpleName) {
    this.clazz = clazz;
    this.simpleName = simpleName;
  }

  public RelDataType toType(JavaTypeFactory typeFactory) {
    RelDataType javaType = typeFactory.createJavaType(clazz);
    RelDataType sqlType = typeFactory.createSqlType(javaType.getSqlTypeName());
    return typeFactory.createTypeWithNullability(sqlType, true);
  }

  public Class getJavaClass() {
    return clazz;
  }

  public static @Nullable IDFFieldType of(String typeString) {
    return MAP.get(typeString);
  }
}
