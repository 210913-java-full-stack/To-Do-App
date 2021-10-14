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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        System.out.println("ToDoItem Servlet GET request...");

        List<ToDoItem> toDoItemList = ToDoItemService.getAllToDoItems();
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().write(mapper.writeValueAsString(toDoItemList));
        resp.setContentType("application/json");
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ToDoItem newItem = new ToDoItem();
        System.out.println("JSON received");
        newItem.setId(Integer.parseInt(req.getParameter("id")));
        newItem.setMessage(req.getParameter("message"));
        newItem.setComplete(Boolean.getBoolean("complete"));
        System.out.println("Item received");
        ToDoItemService.saveNewToDoItem(newItem);
    }
}
