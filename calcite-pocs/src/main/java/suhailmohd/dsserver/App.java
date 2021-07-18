package suhailmohd.dsserver;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class App
{

    public static void printRSS(String step) {
        System.out.println("********************" + step);
        System.out.println("Total memory: " + Runtime.getRuntime().totalMemory());
        System.out.println("Max memory: " + Runtime.getRuntime().maxMemory());
        System.out.println("Free memory:" + Runtime.getRuntime().freeMemory());
    }

    public static void main(String[] args) throws Exception
    {
        printRSS("Boot");
        Class.forName("org.apache.calcite.jdbc.Driver");
        Properties info = new Properties();
        info.setProperty("unquotedCasing", "UNCHANGED");
        Connection connection =
            DriverManager.getConnection("jdbc:calcite:model=" + args[0], info);
        CalciteConnection calciteConnection =
            connection.unwrap(CalciteConnection.class);

        printRSS("Connection established");
        SchemaPlus rootSchema = calciteConnection.getRootSchema();

        ArrayList<Query> queries = new ArrayList<Query>();


        HashMap<String, PreparedStatement> queryMap = new HashMap<>();
        for (Query q: queries) {
            PreparedStatement statement = calciteConnection.prepareStatement(q.getSQL());
            queryMap.put(q.getName(), statement);
        }



        while(true) {
            for (Query query: queries) {
                System.out.println("========================== Executing query");
                System.out.println("Query: " + query.getSQL());

                PreparedStatement statement = queryMap.get(query.getName());
                
                boolean result = statement.execute();
                if (!result) {
                    printRSS("query failed");
                }
                printRSS("Query complete");
                TimeUnit.SECONDS.sleep(10);
            }
        }

    }
}
