package views;

import utils.ViewManager;

import java.util.Scanner;

public abstract class View {
    protected Scanner scanner;
    protected String menu;
    protected ViewManager viewManager;

    public View(String menu, Scanner scanner) {
        this.menu = menu;
        this.scanner = scanner;
        this.viewManager = ViewManager.getViewManager();


    }

    public String getMenu() {
        return menu;
    }

    public abstract void renderView();
}
