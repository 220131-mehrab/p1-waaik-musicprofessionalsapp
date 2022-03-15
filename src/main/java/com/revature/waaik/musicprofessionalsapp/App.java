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
        //Creating list array for my Pros object
       // List<Pros> pros = new ArrayList<>();
       //Connecting the database to driver
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:dbmain;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;INIT=runscript from 'classpath:proschema.sql'", "wcp", "wcp");

        //Creating proServlet
        HttpServlet proServlet = new HttpServlet() {
            //Sending database data to the browser
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                List<Pros> pros = new ArrayList<>();
                //ResultSet rSet = null;
                try {
                    ResultSet rSet = connection.prepareStatement("select * from pros").executeQuery();
                    while (rSet.next()) {
                        //get columns in table and puts it into your Pros list
                        pros.add(new Pros(rSet.getInt("proid"), rSet.getString("name"), rSet.getString("profession"), rSet.getString("phonenumber"), rSet.getString("email"), rSet.getInt("fee")));

                    }
                }catch(SQLException e){
                        e.printStackTrace();
                    }
                ObjectMapper mapper = new ObjectMapper();
                String results = mapper.writeValueAsString(pros); //write pros value as a string that you get from database
                resp.setContentType("/application/json");
                resp.getWriter().println(results);
                }
                //Getting info from the browser and posting it to the database on the browser
                @Override
                protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
                    ObjectMapper mapper = new ObjectMapper();
                    Pros newPros = mapper.readValue(req.getInputStream(), Pros.class);

                    try {
                        PreparedStatement stmt = connection.prepareStatement("insert into pros values (?,?,?,?,?,?)");
                        stmt.setInt(1, newPros.getProId());
                        stmt.setString(2, newPros.getName());
                        stmt.setString(3, newPros.getProfession());
                        stmt.setString(4, newPros.getPhoneNumber());
                        stmt.setString(5, newPros.getEmail());
                        stmt.setInt(6, newPros.getFee());
                        stmt.executeLargeUpdate();
                    } catch (SQLException e) {
                        System.err.println("Failed to insert:" + e.getMessage());
                        e.printStackTrace();
                    }

                }

            };


        //Creating server
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

