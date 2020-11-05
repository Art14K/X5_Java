import java.util.*;
import java.io.*;

public class Account {
    public int id;
    public String holder;
    public double amount;

    Account(int id, String holder, double ammount) {
        this.id = id;
        this.holder = holder;
        this.amount = ammount;
    }


    public int getId () {
        return id;
    }

    public String getHolder() {
        return holder;
    }

    public double getAmount() {
        return amount;
    }
}