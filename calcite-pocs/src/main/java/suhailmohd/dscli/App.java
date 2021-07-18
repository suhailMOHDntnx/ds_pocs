package suhailmohd.dscli;

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

import suhailmohd.idf.IDFSchema;
import suhailmohd.tartarus.TartarusSchema;

public class App
{

    public static void printRSS(String step) {
        System.out.println("********************" + step);
        System.out.println("Total memory: " + Runtime.getRuntime().totalMemory());
        System.out.println("Max memory: " + Runtime.getRuntime().maxMemory());
        System.out.println("Free memory:" + Runtime.getRuntime().freeMemory());
    }

    public static void main(String[] args) {
        try {
            doMain(args);
        } catch (Exception e) {

        }
    }

    public static void doMain(String[] args) throws Exception
    {
        printRSS("Boot");
        Class.forName("org.apache.calcite.jdbc.Driver");
        Properties info = new Properties();
        info.setProperty("lex", "JAVA");
        Connection connection =
            DriverManager.getConnection("jdbc:calcite:model=" + args[0], info);
        CalciteConnection calciteConnection =
            connection.unwrap(CalciteConnection.class);

        printRSS("Connection established");
        SchemaPlus rootSchema = calciteConnection.getRootSchema();
        // Schema tSchema = new TartarusSchema();
        // Schema idfSchema = new IDFSchema();
        // rootSchema.add("tartarus", tSchema);
        // rootSchema.add("idf", idfSchema);


        String[] queries = getQuery(args[2]);
        Statement statement = calciteConnection.createStatement();

        for (String query : queries) {
            System.out.println("========================== Executing query");
            System.out.println("Query: " + query);

            // Execute query
            boolean result = statement.execute(query);
            if (!result) {
                printRSS("Query failed");
            }

            printRSS("Query complete");

        }

        ResultSet resultSet = statement.getResultSet();
        // Print results
        DBTablePrinter.printResultSet(resultSet);

        printRSS("Query result printing done");

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
