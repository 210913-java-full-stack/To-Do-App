package servlets;


import models.ToDoItem;
import repos.ToDoItemRepo;
import utils.ConnectionManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ToDoItem newItem = new ToDoItem();
        Connection kahn = ConnectionManager.getConnection();
        //newItem.setId(Integer.parseInt(req.getParameter("id")));
        newItem.setMessage(req.getParameter("task"));
        newItem.setComplete(Boolean.getBoolean("complete"));

        try {
            ToDoItemRepo dao = new ToDoItemRepo();
            dao.save(newItem);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}