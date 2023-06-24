import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P04AddMinion {
    private static final String CHECK_TOWN = "select id from towns where name = ?";
    private static final String INSERT_TOWN = "insert into towns (name) value (?)";
    private static final String PRINT_TOWN = "Town %s was added to the database.%n";

    private static final String INSERT_VILLAIN = "insert into villains (name, evilness_factor) value (?,?)";
    private static final String CHECK_VILLAIN_ID = "select id from villains where name = ?";
    private static final String PRINT_VILLAIN = "Villain %s was added to the database.%n";

    private static final String INSERT_MINION = "insert into minions (name, age, town_id) value (?,?,?)";
    private static final String CHECK_MINION_ID = "select id from minions where name = ?";
    private static final String PRINT_MINION = "Successfully added %s to be minion of %s%n";

    private static final String CONNECT_MINION_TO_VILLAIN = "insert into minions_villains (minion_id, villain_id) value (?,?)";

    private static final String EVILNESS_FACTOR = "evil";
    private static int VILLAIN_ID;
    private static int MINION_ID;
    private static int TOWN_ID;

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection =
                sqlConnector.buildConnection(sqlConnector.getUser(scanner), sqlConnector.getPassword(scanner));

        System.out.println("Enter data: ");
        final String[] minionInput = scanner.nextLine().split("\\s+");
        final String minion = minionInput[1];
        final int age = Integer.parseInt(minionInput[2]);
        final String town = minionInput[3];
        final String[] villainInput = scanner.nextLine().split("\\s+");
        final String villain = villainInput[1];

        townProcessing(connection, town);
        villainProcessing(connection, villain);
        minionProcessing(connection, minion, age, villain);

        connection.close();
    }

    private static void minionProcessing(Connection connection, String minion, int age, String villain) throws SQLException {
        PreparedStatement insertMinion = connection.prepareStatement(INSERT_MINION);
        insertMinion.setString(1, minion);
        insertMinion.setInt(2, age);
        insertMinion.setInt(3, TOWN_ID);
        insertMinion.executeUpdate();

        extractMinionId(connection, minion);

        PreparedStatement connectMinionToVillain = connection.prepareStatement(CONNECT_MINION_TO_VILLAIN);
        connectMinionToVillain.setInt(1, MINION_ID);
        connectMinionToVillain.setInt(2, VILLAIN_ID);
        connectMinionToVillain.executeUpdate();
        System.out.printf(PRINT_MINION, minion, villain);
    }
    private static void townProcessing(Connection connection, String town) throws SQLException {

        PreparedStatement checkTown = connection.prepareStatement(CHECK_TOWN);
        checkTown.setString(1, town);
        ResultSet resultSet = checkTown.executeQuery();

        if (resultSet.next()) {
            extractTownId(resultSet);
        } else {
            PreparedStatement insertTown = connection.prepareStatement(INSERT_TOWN);
            insertTown.setString(1, town);
            insertTown.executeUpdate();

            resultSet = checkTown.executeQuery();
            if (resultSet.next()) {
                System.out.printf(PRINT_TOWN, town);
                extractTownId(resultSet);
            }
        }
    }
    private static void villainProcessing(Connection connection, String villain) throws SQLException {
        PreparedStatement checkVillain = connection.prepareStatement(CHECK_VILLAIN_ID);
        checkVillain.setString(1, villain);
        ResultSet resultSet = checkVillain.executeQuery();

        if (resultSet.next()) {
            extractVillainId(resultSet);
        } else {
            PreparedStatement insertVillain = connection.prepareStatement(INSERT_VILLAIN);
            insertVillain.setString(1, villain);
            insertVillain.setString(2, EVILNESS_FACTOR);
            insertVillain.executeUpdate();

            resultSet = checkVillain.executeQuery();
            if (resultSet.next()) {
                System.out.printf(PRINT_VILLAIN, villain);
                extractVillainId(resultSet);
            }
        }
    }

    private static void extractVillainId(ResultSet resultSet) throws SQLException {
        VILLAIN_ID = resultSet.getInt("id");
    }
    private static void extractTownId(ResultSet resultSet) throws SQLException {
        TOWN_ID = resultSet.getInt("id");
    }
    private static void extractMinionId(Connection connection, String minion) throws SQLException {
        PreparedStatement checkMinionId = connection.prepareStatement(CHECK_MINION_ID);
        checkMinionId.setString(1, minion);
        ResultSet resultSet = checkMinionId.executeQuery();
        resultSet.next();
        MINION_ID = resultSet.getInt("id");
    }

}
