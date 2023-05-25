package isiunison.space.bd.utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorBD {
    private static String url = "jdbc:mysql://localhost:3306/rbac";
    private static String username = "root";
    private static String password = "Candela12";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
