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

public class userServlet extends HttpServlet {
    private Connection connection;

    public userServlet(Connection connection){
        this.connection = connection;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<User> user = new ArrayList<>();
        //ResultSet rSet = null;
        try {
            ResultSet rSet = connection.prepareStatement("select * from customer").executeQuery();
            while (rSet.next()) {
                //get columns in table and puts it into your Pros list
                user.add(new User(rSet.getInt("userId"), rSet.getString("userName"), rSet.getString("userEmail"), rSet.getString("userPassword"), rSet.getInt("userCreditCard"), rSet.getInt("userPick")));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String results = mapper.writeValueAsString(user); //write pros value as a string that you get from database
        resp.setContentType("/application/json");
        resp.getWriter().println(results);
    }
    //Getting info from the browser and posting it to the database on the browser
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        User newUser = mapper.readValue(req.getInputStream(), User.class);

        try {
            PreparedStatement stmt = connection.prepareStatement("insert into customer values (?,?,?,?,?)");
            stmt.setInt(1, newUser.getUserId());
            stmt.setString(2, newUser.getUserName());
            stmt.setString(3, newUser.getUserEmail());
            stmt.setString(4, newUser.getUserPassword());
            stmt.setLong(5, newUser.getUserCreditCard());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to insert:" + e.getMessage());
            e.printStackTrace();
        }

    }

}
