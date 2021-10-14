package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.ToDoItem;
import services.ToDoItemService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        //super.doPost(req, resp);

        //TODO: Add in logic to accept new ToDoItems and call some service that will persist them.
    }
}
