import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        String str;
        String[] Input = new String[5]; // Массив для преобразования строки
        int lenght_db; // Содержит длину массива



        // Тест классов
        CreateDb createDb = new CreateDb("base.txt");
        createDb.createDb();
        lenght_db = createDb.lenghtDb();
        String[] base = new String[lenght_db];
        base = createDb.readDb(lenght_db);



        List <Account> listBase = new ArrayList <Account>();
        for (int i = 0; i < lenght_db; i++) {
            input = base[i]; // Преобразовываем элемент массива в строку
            String[] sub_str = input.split(":"); // Разбиваем строку по разделителю
            listBase.add(new Account(i, sub_str[0], Double.parseDouble(sub_str[1]))); // Добавляем элементы в коллекцию
        }


        while (Input[0] != "exit") {
           try {
                System.out.print("Введите команду(для выхода из программы введите exit: ");
                input = scan.nextLine();
                Input = input.split(" ");
                switch (Input[0]) {
                    case "exit":
                        Input[0] = "exit";

                   }
            } catch (ArrayIndexOutOfBoundsException exc) {
                System.out.println("Ошибка ввода!");
            }
                 
        }
    }
}