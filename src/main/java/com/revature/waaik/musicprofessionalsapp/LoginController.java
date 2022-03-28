package com.revature.waaik.musicprofessionalsapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;

import java.io.IOException;
@Controller
public class LoginController extends HttpServlet {

    private LoginRepo loginRepo;
    private ObjectMapper mapper;

    public LoginController(LoginRepo loginRepo, ObjectMapper mapper) {
        this.loginRepo = loginRepo;
        this.mapper = mapper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        User newUser = mapper.readValue(req.getInputStream(), User.class);

    }
}
