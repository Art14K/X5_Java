import java.util.*;
import java.sql.*;
// Добавить интерфейс AccountService
public class UserOperationDbSQL {
    private Connection connection;
    private Statement statement;
    private ResultSet result;
    private String accountId;
    private double amount;
    private String sql_query;
    private String[] results = new String[3];// Массив для вывода в консоль данных
    private double[] amounts = new double[3];


    public UserOperationDbSQL(Connection connection) {
        this.connection = connection;

    }

public void balance(String accountId) throws SQLException {
    sql_query = "SELECT * FROM base WHERE id=" + accountId;
    try { statement = connection.createStatement();
        try {
            result = statement.executeQuery(sql_query);
            while (result.next()) {
                results[0] = result.getString("holder");
                results[1] = result.getString("id");
                results[2] = result.getString("amount");
                System.out.println();
                System.out.println("Владелец счёта: " + results[0]);
                System.out.println("Номер счёта: " + results[1] );
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

public void withdraw(String accountId, double amount) throws SQLException {
    sql_query = "SELECT * FROM base WHERE id=" + accountId;
    try {statement = connection.createStatement();
        try {
            result = statement.executeQuery(sql_query);
            amounts[0] = result.getDouble("amount");
            amounts[0] = amounts[0] - amount;
            sql_query = "UPDATE base SET amount = "+ amounts[0] + " WHERE id = " + accountId + ";";
            statement.executeUpdate(sql_query);
            System.out.println("Операция выполнена");
        } catch (SQLException exc) {
            System.out.println("Не удалось выполнить запрос к базе данных: " + exc.getMessage());
        } finally {
            if (result != null) result.close();
        }
    }  finally {
        if (statement != null) statement.close();
    }
}
}
