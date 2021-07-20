package suhailmohd.dsserver;

import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;


class Queries {
    Query[] queries;

    public static Queries fromConfig(String queryConfig) throws IOException {

        String s;
        s = new String(Files.readAllBytes(Paths.get(queryConfig + "/config.json")));


        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        Queries queries = gson.fromJson(s, Queries.class);

        for (Query query: queries.queries) {
            query.setBaseDir(queryConfig);
        }

        return queries;
    }

}

class Query {

    private int interval;
    private String name;
    private String sql;
    private String sqlFileName;

    Query(String sql, int interval, String name) {
        this.interval = interval;
        this.name = name;
        this.sql = sql;
    }


    public String getName() {
        return name;
    }

    public int getInterval() {
        return interval;
    }

    public void setBaseDir(String base) {
        if (this.sqlFileName != "") {
            this.sqlFileName = base + "/" + this.sqlFileName;
        }
        System.out.println(this.sqlFileName);
    }

    public String getSQL() throws Exception {
        if (sql != "" && sql != null) {
            return sql;
        }
        String s;
        System.out.println(sqlFileName);
        s = new String(Files.readAllBytes(Paths.get(sqlFileName)));
        sql = s;
        return sql;
    }
}