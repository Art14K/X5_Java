import java.util.*;
import java.io.*;
import java.sql.*;

public class ManagingConsole {
    private UserOperation userOperation;
    private List<Account> listBase;
    private AccountFileDataBaseManager createDb;
    private String[] Input;
    private String[] config;
    private Connection connection;
    private Scanner scan;

    public ManagingConsole(UserOperation userOperation, List<Account> listBase, AccountFileDataBaseManager createDb, String[] Input, String[] config) {
        this.userOperation = userOperation;
        this.listBase = listBase;
        this.createDb = createDb;
        this.Input = Input;
        this.config = config;
        Scanner scan = new Scanner(System.in);
        int lenght_db = createDb.lenghtDb();
        do {
            try {
                System.out.print("Введите команду (для выхода из программы введите exit): ");
                String input;
                input = scan.nextLine();
                Input = input.split(" ");
                switch (Input[0]) {
                    case "balance":
                        if (!config[1].equals("sql")) {
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
                        if (!config[1].equals("sql")) {
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
                        if (!config[1].equals("sql")) {
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
                        if (!config[1].equals("sql")) {
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
            } catch (NullPointerException exc) {
                exc.getMessage();
            }
        } while (!Input[0].equals("exit"));

    }
}
