package projekFinal.db;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHelper {

    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String SQCONN = "jdbc:sqlite:E:\\Database\\SQLite\\KMMI\\dbkoperasi.sqlite3";

    public static Connection getConnection(String driver) throws SQLException {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Library ada");
            conn = DriverManager.getConnection(SQCONN);
        } catch (ClassNotFoundException ex) {
            System.out.println("Library tidak ada");
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}