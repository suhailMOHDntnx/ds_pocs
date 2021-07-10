package suhailmohd.idf;

import org.apache.calcite.linq4j.tree.Types;

import com.google.common.collect.ImmutableMap;

import java.lang.reflect.Method;
import java.util.List;

public enum IDFMethod {
  IDF_QUERYABLE_QUERY(IDFTable.IDFQueryable.class, "query", String.class);

  @SuppressWarnings("ImmutableEnumChecker")
  public final Method method;

  public static final ImmutableMap<Method, IDFMethod> MAP;

  static {
    final ImmutableMap.Builder<Method, IDFMethod> builder =
        ImmutableMap.builder();
    for (IDFMethod value : IDFMethod.values()) {
      builder.put(value.method, value);
    }
    MAP = builder.build();
  }

  IDFMethod(Class clazz, String methodName, Class... argumentTypes) {
    this.method = Types.lookupMethod(clazz, methodName, argumentTypes);
  }
}