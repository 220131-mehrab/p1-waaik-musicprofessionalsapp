package com.revature.waaik.musicprofessionalsapp;

import com.revature.waaik.musicprofessionalsapp.Servlets.DefaultServlet;
import jakarta.servlet.http.HttpServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        HttpServlet proServlet = appContext.getBean(ProsController.class);
        HttpServlet userServlet = appContext.getBean(UserController.class);
        HttpServlet loginServlet = appContext.getBean(LoginController.class);
        Tomcat server = new Tomcat();
        server.getConnector();
        server.addContext("", null);


        server.addServlet("", "defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet("", "proServlet", proServlet).addMapping("/pros");
        server.addServlet("", "userServlet", userServlet).addMapping("/user");
        server.addServlet("","loginServlet", loginServlet).addMapping("/login");

            try {
                server.start();
            } catch (
                    LifecycleException e) {
                e.printStackTrace();
                System.err.println("Sorry server failed to start");
            }
        }
    }

