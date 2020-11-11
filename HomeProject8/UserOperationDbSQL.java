import java.util.*;
import java.sql.*;

public class UserOperationDbSQL {
    private Connection connection;
    private Statement statement;
    private ResultSet result;
    private String accountId;
    private String to;
    private double amount;
    private String sql_query;
    private String[] results = new String[3];// Массив для вывода в консоль данных
    private double[] amounts = new double[3];


    public UserOperationDbSQL(Connection connection) {
        this.connection = connection;

    }

    public void balance(String accountId) throws SQLException {
        sql_query = "SELECT * FROM base WHERE id=" + accountId;
        try {
            statement = connection.createStatement();
            try {
                result = statement.executeQuery(sql_query);
                while (result.next()) {
                    results[0] = result.getString("holder");
                    results[1] = result.getString("id");
                    results[2] = result.getString("amount");
                    System.out.println();
                    System.out.println("Владелец счёта: " + results[0]);
                    System.out.println("Номер счёта: " + results[1]);
                    System.out.println("Сумма на счёте: " + results[2]);
                    System.out.println();
                }

            } catch (SQLException exc) {
                System.out.println("Не удалось выполнить запрос к базе данных: " + exc.getMessage());
            } finally {
                if (result != null) result.close();
            }
        } finally {
            if (statement != null) statement.close();
        }

    }

    public void withdraw(String accountId, double amount) throws SQLException, NotEnoughMoneyException, UnknownAccountException {
        sql_query = "SELECT * FROM base WHERE id = " + accountId;
        try {
            statement = connection.createStatement();
            try {
                result = statement.executeQuery(sql_query);
                if (result.next()) {
                    amounts[0] = result.getDouble("amount");
                    if (amounts[0] < amount) {
                        throw new NotEnoughMoneyException();
                    }
                    amounts[0] = amounts[0] - amount;
                    sql_query = "UPDATE base SET amount = '" + amounts[0] + "' WHERE id = '" + accountId + "';";
                    statement.executeUpdate(sql_query);
                    System.out.println("Операция выполнена");
                } else {
                    throw new UnknownAccountException();
                }

            } catch (SQLException exc) {
                System.out.println("Не удалось выполнить запрос к базе данных: " + exc.getMessage());
            } finally {
                if (result != null) result.close();
            }
        } finally {
            if (statement != null) statement.close();
        }
    }

    public void deposit(String accountId, double amount) throws SQLException, UnknownAccountException {
        sql_query = "SELECT * FROM base WHERE id = " + accountId;
        try {
            statement = connection.createStatement();
            try {
                result = statement.executeQuery(sql_query);
                if (result.next()) {
                    amounts[0] = result.getDouble("amount");
                    amounts[0] = amounts[0] + amount;
                    sql_query = "UPDATE base SET amount = '" + amounts[0] + "' WHERE id = '" + accountId + "';";
                    statement.executeUpdate(sql_query);
                    System.out.println("Операция выполнена");
                } else {
                    throw new UnknownAccountException();
                }
            } catch (SQLException exc) {
                System.out.println("Не удалось выполнить запрос к базе данных: " + exc.getMessage());
            } finally {
                if (result != null) result.close();
            }
        } finally {
            if (statement != null) statement.close();
        }
    }

    public void transfer(String accountId, String to, double amount) throws SQLException, UnknownAccountException, NotEnoughMoneyException {
        sql_query = "SELECT * FROM base WHERE id = " + accountId;
        try {
            statement = connection.createStatement();
            try {
                result = statement.executeQuery(sql_query);
                if (result.next()) {
                    amounts[0] = result.getDouble("amount");
                    amounts[2] = amounts[0];
                    if (amounts[0] < amount) {
                        throw new NotEnoughMoneyException();
                    }
                    amounts[0] = amounts[0] - amount;
                    sql_query = "UPDATE base SET amount = '" + amounts[0] + "' WHERE id = '" + accountId + "';";
                    statement.executeUpdate(sql_query);
                    sql_query = "SELECT * FROM base WHERE id = " + to;
                    result = statement.executeQuery(sql_query);
                    if (result.next()) {
                        amounts[1] = result.getDouble("amount");
                        amounts[1] = amounts[1] + amount;
                        sql_query = "UPDATE base SET amount = '" + amounts[1] + "' WHERE id = '" + to + "';";
                        statement.executeUpdate(sql_query);
                    } else {
                        System.out.println("Возвращаю счёт отправителя в исходное состояние...");
                        sql_query = "UPDATE base SET amount = '" + amounts[2] + "' WHERE id = '" + accountId + "';";
                        statement.executeUpdate(sql_query);
                        throw new UnknownAccountException();
                    }
                    System.out.println("Операция выполнена");
                } else {
                    throw new UnknownAccountException();
                }
            } catch (SQLException exc) {
                System.out.println("Не удалось выполнить запрос к базе данных: " + exc.getMessage());
            } finally {
                if (result != null) result.close();
            }
        } finally {
            if (statement != null) statement.close();
        }
    }
}

