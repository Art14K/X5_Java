import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int start = 1;
        Scanner scan = new Scanner(System.in);
        while (start > 0) {
            try {
                switch (args[0]) {
                    case "exit":
                        start = 0;
                    default:
                        args[0] = scan.nextLine();
                }
            } catch (ArrayIndexOutOfBoundsException exc) {
                System.out.println("Ошибка ввода!");
            } finally {
                args[0] = scan.nextLine();
            }
        }
    }
}