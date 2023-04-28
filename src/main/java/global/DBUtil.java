package global;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    // MySQL JDBC 드라이버 클래스 이름
    private static String driver = "com.mysql.cj.jdbc.Driver";

    // 데이터베이스 접속 정보
    private static String url = "jdbc:mysql://localhost:3306/checkcard";
    private static String username = "woori";
    private static String password = "woori1234";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}

