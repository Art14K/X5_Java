import java.sql.*;

public class ConnectionDBSQL {

    private static ConnectionDBSQL instance;
    private Connection connection;
    private String url;
    private String login;
    private String password;
    private String[] config;

    public ConnectionDBSQL(String[] config) throws SQLException {
        this.config = config;
        url = "jdbc:postgresql://" + config[11] + ":5432/" + config[9];
        login = config[5];
        password = config[7];
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Не удалось выполнить подключение к базе данных : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

}