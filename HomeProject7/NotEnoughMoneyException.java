import java.util.*;
import java.io.*;

public class NotEnoughMoneyException extends Exception {

    public String toString() {
        String msg = "На указанном счёье не достаточно средств!";
        return msg;
    }
}