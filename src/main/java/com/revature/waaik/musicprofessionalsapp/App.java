package com.revature.waaik.musicprofessionalsapp;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        List<Pros> pros = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:dbmain;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;INIT=runscript from 'classpath:proschema.sql'", "wcp", "wcp");
        //ResultSet rSet = connection.prepareStatement("select * from pros").executeQuery();

        //while(rSet.next()){
        // pros.add(rSet.getString("name"));


        HttpServlet proServlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {

                List<Pros> pros = new ArrayList<>();
                ResultSet rSet = null;
                try {
                    rSet = connection.prepareStatement("select * from pros").executeQuery();
                    while (rSet.next()) {
                        pros.add(new Pros(rSet.getInt("proid"), rSet.getString("name"), rSet.getString("profession"), rSet.getString("phonenumber"), rSet.getString("email"), rSet.getInt("fee")));

                    }
                }catch(SQLException e){
                        e.printStackTrace();
                    }

                    //JSON Mapper
                    ObjectMapper mapper = new ObjectMapper();
                    String results = mapper.writeValueAsString(pros);
                    resp.setContentType("application/json");
                    resp.getWriter().println(results);
                }

                @Override
                protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
                    ObjectMapper mapper = new ObjectMapper();
                    Pros newPros = mapper.readValue(req.getInputStream(), Pros.class);

                    try {
                        PreparedStatement stmt = connection.prepareStatement("insert into pros values (?,?,?,?,?,?)");
                        stmt.setInt(1, newPros.getProsId());
                        stmt.setString(2, newPros.getName());
                        stmt.setString(3, newPros.getProfession());
                        stmt.setString(4, newPros.getPhoneNumber());
                        stmt.setString(5, newPros.getEmail());
                        stmt.setInt(6, newPros.getFee());
                    } catch (SQLException e) {
                        System.err.println("Failed to insert:" + e.getMessage());
                        e.printStackTrace();
                    }

                }

            };



        Tomcat server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "defaultServlet", new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String filename = req.getPathInfo();//Points to path of file from browser
                String resourceDir = "static";
                InputStream file = getClass().getClassLoader().getResourceAsStream(resourceDir + filename); //loads src data into backend from static folder
                String mimeType = getServletContext().getMimeType(filename); //checks for type of file being imported
                resp.setContentType(mimeType);
                IOUtils.copy(file, resp.getOutputStream()); //copies file from the input to server


            }
        }).addMapping("/*");
        server.addServlet("", "proServlet", proServlet).addMapping("/pros");
        try {
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
            System.err.println("Sorry server failed to start");
        }


    }
}

