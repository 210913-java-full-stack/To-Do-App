package utils;

import collections.MyLinkedList;
import views.View;

public class ViewManager {
    private static ViewManager viewManager;
    private static View nextView;
    private MyLinkedList<View> viewList;

    private ViewManager() {
        viewManager = this;
    }

    public static ViewManager getViewManager() {
        if(viewManager == null) {
            viewManager = new ViewManager();
        }
        return viewManager;
    }

    public void navigate(String menu) {
        for(View view : viewList) {
            if(view.getMenu().equals(view)) {
                nextView = view;
            }
        }
    }

    public void goToNextView() {
        nextView.renderView();
    }



}
