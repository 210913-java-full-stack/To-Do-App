
import utils.ViewManager;


import java.sql.*;


//This is where our program starts, with the main method and contains the menus and primary loop.
public class Driver {
    public static void main(String[] args) {
        //viewManager
        ViewManager viewManager = ViewManager.getViewManager();

        //connection
        //Connection conn = ConnectionManager.getConnection();


        /**
         * This is our main loop, it keep running until something sets the viewManager "running" flag = false;
         * With every loop we invoke the viewManager singleton's goToNextView() method.
         */
        viewManager.navigate("MainMenu");
        while(viewManager.isRunning()) {
            try{
                viewManager.goToNextView();
            } catch(SQLException e) {
                e.printStackTrace();
            }

        }
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

