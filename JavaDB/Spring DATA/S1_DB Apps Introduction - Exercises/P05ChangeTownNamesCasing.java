import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class P05ChangeTownNamesCasing {
    private static final String UPDATE_TOWN_NAMES = "update towns set name = upper(name) where country = ?";
    private static final String EXTRACT_TOWN_NAMES = "select * from towns where country = ?";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = sqlConnector.buildConnection(sqlConnector.getUser(scanner), sqlConnector.getPassword(scanner));

        System.out.println("Please enter a country name: ");
        String country = scanner.nextLine();

        updateTownNames(connection, country);
        ResultSet resultSet = extractTownNames(connection, country);

        ArrayList<String> towns = new ArrayList<>();
        while (resultSet.next()) {
            towns.add(resultSet.getString("name"));
        }
        printTowns(towns);

        connection.close();
    }

    private static void printTowns(ArrayList<String> towns) {
        if (towns.size() == 0) {
            System.out.println("No town names were affected.");
        } else {
            System.out.printf("%d town names were affected.%n", towns.size());
            System.out.println(towns);
        }
    }

    private static ResultSet extractTownNames(Connection connection, String country) throws SQLException {
        PreparedStatement extractNamesStatement = connection.prepareStatement(EXTRACT_TOWN_NAMES);
        extractNamesStatement.setString(1, country);
        ResultSet resultSet = extractNamesStatement.executeQuery();
        return resultSet;
    }

    private static void updateTownNames(Connection connection, String country) throws SQLException {
        PreparedStatement updateNamesStatement = connection.prepareStatement(UPDATE_TOWN_NAMES);
        updateNamesStatement.setString(1, country);
        updateNamesStatement.executeUpdate();
    }
}
