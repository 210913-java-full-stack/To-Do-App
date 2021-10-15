package servlets;

import models.ToDoItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import services.ToDoItemService;
import utils.ConnectionManager;

import javax.security.auth.login.AppConfigurationEntry;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

public class DependencyLoaderListener implements ServletContextListener {
    SessionFactory sessionFactory;
    Session session;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection conn = ConnectionManager.getConnection();
        ToDoItemService.init();

        Configuration config = new Configuration().configure("hibernate.properties");
        config.addAnnotatedClass(ToDoItem.class);
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        session.close();
    }
}