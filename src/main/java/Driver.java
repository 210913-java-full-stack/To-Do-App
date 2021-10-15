
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ToDoItem;
import org.hibernate.cfg.Configuration;
import utils.ViewManager;


import java.sql.*;


//This is where our program starts, with the main method and contains the menus and primary loop.
public class Driver {
    public static void main(String[] args) {
//        Configuration config = new Configuration();
//        config.addAnnotatedClass(ToDoItem.class);

        String json = "{\"message\": \"test\", \"complete\": false}";
        ObjectMapper mapper = new ObjectMapper();
        ToDoItem item = null;
        try {
            item = mapper.readValue(json, ToDoItem.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(item);
        System.out.println(item.getId());
        System.out.println(item.getMessage());
        System.out.println(item.isComplete());


//        //viewManager
//        ViewManager viewManager = ViewManager.getViewManager();
//
//        //connection
//        //Connection conn = ConnectionManager.getConnection();
//
//
//        /**
//         * This is our main loop, it keep running until something sets the viewManager "running" flag = false;
//         * With every loop we invoke the viewManager singleton's goToNextView() method.
//         */
//        viewManager.navigate("MainMenu");
//        while(viewManager.isRunning()) {
//            try{
//                viewManager.goToNextView();
//            } catch(SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
    }
}

//        //////////////////////////////////////// This is tinkering
//        //Tinkering: in this example we are using the DAO statically
//        CarModel newCar = new CarModel();
//        newCar.setColor("black");
//        newCar.setMake("Nissan");
//        newCar.setModel("Sentra");
//        newCar.setYear(2012);
//        try {
//            CarDAO.save(newCar);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Auto incremented sequence ID assigned to car: " + newCar.getId());
//
//        //////////////////////////////////////

