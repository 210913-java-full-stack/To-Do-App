package services;

import org.hibernate.Session;
import models.ToDoItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ToDoItemService {
    private static Session session;

    public static ToDoItem getToDoItemById(int id) {
        return session.get(ToDoItem.class, id);
    }

    public static List<ToDoItem> getAllToDoItems() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ToDoItem> query = builder.createQuery(ToDoItem.class);
        Root<ToDoItem> root = query.from(ToDoItem.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static void saveNewToDoItem(ToDoItem item) {
        //System.out.println("DEBUG - Item saved: " + item.getId() +", " + item.getMessage() + ", " + item.isComplete());
        session.save(item);
    }

    public static void deleteToDoItem(ToDoItem item) {
        session.delete(item);
    }


    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        ToDoItemService.session = session;
    }
}
