import models.TestModel;
import models.ToDoItem;
import utils.PrintView;
import utils.ConnectionManager;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.LinkedList;
import java.util.List;

public class Driver {


    public static void main(String[] args) {

        // View command line arguments passed to app
        for(int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        Scanner sc = new Scanner(System.in);

        List<ToDoItem> toDoList = new LinkedList<>();

//        ToDoItem newItem1 = new ToDoItem("Build a to do list");
//        toDoList.add(newItem1);
//
//        ToDoItem newItem2 = new ToDoItem("Debug the new to do list");
//        toDoList.add(newItem2);
//
//        ToDoItem newItem3 = new ToDoItem("enjoy your new to do list!");
//        toDoList.add(newItem3);

        try {


            Connection conn = ConnectionManager.getConnection();

            String sql = "SELECT a.account_id, a.balance FROM accounts a \n" +
                    "JOIN accounts_customers ac ON a.account_id = ac.account_id \n" +
                    "JOIN customers c ON ac.customer_id = c.customer_id \n" +
                    "JOIN address ad ON c.address_id = ad.address_id \n" +
                    "WHERE ad.state = \"NY\";";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<TestModel> resultList = new ArrayList<>();
            while(rs.next()) {
                TestModel temp = new TestModel();
                temp.setId(rs.getInt("account_id"));
                temp.setBalance(rs.getInt("balance"));
                resultList.add(temp);

            }
            for (TestModel tm : resultList) {
                System.out.println(tm);
            }
        } catch (SQLException | IOException  e) {
            e.printStackTrace();
        }


        boolean running = true;
        while (running){
            System.out.print("===MAIN MENU===\n1) View ToDo Items.\n2) Mark Item complete \n3) add item to the list\nQ) Quit the program");

            System.out.print("\n======================\nEnter selection: ");
            String input = sc.nextLine();

            switch (input){
                case "1":
                    System.out.println("============= To Do List: =============");
                    for (int i = 0; i < toDoList.size(); i++) {
                        PrintView.printMyView(i, toDoList.get(i));
                    }
                    System.out.println("=======================================");
                    break;
                case "2":
                    //mar item complete method
                    System.out.println("========== To Do List: ================");
                    for (int i = 0; i < toDoList.size(); i++) {
                        PrintView.printMyView(i, toDoList.get(i));
                    }
                    System.out.print("\nEnter item number to mark complete: ");
                    String choice = sc.nextLine();
                    toDoList.get(Integer.parseInt(choice)-1).setComplete(true);

                    System.out.println("\n Item #" + choice + " is complete!");
                    break;
                case "3":
                    System.out.print("Add a task to the list: ");
                    String newTask = sc.nextLine();
                    ToDoItem newItem = new ToDoItem(newTask);

                    toDoList.add(newItem);
                    System.out.println("\n'" + newTask + "' has been added to the list.");
                    break;
                case "Q":
                case "q":
                    running = false;
                    break;
            }
        }











    }
}