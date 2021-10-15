package models;

import javax.persistence.*;

@Entity
@Table(name="to_do_item")
public class ToDoItem {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String message;

    @Column
    private boolean complete;


    public ToDoItem() {
        complete = false;
    }

    public ToDoItem(int id, String message, boolean complete) {
        this.id = id;
        this.message = message;
        this.complete = complete;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
