package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    /*
    This will take a simple GET request and respond with "Pong!" and status 202, indicating the request was accepted.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().write(System.getProperty("HIBERNATE_DIALECT") + System.getProperty("HIBERNATE_CONNECTION_DRIVER_CLASS")
//        + System.getProperty("HIBERNATE_CONNECTION_USERNAME") + System.getProperty("HIBERNATE_CONNECTION_PASSWORD") + System.getProperty("HIBERNATE_HBM2DDL_AUTO")
//        + System.getProperty("HIBERNATE_CONNECTION_AUTOCOMMIT") +System.getProperty("HIBERNATE_SHOW_SQL") );
        resp.getWriter().write("test");
        resp.setContentType("plain/text");
        resp.setStatus(200);

    }
}