package servlets;

import models.ToDoItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import services.HibernateService;
import services.ToDoItemService;
import utils.ConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Hibernate config and context initialization
        Session session = HibernateService.getSession();
        ToDoItemService.setSession(session);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateService.closeSession();
    }
}





