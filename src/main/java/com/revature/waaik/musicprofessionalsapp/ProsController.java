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
public class ProsController extends HttpServlet {
    private ProsRepo prosRepo;
    private ObjectMapper mapper;
    public ProsController(ProsRepo prosRepo, ObjectMapper mapper){
        this.prosRepo = prosRepo;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Pros> pros = new ArrayList<>();
        //ResultSet rSet = null;

        ObjectMapper mapper = new ObjectMapper();
        String results = mapper.writeValueAsString(pros); //write pros value as a string that you get from database
        resp.setContentType("/application/json");
        resp.getWriter().println(results);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        Pros newPros = mapper.readValue(req.getInputStream(), Pros.class);


    }


}
