package com.revature.waaik.musicprofessionalsapp;

import javax.sql.DataSource;

public class DbDataSource {
    private DataSource ds;

    public DbDataSource(){

    }

    public DbDataSource(DataSource ds) {
        this.ds = ds;
    }
}
