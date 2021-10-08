package servlets;

import DAOs.ToDoItemDAO;
import models.ToDoItem;
import utils.ConnectionManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ServletManager extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ToDoItem newItem = new ToDoItem();
        newItem.setId(Integer.parseInt(req.getParameter("id")));
        newItem.setMessage(req.getParameter("message"));
        newItem.setComplete(Boolean.parseBoolean(req.getParameter("complete")));

//        Connection conn = ConnectionManager.getConnection();
//        try {
//            ToDoItemDAO dao = new ToDoItemDAO(conn);
//            dao.save(newItem);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        System.out.println(newItem.getId()+" "+newItem.getMessage()+", "+newItem.isComplete());

        resp.setStatus(200);
    }

}
