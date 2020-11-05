import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int start = 1;
        Scanner scan = new Scanner(System.in);
        String input;
        String[] Input = new String[5];
        int lenght_db;



        // Тест классов
        CreateDb createDb = new CreateDb("base.txt");
        createDb.createDb();
        lenght_db = createDb.lenghtDb();
        String[] base = new String[lenght_db];

        // Создать коллекцию и в неё добавить массив


        base = createDb.readDb(lenght_db);
        String str;


        List <Account> listBase = new ArrayList <Account>();
        for (int i = 0; i < lenght_db; i++) {
            str = base[i];

            String[] sub_str = str.split(":");
            Account account = new Account(i, sub_str[0], Double.parseDouble(sub_str[1]));
            listBase.add(account);
        }


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