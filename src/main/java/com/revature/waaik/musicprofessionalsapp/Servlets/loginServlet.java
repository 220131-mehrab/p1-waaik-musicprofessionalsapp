package com.revature.waaik.musicprofessionalsapp.Servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.waaik.musicprofessionalsapp.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class loginServlet extends HttpServlet {
    private Connection connection;

    public loginServlet(Connection connection){this.connection = connection;}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
