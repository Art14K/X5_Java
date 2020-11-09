import java.util.*;
import java.sql.*;

public class CreateDbSQL {
    private String[] config;
    private Connection connection;
    private String sql_query;
    private ResultSet result;
    private Statement statement;

    CreateDbSQL(String[] config, Connection connection) {
        this.config = config;
        this.connection = connection;
    }

    public void test() throws SQLException {
        try {
            sql_query = "CREATE TABLE customers (Id SERIAL PRIMARY KEY, FirstName CHARACTER VARYING(30), LastName CHARACTER VARYING(30), Email CHARACTER VARYING(30), Age INTEGER);";
            statement = connection.createStatement();
            try { result = statement.executeQuery(sql_query);
                System.out.println("Получилось!");
            } catch (SQLException exc) {
                System.out.println("Не удалось создать таблицу : " + exc.getMessage());
            }
            finally {
                if (result != null) result.close();
            }
        } finally {
            if (statement != null) statement.close();
        }
    }
}

