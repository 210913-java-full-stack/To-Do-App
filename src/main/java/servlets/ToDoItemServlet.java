package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.ToDoItem;
import services.ToDoItemService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class ToDoItemServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<ToDoItem> toDoItemList = ToDoItemService.getAllToDoItems();
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().write(mapper.writeValueAsString(toDoItemList));
        resp.setContentType("application/json");
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        InputStream reqBody = req.getInputStream();
        Scanner sc = new Scanner(reqBody, StandardCharsets.UTF_8.name());
        String jsonText = sc.useDelimiter("\\A").next();
        ObjectMapper mapper = new ObjectMapper();
        ToDoItem payload = mapper.readValue(jsonText,ToDoItem.class);
        ToDoItemService.saveItem(payload);


        /*
        ToDoItem newItem = new ToDoItem();
        newItem.setMessage(req.getParameter("message"));
        newItem.setComplete(Boolean.parseBoolean(req.getParameter("complete")));

        ToDoItemService.saveItem(newItem);

         */
    }
}
