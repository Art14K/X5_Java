import java.util.*;
import java.io.*;

public class UserOperation implements AccountService {
    private Account account;

    UserOperation(Account account) {
        this.account = account;
    }
}