import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P06RemoveVillain {
    private static final String CHECK_VILLAIN_NAME = "select name from villains where id = ?";
    private static final String CHECK_MINIONS_COUNT = "select count(*) as count from minions_villains where villain_id = ?";

    private static final String RELEASE_MINIONS = "delete from minions_villains where villain_id = ?";
    private static final String DELETE_VILLAIN = "delete from villains where id = ?";

    private static final String PRINT_NO_VILLAIN_FOUND = "No such villain was found";
    private static final String PRINT_MINIONS_COUNT_DELETED = "%s minions released%n";
    private static final String PRINT_DELETED_VILLAIN = "%s was deleted%n";

    private static String VILLAIN_NAME;
    private static String MINIONS_COUNT;
    private static boolean VALID_VILLAIN_ID = true;


    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = sqlConnector.buildConnection(sqlConnector.getUser(scanner), sqlConnector.getPassword(scanner));

        System.out.println("Enter villain ID: ");
        int inputId = Integer.parseInt(scanner.nextLine());

        villainVerification(connection, inputId);

        if (!VALID_VILLAIN_ID) {
            return;
        }

        minionRelease(connection, inputId);
    }

    private static void villainVerification(Connection connection, int inputId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(CHECK_VILLAIN_NAME);
        preparedStatement.setInt(1, inputId);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            VILLAIN_NAME = resultSet.getString("name");
        } else {
            VALID_VILLAIN_ID = false;
            System.out.println(PRINT_NO_VILLAIN_FOUND);
        }
    }

    private static void minionRelease(Connection connection, int inputId) throws SQLException {
        PreparedStatement countMinions = connection.prepareStatement(CHECK_MINIONS_COUNT);
        countMinions.setInt(1, inputId);
        ResultSet countResultSet = countMinions.executeQuery();
        countResultSet.next();
        MINIONS_COUNT = countResultSet.getString("count");

        connection.setAutoCommit(false);

        try (PreparedStatement releaseMinions = connection.prepareStatement(RELEASE_MINIONS);
             PreparedStatement deleteVillain = connection.prepareStatement(DELETE_VILLAIN)) {

            releaseMinions.setInt(1, inputId);
            releaseMinions.executeUpdate();

            deleteVillain.setInt(1, inputId);
            deleteVillain.executeUpdate();

            connection.commit();

            System.out.printf(PRINT_DELETED_VILLAIN, VILLAIN_NAME);
            System.out.printf(PRINT_MINIONS_COUNT_DELETED, MINIONS_COUNT);
        }
    }
}
