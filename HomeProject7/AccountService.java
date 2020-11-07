import java.util.*;

public interface AccountService {

    void withdraw(int accountId, double amount) throws
            NotEnoughMoneyException, UnknownAccountException;
    void balance(int accountId) throws UnknownAccountException;
    void deposit(int accountId, double amount) throws
            NotEnoughMoneyException, UnknownAccountException;
    void transfer(int from, int to, double amount) throws
            NotEnoughMoneyException, UnknownAccountException;

}