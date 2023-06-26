import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P07PrintAllMinionNames {

    private static final String GET_ALL_MINIONS = "select name from minions";
    private static final List<String> names = new ArrayList<>();

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = sqlConnector.buildConnection(sqlConnector.getUser(scanner), sqlConnector.getPassword(scanner));

        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_MINIONS);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            names.add(resultSet.getString("name"));
        }

        List<String> reversedNames = new ArrayList<>(names);
        Collections.reverse(reversedNames);

        printNames(reversedNames);

        connection.close();
    }

    private static void printNames(List<String> reversedNames) {
        for (int i = 0; i < names.size() / 2 ; i++) {
            System.out.println(names.get(i));
            System.out.println(reversedNames.get(i));
        }
    }
}
