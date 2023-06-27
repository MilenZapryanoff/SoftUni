package com.company;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Lab_problem_solving {
    private static final String SQL_QUERY = "SELECT u.first_name, u.last_name,count(ug.id) as count from users as u, users_games ug where u.id = ug.user_id and user_name = ? group by 1,2";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        String user = getUser(scanner);
        String password = getPassword(scanner);

        Connection connection = getConnection(user, password);

        PreparedStatement preparedStatement =
                connection.prepareStatement(SQL_QUERY);

        String usernameInput = getUsernameInput(scanner, preparedStatement);

        int playedGames = 0;
        String fullName = "";

        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            fullName = result.getString("first_name") + " " + result.getString("last_name");
            playedGames = result.getInt("count");
        }
        printResult(usernameInput, playedGames, fullName);

        connection.close();
    }

    private static void printResult(String usernameInput, int playedGames, String fullName) {
        if (fullName.equals("")) {
            System.out.println("No such user exists");
        } else {
            System.out.printf("User: %s%n", usernameInput);
            System.out.printf("%s has played %d games", fullName, playedGames);
        }
    }

    private static String getUsernameInput(Scanner scanner, PreparedStatement preparedStatement) throws SQLException {
        System.out.print("Enter username: ");
        String usernameInput = scanner.nextLine().trim();
        preparedStatement.setString(1, usernameInput);
        return usernameInput;
    }

    private static String getPassword(Scanner scanner) {
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
        return password;
    }

    private static String getUser(Scanner scanner) {
        System.out.print("Enter username (default root): ");
        String user = scanner.nextLine();
        if (user.equals("")) {
            user = "root";
        }
        return user;
    }

    private static Connection getConnection(String user, String password) throws SQLException {
        Properties sqlCredentials = new Properties();
        sqlCredentials.setProperty("user", user);
        sqlCredentials.setProperty("password", password);

        Connection connection = DriverManager
//              .getConnection("jdbc:mysql://localhost:3306/diablo", sqlCredentials);
                .getConnection("jdbc:mysql://localhost:3306/diablo", user, password); //може да се ползва и така без properties
        return connection;
    }
}
