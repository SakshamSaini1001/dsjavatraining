import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample {
    public static void main(String[] args) {
        //establish database connection
        //1. url,username password database name
        String username = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/javatraining";
        //to make the connection
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Database connection established");

        } catch (SQLException e) {
            throw new RuntimeException("Database not connected" +e);
        }
    }
}
