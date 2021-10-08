
import DAOs.CarDAO;
import DAOs.ToDoItemDAO;
import models.CarModel;
import models.ToDoItem;
import utils.ConnectionManager;
import utils.ViewManager;


import java.sql.*;


//This is where our program starts, with the main method and contains the menus and primary loop.
public class Driver {
    public static void main(String[] args)  {

        try (Connection conn = ConnectionManager.getConnection()) {
            ToDoItemDAO dao = new ToDoItemDAO(conn);
            ToDoItem ts = dao.getItemByID(1);

            System.out.println(ts.toString());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }





        }

}

