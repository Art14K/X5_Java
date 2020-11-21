import java.util.*;
import java.io.*;
import java.sql.*;

public class MyThreadSQL implements Runnable {
    private CreateDbSQL createDbSQL;
    private String thrdName;

    public MyThreadSQL(CreateDbSQL createDbSQL, String thrdName) {
        this.createDbSQL = createDbSQL;
        this.thrdName = thrdName;
    }

    public void run() {
        try {
        try {
            Thread.sleep(0);
            createDbSQL.create();
            
        } catch (InterruptedException ехс) {
            System.out.println(thrdName + " - прерван");
        }
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
    }
}