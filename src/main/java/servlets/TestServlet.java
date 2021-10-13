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
        String testData = "[\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"message\": \"enjoy your new to do list!\",\n" +
                "        \"complete\": true,\n" +
                "        \"extra\": false\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"message\": \"Quit the app!\"\n" +
                "    }\n" +
                "]";
        resp.getWriter().write(testData);
        resp.setContentType("application/json");
        resp.setStatus(200);

    }
}