package suhailmohd.dsserver;

import java.util.List;


class Query {

    private int interval;
    private String name;
    private String sql;

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

    public String getSQL() {
        return sql;
    }
}