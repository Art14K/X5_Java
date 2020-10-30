import java.util.*;
public class DbLogger implements Logger {
    String message;
    public  void log(String message) {
        System.out.println("Log into database " + message);
    }
}