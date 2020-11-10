import java.util.*;
import java.sql.*;

public class CreateDbSQL {
    private Connection connection;
    private String sql_query;
    private ResultSet result;
    private Statement statement;
    private int i = 0; // Переменная для подсчёта количества строк в базе данных


    CreateDbSQL(Connection connection) {
        this.connection = connection;
    }

    public void create() throws SQLException {
        sql_query = "SELECT FROM base;";
        try {
            statement = connection.createStatement();
            try {result = statement.executeQuery(sql_query);
                while(result.next()) {
                    i++;
                }
            } catch (SQLException exc) {
                System.out.println("База данных SQL отсутствует" + exc.getMessage());
            } finally {
                if (result != null) result.close();
            }
        } finally {
            if (statement != null) statement.close();
        }

        if (i == 0) {
            System.out.println("База данных отсутствует. Создаю новую базу....");
            sql_query = "CREATE TABLE base (Id SERIAL PRIMARY KEY, holder VARCHAR(40), amount DOUBLE PRECISION);";
        try {
            statement = connection.createStatement();
            try { statement.executeUpdate(sql_query);
                sql_query = "INSERT INTO base VALUES (1, 'Иван Петров', 18000);";
                statement.executeUpdate(sql_query);
                sql_query = "INSERT INTO base VALUES (2, 'Сергей Николаев', 186000);";
                statement.executeUpdate(sql_query);
                sql_query = "INSERT INTO base VALUES (3, 'Михаил Николаев', 29300);";
                statement.executeUpdate(sql_query);
                sql_query = "INSERT INTO base VALUES (4, 'Татьяна Николаева', 52300);";
                statement.executeUpdate(sql_query);
                sql_query = "INSERT INTO base VALUES (5, 'Ирина Никоненко', 86600);";
                statement.executeUpdate(sql_query);
                sql_query = "INSERT INTO base VALUES (6, 'Алексей Дмитриев', 12800);";
                statement.executeUpdate(sql_query);
                sql_query = "INSERT INTO base VALUES (7, 'Иван Соболев', 49600);";
                statement.executeUpdate(sql_query);
                sql_query = "INSERT INTO base VALUES (8, 'Михаил Дурманов', 56100);";
                statement.executeUpdate(sql_query);
                sql_query = "INSERT INTO base VALUES (9, 'Наталья Беляева', 120900);";
                statement.executeUpdate(sql_query);
                sql_query = "INSERT INTO base VALUES (10, 'Денис Алексеев', 42100);";
                statement.executeUpdate(sql_query);
                System.out.println("Создана новая база данных.");

            } catch (SQLException exc) {
                System.out.println("Не удалось создать таблицу : " + exc.getMessage());
            }
            finally {
                if (result != null) result.close();
            }
        } finally {
            if (statement != null) statement.close();
        } }
    }
}

