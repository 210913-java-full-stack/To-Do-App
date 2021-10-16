package servlets;

import models.ToDoItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import services.ToDoItemService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyLoaderListener implements ServletContextListener {
    SessionFactory sessionFactory;
    Session session;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        //Connection conn = ConnectionManager.getConnection();
        ToDoItemService.init();

        //Hibernate config and context initialization
        Configuration config = new Configuration();
        config.addAnnotatedClass(ToDoItem.class);
        ToDoItemService.setSessionFactory(config.buildSessionFactory());
        ToDoItemService.setSession(ToDoItemService.getSessionFactory().openSession());

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ToDoItemService.getSession().close();

    }
}