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
        Connection connection; // Подключение к базе данных
        Statement statement;


        // Создаём массив с данными конфигурационного файла
        CreateConf createConf = new CreateConf();
        createConf.createConfig();
        config = createConf.getConfig();

        if (config[1].indexOf("sql") == -1) {
            System.out.println("Добро пожаловать!");
            System.out.println("Программа работает в файловом режиме");
        } else {
            try {
                ConnectionDbSQL connectionDbSQL = new ConnectionDbSQL(config);
                connection = connectionDbSQL.getConnection();
                CreateDbSQL createDbSQL = new CreateDbSQL(connection);
                createDbSQL.create();

            } catch (SQLException exc) {
                exc.getMessage();
            }
            System.out.println("Добро пожаловать!");
            System.out.println("Программа работает в режиме взаимодействия с sql - сервером");
        }


        CreateDb createDb = new CreateDb(config[3]);
        createDb.createDb();
        lenght_db = createDb.lenghtDb();
        String[] base = new String[lenght_db]; // Массив для хранения данных из файловой БД
        base = createDb.readDb(lenght_db);


        List<Account> listBase = new ArrayList<Account>(); //Создаём коллекцию для хранения данных
        for (int i = 0; i < lenght_db; i++) {
            input = base[i]; // Преобразовываем элемент массива в строку
            String[] sub_str = input.split(":"); // Разбиваем строку по разделителю
            listBase.add(new Account(i, sub_str[0], Double.parseDouble(sub_str[1]))); // Добавляем элементы в коллекцию
        }


        UserOperation userOperation = new UserOperation(listBase, createDb, lenght_db); // Создаём класс для выполнения пользовательских операций
        while (Input[0] != "exit") {
            try {
                System.out.print("Введите команду (для выхода из программы введите exit): ");
                input = scan.nextLine();
                Input = input.split(" ");
                switch (Input[0]) {
                    case "exit":
                        Input[0] = "exit"; // при выходе из программы "кидает" исключение ArrayIndexOutOfBoundsException. Не смог разобраться почему
                    case "test":
                        break;

                    case "balance":
                        if (config[1].indexOf("sql") == -1) {
                            try {
                                userOperation.balance(Integer.parseInt(Input[1]));
                            } catch (UnknownAccountException exc) {
                                System.out.println("Такого аккаунта не существует!");
                            }
                        } else {
                            try {
                                ConnectionDbSQL connectionDbSQL = new ConnectionDbSQL(config);
                                connection = connectionDbSQL.getConnection();
                                UserOperationDbSQL operationDbSQL = new UserOperationDbSQL(connection);
                                operationDbSQL.balance(Input[1]);
                            } catch (SQLException exc) {
                                System.out.println(exc.getMessage());
                            }
                        }
                        break;

                    case "withdraw":
                        if (config[1].indexOf("sql") == -1) {
                            try {
                                Input[2] = Input[2].replaceAll(",", ".");
                                userOperation.withdraw(Integer.parseInt(Input[1]), Double.parseDouble(Input[2]));
                            } catch (UnknownAccountException exc) {
                                System.out.println("Такого аккаунта не существует!");
                            } catch (NotEnoughMoneyException exc) {
                                System.out.println("На указанном счёте не достаточно средств");
                            }
                        } else {
                            try {
                                Input[2] = Input[2].replaceAll(",", ".");
                                ConnectionDbSQL connectionDbSQL = new ConnectionDbSQL(config);
                                connection = connectionDbSQL.getConnection();
                                UserOperationDbSQL operationDbSQL = new UserOperationDbSQL(connection);
                                operationDbSQL.withdraw(Input[1], Double.parseDouble(Input[2]));
                            } catch (SQLException exc) {
                                System.out.println(exc.getMessage());
                            } catch (NotEnoughMoneyException exc) {
                                System.out.println("На указанном счёте не достаточно средств");
                            } catch (UnknownAccountException exc) {
                                System.out.println("Аккаунта с указанный id не существует!");
                            }
                        }
                        break;


                    case "deposit":
                        if (config[1].indexOf("sql") == -1) {
                            try {
                                Input[2] = Input[2].replaceAll(",", ".");
                                userOperation.deposit(Integer.parseInt(Input[1]), Double.parseDouble(Input[2]));
                            } catch (UnknownAccountException exc) {
                                System.out.println("Такого аккаунта не существует!");
                            }
                        } else {
                            try {
                                Input[2] = Input[2].replaceAll(",", ".");
                                ConnectionDbSQL connectionDbSQL = new ConnectionDbSQL(config);
                                connection = connectionDbSQL.getConnection();
                                UserOperationDbSQL operationDbSQL = new UserOperationDbSQL(connection);
                                operationDbSQL.deposit(Input[1], Double.parseDouble(Input[2]));
                            } catch (SQLException exc) {
                                System.out.println(exc.getMessage());
                            } catch (UnknownAccountException exc) {
                                System.out.println("Аккаунта с указанный id не существует!");
                            }
                        }
                        break;


                    case "transfer":
                        if (config[1].indexOf("sql") == -1) {
                            try {
                                Input[3] = Input[3].replaceAll(",", ".");
                                userOperation.transfer(Integer.parseInt(Input[1]), Integer.parseInt(Input[2]), Double.parseDouble(Input[3]));
                            } catch (UnknownAccountException exc) {
                                System.out.println("На указанном счёте не достаточно средств");
                            } catch (NotEnoughMoneyException exc) {
                                System.out.println("На указанном счёте не достаточно средств");
                            }
                        } else {
                            try {
                                Input[3] = Input[3].replaceAll(",", ".");
                                ConnectionDbSQL connectionDbSQL = new ConnectionDbSQL(config);
                                connection = connectionDbSQL.getConnection();
                                UserOperationDbSQL operationDbSQL = new UserOperationDbSQL(connection);
                                operationDbSQL.transfer(Input[1], Input[2], Double.parseDouble(Input[3]));

                            } catch (SQLException exc) {
                                System.out.println(exc.getMessage());
                            } catch (UnknownAccountException exc) {
                                System.out.println("Аккаунта с указанный id не существует!");
                            } catch (NotEnoughMoneyException exc) {
                                System.out.println("На указанном счёте не достаточно средств");
                            }
                        }
                        break;


                    default:
                        break;
                }
            } catch (ArrayIndexOutOfBoundsException exc) {
                System.out.println("Ошибка получения значения одной из переменных!");
            } catch (NumberFormatException exc) {
                System.out.println("Ошибка синтаксиса!");
            }
        }
        createDb.updateDb(listBase);
    }
}
