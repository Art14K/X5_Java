import java.util.*;
import java.io.*;

public class Account {
    private int id;
    private String holder;
    private double amount;

    Account(int id, String holder, double ammount) {
        this.id = id;
        this.holder = holder;
        this.amount = ammount;
    }


    public int getId() {
        return id;
    }

    public String getHolder() {
        return holder;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void printinfo() {
        System.out.println("Уникальный id счёта: " + id);
        System.out.println("Владелец счёта: " + holder);
        System.out.println("Сумма на счёте:" + amount);
    }
}