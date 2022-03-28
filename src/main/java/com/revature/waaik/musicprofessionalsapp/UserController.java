package com.revature.waaik.musicprofessionalsapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Controller
public class UserController extends HttpServlet {
    private UserRepo userRepo;
    private ObjectMapper mapper;

    public UserController(UserRepo userRepo, ObjectMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<User> user = new ArrayList<>();
        //ResultSet rSet = null;
        ObjectMapper mapper = new ObjectMapper();
        String results = mapper.writeValueAsString(user); //write pros value as a string that you get from database
        resp.setContentType("/application/json");
        resp.getWriter().println(results);
    }

        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ObjectMapper mapper = new ObjectMapper();
            User newUser = mapper.readValue(req.getInputStream(), User.class);


        }
    }