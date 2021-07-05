package suhailmohd;

import org.apache.calcite.jdbc.*;
import org.apache.calcite.schema.*;
import org.apache.calcite.adapter.java.*;
import java.sql.*;
import java.lang.System;
import java.sql.ResultSet;
import java.util.Properties;
import org.apache.calcite.jdbc.Driver;
import java.util.concurrent.TimeUnit;
import java.lang.Runtime;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App
{

    public static void printRSS() {
        System.out.println("********************");
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println( Runtime.getRuntime().maxMemory());
        System.out.println( Runtime.getRuntime().freeMemory());
    }

    public static void main( String[] args ) throws Exception
    {
        Class.forName("org.apache.calcite.jdbc.Driver");
        Properties info = new Properties();
        info.setProperty("lex", "JAVA");
        Connection connection =
            DriverManager.getConnection("jdbc:calcite:", info);
        CalciteConnection calciteConnection =
            connection.unwrap(CalciteConnection.class);


        SchemaPlus rootSchema = calciteConnection.getRootSchema();
        Schema schema = new TartarusSchema();
        rootSchema.add("tartarus", schema);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String s = new String(Files.readAllBytes(Paths.get("/home/nutanix/ncc/bin/zeus_config.dat")));
        GenZeusConfig z = gson.fromJson(s, GenZeusConfig.class);
        // System.out.println(gson.toJson(z));
        rootSchema.add("zeusConfig", new ReflectiveSchema(z));

        String[] queries = getQuery(args[0]);
        Statement statement = calciteConnection.createStatement();

        for (String query : queries) {
            System.out.println("========================== Executing query");
            System.out.println("Query: " + query);

            // Execute query
            boolean result = statement.execute(query);
            if (!result) {
                throw new Exception("query failed");
            }

        }

        ResultSet resultSet = statement.getResultSet();
        // Print results
        DBTablePrinter.printResultSet(resultSet);

        connection.close();

    }

    static String[] getQuery(String filePath) {
        String all = "";
        try
        {
            all = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return all.split("==EOF==");
    }
}
