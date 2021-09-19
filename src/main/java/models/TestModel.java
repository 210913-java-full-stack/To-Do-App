package models;

public class TestModel {

    private int id;
    private int balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public TestModel() {

    }

    public TestModel(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account number: " + this.id + " has a balance of " + this.balance +".";
    }
}
