import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int start = 1;
        Scanner scan = new Scanner(System.in);
        String input;
        String[] Input = new String[5];



        // Тест классов
        CreateDb createDb = new CreateDb("base.txt");
        createDb.createDb();
        while (start > 0) {
           try {
                System.out.print("Введите команду(для выхода из программы введите exit: ");
                input = scan.nextLine();
                Input = input.split(" ");
                switch (Input[0]) {
                    case "exit":
                        start = 0;

                   }
            } catch (ArrayIndexOutOfBoundsException exc) {
                System.out.println("Ошибка ввода!");
            }
                 
        }
    }
}