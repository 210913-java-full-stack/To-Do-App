package models;

import javax.persistence.*;

@Entity
@Table(name="To_Do_Items")
public class ToDoItem {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String message;

    @Column
    private boolean complete;



    public ToDoItem() {
        complete = false;
    }

    public ToDoItem(String message) {
        complete = false;
        this.message = message;
    }

    public ToDoItem(int id, String message, boolean complete) {
        this.id = id;
        this.message = message;
        this.complete = complete;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
