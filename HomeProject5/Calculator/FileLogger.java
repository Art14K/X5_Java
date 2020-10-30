import java.util.*;
public class FileLogger implements Logger {
    String message;
    public void log(String message) {
        System.out.println("Log into file " + message);
    }
}