package views;

import utils.ViewManager;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * This abstract class is to be inherited and extended by the specific view classes
 */
public abstract class View {
    protected Scanner scanner;
    protected String viewName;
    protected ViewManager viewManager;

    public View(String viewName, Scanner scanner) {
        this.viewName = viewName;
        this.scanner = scanner;
        this.viewManager = ViewManager.getViewManager();
    }

    public String getViewName() {
        return viewName;
    }

    /**
     * This abstract method is to be implemented in extending classes and will contain most of the
     * I/O and code necessary to drive the app.
     *
     */
    public abstract void renderView() throws SQLException;
}
