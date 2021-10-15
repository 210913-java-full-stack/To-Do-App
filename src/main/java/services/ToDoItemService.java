package services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repos.ToDoItemRepo;
import models.ToDoItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;

public class ToDoItemService {
    private static ToDoItemRepo toDoItemRepo;
    private static Session session;
    private static SessionFactory sessionfactory;

    public static void init() {
        if (toDoItemRepo == null) {
            try {
                toDoItemRepo = new ToDoItemRepo();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ToDoItem getToDoItemById(int id){
        return session.get(ToDoItem.class,id);
    }

    public static List<ToDoItem> getAllToDoItems() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ToDoItem> query = builder.createQuery(ToDoItem.class);
        Root<ToDoItem> root = query.from(ToDoItem.class);
        query.select(root);
        List<ToDoItem> allItems = session.createQuery(query).getResultList();
        return allItems;
    }

    public static void saveItem(ToDoItem item){
        session.save(item);
    }

    public static ToDoItemRepo getToDoItemRepo() {
        return toDoItemRepo;
    }

    public static void setToDoItemRepo(ToDoItemRepo toDoItemRepo) {
        ToDoItemService.toDoItemRepo = toDoItemRepo;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        ToDoItemService.session = session;
    }

    public static SessionFactory getSessionfactory() {
        return sessionfactory;
    }

    public static void setSessionfactory(SessionFactory sessionfactory) {
        ToDoItemService.sessionfactory = sessionfactory;
    }
}
