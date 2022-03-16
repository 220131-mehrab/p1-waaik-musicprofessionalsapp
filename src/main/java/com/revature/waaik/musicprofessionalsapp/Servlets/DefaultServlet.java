package com.revature.waaik.musicprofessionalsapp.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class DefaultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String filename = req.getPathInfo();//Points to path of file from browser
        //System.out.println(filename);
        String resourceDir = "static";
        InputStream file = getClass().getClassLoader().getResourceAsStream(resourceDir + filename); //loads src data into backend from static folder
        String mimeType = getServletContext().getMimeType(filename); //checks for type of file being imported
        resp.setContentType(mimeType);
        assert file != null;
        IOUtils.copy(file, resp.getOutputStream()); //copies file from the input to server


    }
}
