import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P08IncreaseMinionsAge {
    private static final String UPDATE_MINION = "update minions set age = age + 1, name = lower(name) where id = ?";
    private static final String EXTRACT_MINION_DATA = "select name, age from minions";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = sqlConnector.buildConnection(sqlConnector.getUser(scanner), sqlConnector.getPassword(scanner));

        System.out.print("Enter IDs (separated with space): ");
        String[] input = scanner.nextLine().split("\\s+");

        updateMinions(connection, input);

        printMinions(connection);
    }

    private static void updateMinions(Connection connection, String[] input) throws SQLException {
        for (String id : input) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MINION);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.executeUpdate();
        }
    }

    private static void printMinions(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(EXTRACT_MINION_DATA);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("age"));
        }
    }
}
