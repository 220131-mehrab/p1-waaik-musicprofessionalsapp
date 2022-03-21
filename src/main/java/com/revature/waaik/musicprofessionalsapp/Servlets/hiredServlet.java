package com.revature.waaik.musicprofessionalsapp.Servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.waaik.musicprofessionalsapp.Hired;
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
        List<Hired> hired = new ArrayList<>();
        //ResultSet rSet = null;
        try {
            ResultSet rSet = connection.prepareStatement("select hId from hired inner join pros on hired.hId=pros.proId;").executeQuery();
            while (rSet.next()) {
                //get columns in table and puts it into your Pros list
                hired.add(new Hired(rSet.getInt("hId"), rSet.getInt("uId")));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String results = mapper.writeValueAsString(hired); //write pros value as a string that you get from database
        resp.setContentType("/application/json");
        resp.getWriter().println(results);
    }
    //Getting info from the browser and posting it to the database on the browser
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        Hired newHired = mapper.readValue(req.getInputStream(), Hired.class);

        try {
            PreparedStatement stmt = connection.prepareStatement("insert into hired values (?,?)");
            stmt.setInt(1, newHired.gethId());
            stmt.setInt(2, newHired.getuId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to insert:" + e.getMessage());
            e.printStackTrace();
        }

    }






}
