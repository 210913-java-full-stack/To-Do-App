package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.ToDoItem;
import repos.ToDoItemRepo;
import services.ToDoItemService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToDoItemServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("ToDoItem Servlet GET request...");

        List<ToDoItem> toDoItemList = ToDoItemService.getAllToDoItems();
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().write(mapper.writeValueAsString(toDoItemList));
        resp.setContentType("application/json");
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ToDoItem newItem = new ToDoItem();
        newItem.setId(-1);
        newItem.setMessage(req.getParameter("message"));
        newItem.setComplete(Boolean.parseBoolean(req.getParameter("complete")));

        try {
            ToDoItemRepo itemRepo = new ToDoItemRepo();
            itemRepo.save(newItem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
