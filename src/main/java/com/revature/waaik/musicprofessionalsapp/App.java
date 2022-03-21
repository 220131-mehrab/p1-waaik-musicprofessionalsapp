package com.revature.waaik.musicprofessionalsapp;

import com.revature.waaik.musicprofessionalsapp.Server.Server;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        //Server and servlets are built and pushed to browser
        Server server = new Server();
        server.build();
    }
}

