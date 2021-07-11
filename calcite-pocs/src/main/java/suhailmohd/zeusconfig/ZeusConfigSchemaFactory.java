package suhailmohd.zeusconfig;

import org.apache.calcite.model.ModelHandler;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaFactory;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.*;
import org.apache.calcite.adapter.java.*;
import java.nio.file.Paths;
import java.nio.file.Files;


import java.io.File;
import java.util.Locale;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import suhailmohd.zeusconfig.generated.GenZeusConfig;
import java.io.IOException;
import org.apache.commons.lang3.text.StrSubstitutor;
import java.util.HashMap;

public class ZeusConfigSchemaFactory implements SchemaFactory {
    /** Public singleton, per factory contract. */
    public static final ZeusConfigSchemaFactory INSTANCE = new ZeusConfigSchemaFactory();
  
    private ZeusConfigSchemaFactory() {
    }
  
    @Override public Schema create(SchemaPlus parentSchema, String name,
        Map<String, Object> operand) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String filePath = (String )operand.get("zeus_config_file");
            Map valuesMap = new HashMap();
            valuesMap.put("POC_ROOT", System.getenv("POC_ROOT"));
            StrSubstitutor sub = new StrSubstitutor(valuesMap);
            String finalFilePath = sub.replace(filePath);

            String s;
            try {
                s = new String(Files.readAllBytes(Paths.get(finalFilePath)));
            } catch (IOException e) {
                System.err.println("Failed to load zeus config file");
                return null;
            }
            GenZeusConfig z = gson.fromJson(s, GenZeusConfig.class);
            // System.out.println(gson.toJson(z));
            return new ReflectiveSchema(z);
      }
  }