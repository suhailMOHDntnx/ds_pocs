package suhailmohd.cerebro;

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
import suhailmohd.cerebro.generated.GenProtectionDomainList;
import java.io.IOException;
import org.apache.commons.lang3.text.StrSubstitutor;
import java.util.HashMap;
import java.lang.ProcessBuilder;
import java.lang.Process;
import java.lang.StringBuilder;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CerebroSchemaFactory implements SchemaFactory {
    /** Public singleton, per factory contract. */
    public static final CerebroSchemaFactory INSTANCE = new CerebroSchemaFactory();

    private CerebroSchemaFactory() {
    }

    @Override public Schema create(SchemaPlus parentSchema, String name,
        Map<String, Object> operand) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String filePath = (String )operand.get("rpc_script");
            Map valuesMap = new HashMap();
            valuesMap.put("POC_ROOT", System.getenv("POC_ROOT"));
            StrSubstitutor sub = new StrSubstitutor(valuesMap);
            String finalFilePath = sub.replace(filePath);

            String s;
            s = getProtectionDomains(finalFilePath);
            GenProtectionDomainList z = gson.fromJson(s, GenProtectionDomainList.class);
            // System.out.println(gson.toJson(z));
            return new ReflectiveSchema(z);
      }


    static String getProtectionDomains(String scriptPath) {
      StringBuilder output = new StringBuilder();
      try {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("python", scriptPath);
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        int exitVal = process.waitFor();
        // if (exitVal == 0) {
        //   System.out.println("Success!");
        //   System.out.println(output);
        //   System.exit(0);
        // } else {
        //   //abnormal...
        // }
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return output.toString();
    }
  }
