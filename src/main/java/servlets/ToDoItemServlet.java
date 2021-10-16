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
        //TODO: Add in logic to accept new ToDoItems and call some service that will persist them.
        InputStream requestBody = req.getInputStream();
        Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
        String jsonText = sc.useDelimiter("\\A").next();
        System.out.println("DEBUG - JSON Text: " + jsonText);
        ObjectMapper mapper = new ObjectMapper();
        ToDoItem payload = mapper.readValue(jsonText, ToDoItem.class);
        ToDoItemService.saveNewToDoItem(payload);
    }


}
