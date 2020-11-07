import java.util.*;
import java.io.*;

public class NotEnoughMoneyException extends Exception {

    public String toString() {
        String msg = "На указанном счете не достаточно средств!";
        return msg;
    }
}