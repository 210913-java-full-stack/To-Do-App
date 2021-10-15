package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.ToDoItem;
import services.ToDoItemService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoItemServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        System.out.println("ToDoItem Servlet GET request...");

        List<ToDoItem> toDoItemList = ToDoItemService.getAllToDoItems();
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().write(mapper.writeValueAsString(toDoItemList));
        resp.setContentType("application/json");
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ToDoItem newItem = new ToDoItem();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("JSON received");
        String requestData = req.getReader().lines().collect(Collectors.joining());
        newItem = mapper.readValue(requestData,ToDoItem.class);
        System.out.println(requestData);
        System.out.println("Item received");
        ToDoItemService.saveNewToDoItem(newItem);
    }
}
