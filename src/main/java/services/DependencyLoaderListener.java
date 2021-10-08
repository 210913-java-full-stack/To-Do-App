package services;

import utils.ConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

/**
 * This class is tied to the startup and shutdown of tomcat. Just implement
 *      the ServletContextListener and put whatever logic into the overridden
 *      methods. Make sure you inform tomcat of this class by including it
 *      in your deployment descriptor (web.xml) under the listener tag.
 */
public class DependencyLoaderListener implements ServletContextListener {
    Connection conn;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.conn = ConnectionManager.getConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
