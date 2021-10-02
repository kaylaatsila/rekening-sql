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
        switch (driver){
            case("SQLITE"):{
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Library ada");
            conn = DriverManager.getConnection(SQCONN);
        } catch (ClassNotFoundException ex) {
            System.out.println("Library tidak ada");
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }break;
            }

            case("MYSQL"):{
         try {
             Class.forName("com.mysql.jdbc.Driver");
             System.out.println("Library ada");
             conn=DriverManager.getConnection(MYCONN,USERNAME,PASSWORD);
         } catch (ClassNotFoundException ex) {
             System.out.println("library tidak ada");
             Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE,null, ex);
         }break;
            }
            }
        return conn;
    }
    
    public static void createTable(Connection conn, String driver) throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Individu (idNasabah INT (10) PRIMARY KEY REFERENCES Nasabah (idNasabah) ON DELETE RESTRICT ON UPDATE CASCADE, nik INT (16), npwp INT (16));"
                         + "CREATE TABLE IF NOT EXISTS Nasabah (idNasabah INT (10) PRIMARY KEY, nama VARCHAR (100), alamat VARCHAR (100));"
                         + "CREATE TABLE IF NOT EXISTS Perusahaan (idNasabah INT (10) REFERENCES Nasabah (idNasabah) ON DELETE RESTRICT ON UPDATE CASCADE PRIMARY KEY, nib VARCHAR (100));"
                         + "CREATE TABLE IF NOT EXISTS Rekening (noRekening INT (10) PRIMARY KEY, saldo DOUBLE (16, 2), idNasabah INT (10) REFERENCES Nasabah (idNasabah) ON DELETE RESTRICT ON UPDATE CASCADE);";
    
                String sqls[] = sqlCreate.split(";");
        for (String sql : sqls) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
        }
    }
}
