import java.util.*;
import java.io.*;

public class UserOperation /*implements AccountService */ {
    private CreateDb createDb;
    private List<Account> collection;
    private int accountId;
    private int amount;
    private int from;
    private int to;
    //private boolean status;
    private String message;


    UserOperation(List<Account> collection, CreateDb createDb) {
        this.collection = collection;
        this.createDb = createDb;
    }

    public void balance(int accountId) /*throws UnknownAccountException */ {
        for (Account acc : collection) {
            if (acc.getId() == accountId) {
                System.out.println("Нашёл!");
                acc.printinfo();

            }/* else {
                message = "Такого аккаунта не существует!"
                throw new UnknownAccountException(String message);
            } */

        }



    }
    }



