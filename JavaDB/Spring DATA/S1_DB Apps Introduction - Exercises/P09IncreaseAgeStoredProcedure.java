import java.sql.*;
import java.util.Scanner;

public class P09IncreaseAgeStoredProcedure {
    private static final String CALL_PROCEDURE_TO_INCREASE_AGES = "CALL usp_get_older(?)";
    private static final String EXTRACT_MINION_DATA = "select name, age from minions where id = ?";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = sqlConnector.buildConnection(sqlConnector.getUser(scanner),
                sqlConnector.getPassword(scanner));

        System.out.print("Enter minion ID to increase age: ");
        String id = scanner.nextLine();

        updateMinion(connection, id);
        printMinion(connection, id);

        connection.close();
    }

    private static void updateMinion(Connection connection, String id) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(CALL_PROCEDURE_TO_INCREASE_AGES);
        callableStatement.setString(1, id);
        callableStatement.execute();
    }

    private static void printMinion(Connection connection, String id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(EXTRACT_MINION_DATA);
        preparedStatement.setInt(1, Integer.parseInt(id));
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("age"));
        }
    }
}
