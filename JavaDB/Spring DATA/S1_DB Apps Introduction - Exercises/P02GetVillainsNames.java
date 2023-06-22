import java.sql.*;
import java.util.Scanner;

public class P02GetVillainsNames {
    private static final String GET_VILLAINS_NAMES = "SELECT v.name, count(distinct mv.minion_id) as count " +
            "FROM villains v, minions_villains mv where mv.villain_id = v.id " +
            "group by 1 having count > ? order by 2 desc";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Connection connection =
                sqlConnector.buildConnection(sqlConnector.getUser(scanner), sqlConnector.getPassword(scanner));

        PreparedStatement preparedStatement = connection.prepareStatement(GET_VILLAINS_NAMES);
        preparedStatement.setInt(1, 15);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getInt("count"));
        }
        connection.close();
    }
}