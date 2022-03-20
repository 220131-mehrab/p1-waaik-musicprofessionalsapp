package com.revature.waaik.musicprofessionalsapp.Servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.waaik.musicprofessionalsapp.Pros;
import com.revature.waaik.musicprofessionalsapp.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class hiredServlet extends HttpServlet {
    private Connection connection;
    public hiredServlet(Connection connection){
        this.connection = connection;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Pros> pros = new ArrayList<>();
        //ResultSet rSet = null;
        try {
            ResultSet rSet = connection.prepareStatement("select * from pros").executeQuery();
            while (rSet.next()) {
                //get columns in table and puts it into your Pros list
                pros.add(new Pros(rSet.getInt("proId"), rSet.getString("name"), rSet.getString("profession"), rSet.getString("phoneNumber"), rSet.getString("email"), rSet.getInt("fee")));

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
        User newUser = mapper.readValue(req.getInputStream(), User.class);

        try {
            PreparedStatement stmt = connection.prepareStatement("select * from pros where proID = ?");
            stmt.setInt(1, newUser.getUserId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to insert:" + e.getMessage());
            e.printStackTrace();
        }

    }






}
