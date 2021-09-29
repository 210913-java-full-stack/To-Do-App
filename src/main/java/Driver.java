import DAOs.ToDoItemDAO;
import models.CarModel;
import models.TestModel;
import models.ToDoItem;
import utils.ConnectionManager;
import utils.PrintView;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//This is where our program starts, with the main method and contains the menus and primary loop.
public class Driver {
    public static void main(String[] args) {


        //Scanner object bound to System.in, the console input
        Scanner sc = new Scanner(System.in);

        List<ToDoItem> toDoList = new LinkedList<>();


        try (Connection conn = ConnectionManager.getConnection()){

            ToDoItem newItem = new ToDoItem("Build a UI for our app");
            ToDoItemDAO dao = new ToDoItemDAO(conn);
            dao.save(newItem);


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        boolean running = true;
        while(running) {
            System.out.println("===MAIN MENU===\nEnter selection:\n\n1) View ToDo Items.\n2) Mark item complete.\nQ) Quit");
            String input = sc.nextLine();

            switch(input) {
                case "1":
                    System.out.println("========== To Do List: ==========");
                    for(int i = 0; i < toDoList.size(); i++) {
                        PrintView.printMyView(i, toDoList.get(i));
                    }
                    System.out.println("=================================");
                    break;
                case "2":
                    //mark item complete method
                    System.out.println("========== To Do List: ==========");
                    for(int i = 0; i < toDoList.size(); i++) {
                        PrintView.printMyView(i, toDoList.get(i));
                    }
                    System.out.print("\nEnter item number to mark complete: ");
                    String choice = sc.nextLine(); //Or we could do sc.nextInt(); but then we need to consume the leftover newline character
                    toDoList.get(Integer.parseInt(choice)).setComplete(true);

                    System.out.println("\n Item #" + choice + " is complete!");

                    break;
                case "Q":
                case "q":
                    running = false;
                    break;
            }
        }
    }
}
