package com.revature.waaik.musicprofessionalsapp;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.waaik.musicprofessionalsapp.Server.Server;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.LifecycleException;

import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        //Server and servlets are built and pushed to browser
        Server server = new Server();
        server.build();
    }
}

