import java.util.*;
import java.io.*;
import java.sql.*;

public class ProgramInitialization {
    private CreateConf createConf;
    private String[] config = new String[20];
    private Connection connection;
    private Statement statement;


    public ProgramInitialization() {
        CreateConf createConf = new CreateConf();
        createConf.createConfig();
        config = createConf.getConfig();

        if (!config[1].equals("sql")) {
            System.out.println("Добро пожаловать!");
            System.out.println("Программа работает в файловом режиме");
        } else {
            try {
                ConnectionDbSQL connectionDbSQL = new ConnectionDbSQL(config);
                connection = connectionDbSQL.getConnection();
                CreateDbSQL createDbSQL = new CreateDbSQL(connection);
                MyThreadSQL myThreadSQL = new MyThreadSQL(createDbSQL, "sql_base");
                Thread newThrdSQL = new Thread(myThreadSQL);
                newThrdSQL.start();
            } catch (SQLException exc) {
                exc.getMessage();
            }
            System.out.println("Добро пожаловать!");
            System.out.println("Программа работает в режиме взаимодействия с sql - сервером");
        }
    }

    public String[] getConfig() {
        return config;
    }
}