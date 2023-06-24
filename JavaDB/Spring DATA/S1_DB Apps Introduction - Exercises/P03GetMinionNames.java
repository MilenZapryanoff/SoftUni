import java.sql.*;
import java.util.Scanner;

public class P03GetMinionNames {
    private static final String GET_MINION_NAMES = "SELECT v.name AS villain_name, " +
            "m.name, m.age FROM minions m, minions_villains mv, villains v " +
            "WHERE m.id = mv.minion_id AND v.id = mv.villain_id AND villain_id = ?";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection =
                sqlConnector.buildConnection(sqlConnector.getUser(scanner), sqlConnector.getPassword(scanner));

        PreparedStatement preparedStatement = connection.prepareStatement(GET_MINION_NAMES);
        final int villainInput = villainInput(scanner);
        preparedStatement.setInt(1, villainInput);

        ResultSet resultSet = preparedStatement.executeQuery();

        boolean villainPrinted = false;
        int counter = 1;

        while (resultSet.next()) {
            if (!villainPrinted) {
                System.out.println("Villain: " + resultSet.getString("villain_name"));
                villainPrinted = true;
            }
            System.out.println(counter + ". " + resultSet.getString("name") + " " + resultSet.getInt("age"));
            counter++;
        }
        if (!villainPrinted) {
            System.out.printf("No villain with ID %d exists in the database.%n", villainInput);
        }
        connection.close();
    }

    private static int villainInput(Scanner scanner) {
        System.out.print("Enter Villain ID: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
