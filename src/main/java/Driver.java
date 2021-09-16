import models.ToDoItem;
import utils.PrintView;
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