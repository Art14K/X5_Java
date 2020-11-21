import java.util.*;
import java.io.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        String[] Input = new String[5]; // Массив для преобразования строки
        int lenght_db; // Содержит длину массива
        String[] config = new String[20]; // Массив содержит данные конфигурационного файла
        ProgramInitialization programInitialization;



        /* Создаём класс для базовой инициализации программы (создание файловой БД) */
        programInitialization = new ProgramInitialization();
        /* Получаем массив с данными конфигурационного файла */
        config = programInitialization.getConfig();




        AccountFileDataBaseManager createDb = new AccountFileDataBaseManager(config[3]);
        createDb.createDb();
        lenght_db = createDb.lenghtDb();
        /* Массив для хранения данных из файловой БД */
        String[] base = new String[lenght_db];
        base = createDb.readDb(lenght_db);
       

        /* Создаём коллекцию для хранения данных */
        List<Account> listBase = new ArrayList<Account>();
        for (int i = 0; i < lenght_db; i++) {
            /* Преобразовывем элемент массива в строку */
            input = base[i];
            /* Разбиваем строку по разделителю */
            String[] sub_str = input.split(":");
            listBase.add(new Account(i, sub_str[0], Double.parseDouble(sub_str[1]))); // Добавляем элементы в коллекцию
        }

        /* Создаём класс для выполнения пользовательских операций */
        UserOperation userOperation = new UserOperation(listBase, createDb, lenght_db);
        /* Создаём класс, содержащий логику управления консолью */
        ManagingConsole managingConsole = new ManagingConsole(userOperation, listBase, createDb, Input, config); //

    }
}
