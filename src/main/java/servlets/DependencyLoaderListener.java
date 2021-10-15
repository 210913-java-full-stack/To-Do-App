package servlets;

import models.ToDoItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import services.ToDoItemService;
import utils.ConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Connection conn = ConnectionManager.getConnection();
        ToDoItemService.init();

        //Hibernate config and context initialization
        Configuration config = new Configuration();
        config.addAnnotatedClass(ToDoItem.class);
        ToDoItemService.setSessionFactory(config.buildSessionFactory());
        ToDoItemService.setSession(ToDoItemService.getSessionFactory().openSession());

//        //add data to db?
//        ToDoItem toDoItem = new ToDoItem(55, "test message", false);
//        ToDoItemService.getSession().save(toDoItem);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ToDoItemService.getSession().close();

    }
}