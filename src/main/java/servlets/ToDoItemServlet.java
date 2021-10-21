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
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;
=======
import java.util.Scanner;
>>>>>>> 31e7d02c7d0ecf7d68b6c65cc8ee2a1562c8ec66

public class ToDoItemServlet extends HttpServlet {


    @Override
<<<<<<< HEAD
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        System.out.println("ToDoItem Servlet GET request...");

=======
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>>>>>>> 31e7d02c7d0ecf7d68b6c65cc8ee2a1562c8ec66
        List<ToDoItem> toDoItemList = ToDoItemService.getAllToDoItems();
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().write(mapper.writeValueAsString(toDoItemList));
        resp.setContentType("application/json");
        resp.setStatus(200);
    }

    @Override
<<<<<<< HEAD
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ToDoItem newItem = new ToDoItem();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("JSON received");
        String requestData = req.getReader().lines().collect(Collectors.joining());
        newItem = mapper.readValue(requestData,ToDoItem.class);
        System.out.println(requestData);
        System.out.println("Item received");
        ToDoItemService.saveNewToDoItem(newItem);
=======
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        if we need to invoke different logic depending on what's sent to this servlet
        we could accomplish this by sending along a header that tells us what the specifics of this request are.
         */
        String payloadType = req.getHeader("payload-type");
        switch(payloadType) {
            case "new-item":
                InputStream requestBody = req.getInputStream();
                Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
                String jsonText = sc.useDelimiter("\\A").next();
                //System.out.println("DEBUG - JSON Text: " + jsonText);
                ObjectMapper mapper = new ObjectMapper();
                ToDoItem payload = mapper.readValue(jsonText, ToDoItem.class);
                ToDoItemService.saveNewToDoItem(payload);
                resp.setStatus(202);
                break;
            case "something-else":
                break;
        }

>>>>>>> 31e7d02c7d0ecf7d68b6c65cc8ee2a1562c8ec66
    }


}
