import java.util.*;
import java.io.*;

public class UserOperation implements AccountService {
    private CreateDb createDb;
    private List<Account> collection;
    private int accountId;
    private double amount;
    private int from;
    private int to;
    private int lenght_db; // Хранит размер базы данных
    private double temp_amount; // Служит для временного хранения значения amount в методе transfer
    private UnknownAccountException unknownAccountException;
    private NotEnoughMoneyException notEnoughMoneyException;


    UserOperation(List<Account> collection, CreateDb createDb, int lenght_db) {
        this.collection = collection;
        this.createDb = createDb;
        this.lenght_db = lenght_db;
    }


    public void balance(int accountId) throws UnknownAccountException {
        if (accountId > lenght_db)
            throw new UnknownAccountException();
        for (Account acc : collection) {
            if (acc.getId() == accountId) {
                acc.printinfo();
            }
        }
    }

    public void withdraw(int accountId, double amount) throws UnknownAccountException, NotEnoughMoneyException {
        if (accountId > lenght_db)
            throw new UnknownAccountException();
        for (Account acc : collection) {
            if (acc.getId() == accountId) {
                if (acc.getAmount() < amount) {
                    throw new NotEnoughMoneyException();
                }
                amount = acc.getAmount() - amount;
                acc.setAmount(amount);
            }
        }
    }

    public void deposit(int accountId, double amount) throws UnknownAccountException {
        if (accountId > lenght_db)
            throw new UnknownAccountException();
        for (Account acc : collection) {
            if (acc.getId() == accountId) {
                amount = acc.getAmount() + amount;
                acc.setAmount(amount);
            }
        }
    }

    public void transfer(int accountId, int to, double amount) throws UnknownAccountException, NotEnoughMoneyException {
        temp_amount = amount;
        if (accountId > lenght_db)
            throw new UnknownAccountException();

        // Снимаем с одного счёта
        for (Account acc : collection) {
            if (acc.getId() == accountId) {
                if (acc.getAmount() < amount) {
                    throw new NotEnoughMoneyException();
                }
                amount = acc.getAmount() - amount;
                acc.setAmount(amount);

            }
        }


        // Добавляем на другой
        for (Account ac : collection) {
            if (ac.getId() == to) {
                amount = ac.getAmount() + temp_amount;
                ac.setAmount(amount);
            }
        }
    }
}




