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

        String ip = (String)operand.get("ip");
        if (ip == null) {
          ip = "127.0.0.1";
        }

        Integer port = (Integer)operand.get("port");
        if (port == null) {
          port = 2027;
        }

        return new IDFSchema(ip, port);
    }
  }