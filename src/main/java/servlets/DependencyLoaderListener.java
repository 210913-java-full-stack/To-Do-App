package servlets;

<<<<<<< HEAD
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyLoaderListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {

=======
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
>>>>>>> b762675f4359691834b9eb352ea6941b195b4a5d
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}