import java.util.*;
public class ConsoleLogger implements Logger {
    String message;
    public void log(String message) {
        System.out.println("Log into console " + message);
    }
}