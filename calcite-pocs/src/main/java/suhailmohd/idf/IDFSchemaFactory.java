package suhailmohd.idf;

import org.apache.calcite.model.ModelHandler;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaFactory;
import org.apache.calcite.schema.SchemaPlus;

import java.io.File;
import java.util.Locale;
import java.util.Map;

public class IDFSchemaFactory implements SchemaFactory {
    /** Public singleton, per factory contract. */
    public static final IDFSchemaFactory INSTANCE = new IDFSchemaFactory();
  
    private IDFSchemaFactory() {
    }
  
    @Override public Schema create(SchemaPlus parentSchema, String name,
        Map<String, Object> operand) {
      return new IDFSchema();
    }
  }