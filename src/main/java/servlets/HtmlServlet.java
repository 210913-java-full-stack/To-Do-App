package servlets;

import DAOs.ToDoItemDAO;
import models.ToDoItem;
import utils.ConnectionManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

public class HtmlServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter(""));


        try {
            Connection conn = ConnectionManager.getConnection();
            ToDoItemDAO toDoItemDAO = new ToDoItemDAO(conn);
            ToDoItem toDoItem = toDoItemDAO.getItemByID(id);
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println(toDoItem.toString());

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


    }

}
