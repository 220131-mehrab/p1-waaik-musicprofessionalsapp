package com.revature.waaik.musicprofessionalsapp.Server;

import com.revature.waaik.musicprofessionalsapp.Servlets.*;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Server {
    Tomcat server = new Tomcat();
    public Server() {
        server.getConnector();
        server.addContext("", null);


        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:dbmain;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;INIT=runscript from 'classpath:proschema.sql'", "wcp", "wcp");
        } catch (SQLException e) {
            System.err.println("Connection to DB failed");
            e.printStackTrace();
        }

        server.addServlet("", "defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet("", "proServlet", new proServlet(connection)).addMapping("/pros");
        server.addServlet("", "userServlet", new userServlet(connection)).addMapping("/user");
        server.addServlet("", "hiredServlet", new hiredServlet(connection)).addMapping("/hired");
        server.addServlet("", "loginServlet", new loginServlet(connection)).addMapping("/login");
    }
    public void build(){
        try {
            server.start();
        } catch (
                LifecycleException e) {
            e.printStackTrace();
            System.err.println("Sorry server failed to start");
        }

    }




}
