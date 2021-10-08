package services;

import DAOs.ToDoItemDAO;
import collections.MyLinkedList;
import models.ToDoItem;
import utils.ConnectionManager;

import java.sql.SQLException;

public class PersistenceService {
    private static ToDoItem item;

    static {
        ToDoItemDAO toDoDAO = new ToDoItemDAO(ConnectionManager.getConnection());
        MyLinkedList<ToDoItem> items;

        try{
            items = toDoDAO.getAllItems();
            item = (items.get(1));
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static ToDoItem getData() {
        return item;
    }

    public static void setData(ToDoItem t) {
        item = t;
    }
}
