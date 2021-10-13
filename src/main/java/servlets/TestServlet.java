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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = Integer.parseInt(req.getParameter("num1"));
        int j = Integer.parseInt(req.getParameter("num2"));

        int k = i + j;

        System.out.println("Sum: " + k);

        resp.setContentType("text/plain");

        PrintWriter out = resp.getWriter();
        out.println("The sum is: " + k);
    }
}