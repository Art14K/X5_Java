import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        String[] Input = new String[5]; // Массив для преобразования строки
        int lenght_db; // Содержит длину массива




        CreateDb createDb = new CreateDb("base.txt");
        createDb.createDb();
        lenght_db = createDb.lenghtDb();
        String[] base = new String[lenght_db];
        base = createDb.readDb(lenght_db);



        List <Account> listBase = new ArrayList <Account>(); //Создаём коллекцию для хранения данных
        for (int i = 0; i < lenght_db; i++) {
            input = base[i]; // Преобразовываем элемент массива в строку
            String[] sub_str = input.split(":"); // Разбиваем строку по разделителю
            listBase.add(new Account(i, sub_str[0], Double.parseDouble(sub_str[1]))); // Добавляем элементы в коллекцию
        }
        System.out.println(listBase);

        UserOperation userOperation = new UserOperation(listBase, createDb); // Создаём класс для выполнения пользовательских операций
        while (Input[0] != "exit") {
           try {
                System.out.print("Введите команду(для выхода из программы введите exit: ");
                input = scan.nextLine();
                Input = input.split(" ");
                switch (Input[0]) {
                    case "exit":
                        Input[0] = "exit"; // при выходе из программы "кидает" исключение ArrayIndexOutOfBoundsException. Не смог разобраться почему
                    case "test":
                        userOperation.balance(Integer.parseInt(Input[1]));
                        break;

                    case "balance":
                        userOperation.balance(Integer.parseInt(Input[1]));
                        break;

                    case "tst":
                        userOperation.balance(Integer.parseInt(Input[1]));
                        break;

                    default:
                        break;
                   }


            } catch (ArrayIndexOutOfBoundsException exc) {

            }
                 
        }
    }
}