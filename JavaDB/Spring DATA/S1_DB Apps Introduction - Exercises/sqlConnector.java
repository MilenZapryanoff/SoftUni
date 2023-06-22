import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class sqlConnector {
    private static final String MYSQL_CONNECTION = "jdbc:mysql://localhost:3306/minions_db";
    private static final String MYSQL_DEFAULT_USERNAME = "root";
    private String user;
    private String password;

    static Connection buildConnection(String user, String password) throws SQLException {
        Connection connection =
                DriverManager.getConnection(MYSQL_CONNECTION, user, password);
        return connection;
    }

    protected static String getUser(Scanner scanner) {
        System.out.println("Please login to Database!");
        System.out.println("Default username is set to " + "\033[0;1m" + MYSQL_DEFAULT_USERNAME + "\033[0;0m");
        System.out.print("Press Enter to continue or use different username: ");

        String user = scanner.nextLine();
        if (user.equals("")) {
            user = MYSQL_DEFAULT_USERNAME;
        }
        return user;
    }

    protected static String getPassword(Scanner scanner) {
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return password;
    }
}
