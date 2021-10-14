package services;

import repos.ToDoItemRepo;
import models.ToDoItem;

import java.sql.SQLException;
import java.util.List;

public class ToDoItemService {
    private static ToDoItemRepo toDoItemRepo;

    public static void init() {
        if(toDoItemRepo == null) {
            try {
                toDoItemRepo = new ToDoItemRepo();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static List<ToDoItem> getAllToDoItems() {
        try {
            return toDoItemRepo.getAllItems();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveNewToDoItem(ToDoItem item) {
        //TODO: FINISH THIS STUB
        
    }
}
