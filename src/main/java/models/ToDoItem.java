package models;

public class ToDoItem {

    private String toDoText;
    private boolean complete = false;

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public ToDoItem() {

    }

    public ToDoItem(String toDoText) {
        this.toDoText = toDoText;
    }

    public String getToDoText() {
        return toDoText;
    }

    public void setToDoText(String toDoText) {
        this.toDoText = toDoText;
    }
}
