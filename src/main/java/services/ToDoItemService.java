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
    private static SessionFactory sessionFactory;
    private static Session session;
    private static ToDoItemRepo toDoItemRepo;

    public static void init() {
        if (toDoItemRepo == null) {
            try {
                toDoItemRepo = new ToDoItemRepo();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ToDoItem getToDoItemById(int id) {
        return session.get(ToDoItem.class, id);
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

    public static void saveNewToDoItem(ToDoItem item) {
        System.out.println("DEBUG - Item saved: " + item.getId() +", " + item.getMessage() + ", " + item.isComplete());
        session.save(item);
    }

    public static void deleteToDoItem(ToDoItem item) {
        session.delete(item);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        ToDoItemService.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        ToDoItemService.session = session;
    }
}
