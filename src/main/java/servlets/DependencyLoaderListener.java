package servlets;

import services.ToDoItemService;
import utils.ConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection conn = ConnectionManager.getConnection();
        ToDoItemService.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}