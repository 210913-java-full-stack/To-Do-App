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
        ToDoItemService.init();

        Configuration config = new Configuration();
        config.addAnnotatedClass(ToDoItem.class);
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        session.close();
    }
}