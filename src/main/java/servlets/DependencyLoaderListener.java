package servlets;

import utils.ConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection kahn = ConnectionManager.getConnection();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}