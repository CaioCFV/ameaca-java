package Ameaca.Services;

import java.io.*;
import java.sql.*;

public class DatabaseConnection {

    private static final String _DB_NAME = "threatdata.db";
    private static Connection connection;

    public DatabaseConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            File databaseFile = new File(_DB_NAME);
            if (!databaseFile.exists()) {
                createDatabase();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void createDatabase() {
        try {
            connect();
            String cmd = "", s;
            Statement statement = connection.createStatement();
            File dumb = new File("dumpdb");
            FileInputStream fs = new FileInputStream(dumb);
            InputStreamReader sr = new InputStreamReader(fs);
            BufferedReader br = new BufferedReader(sr);
            while (!(s = br.readLine()).contains("EXIT")) {
                if (s.contains(";")) {
                    cmd += s;
                    statement.executeUpdate(cmd);
                    cmd = "";
                } else {
                    cmd += s;
                }
            }
            br.close();
            fs.close();
            sr.close();
            disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static Connection connect() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:sqlite:" + _DB_NAME);
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    private static void disconnect() {
        try {
            connection.close();
            connection = null;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public Connection getConnection() {
        connect();
        return connection;
    }

    public void closeConection() {
        disconnect();
    }
}
