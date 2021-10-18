
import utils.FileLogger;
import utils.ViewManager;


import java.sql.*;


//This is where our program starts, with the main method and contains the menus and primary loop.
public class Driver {
    public static void main(String[] args) {
        FileLogger.getFileLogger().console().threshold(0).writeLog("Test message", 0);
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

