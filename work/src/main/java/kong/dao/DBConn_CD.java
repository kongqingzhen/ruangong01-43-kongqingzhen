package kong.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn_CD {
    private static Connection conn;
    private static String dburl = "jdbc:mysql://localhost:3306/book?&useSSL=false&serverTimezone=UTC";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        if (null==conn)
            conn= DriverManager.getConnection(dburl,"root","123456");
        return conn;
    }
}
