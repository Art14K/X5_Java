import java.util.*;
import java.io.*;

public class UnknownAccountException extends Exception {

    public String toString() {
        String msg = "Ошибка! Аккаунта с таким id не существует!";
        return msg;
    }

}