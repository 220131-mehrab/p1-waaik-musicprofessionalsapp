import com.revature.waaik.musicprofessionalsapp.Servlets.DefaultServlet;
import com.revature.waaik.musicprofessionalsapp.Servlets.hiredServlet;
import com.revature.waaik.musicprofessionalsapp.Servlets.proServlet;
import com.revature.waaik.musicprofessionalsapp.Servlets.userServlet;
import jakarta.servlet.http.HttpServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.startup.Tomcat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServerTest extends HttpServlet {
   // Tomcat server = new Tomcat();





    @Test
    public void ServletGetTest() throws LifecycleException {
       Tomcat server = new Tomcat();
        server.getConnector();
        server.addContext("", null);


        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:dbmain;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE", "wcp", "wcp");
        } catch (SQLException e) {
            System.err.println("Connection to DB failed");
            e.printStackTrace();
        }


       // server.addServlet("", "defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet("", "proServlet", new proServlet(connection)).addMapping("/pros");
        server.addServlet("", "userServlet", new userServlet(connection)).addMapping("/user");
        server.addServlet("", "hiredServlet", new hiredServlet(connection)).addMapping("/hired");

        try {
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
            System.err.println("Failed to start");
        }
        server.stop();
        System.out.println("Success");
    }
    }






