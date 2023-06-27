package com.company;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username (default root): ");
        String user = scanner.nextLine();
        if (user.equals("")) {
            user = "root";
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
        System.out.println();

        Properties sqlCredentials = new Properties();
        sqlCredentials.setProperty("user", user);
        sqlCredentials.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soft_uni", sqlCredentials);

        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM employees WHERE salary > ?");

        System.out.print("Enter min. salary: ");
        String salary = scanner.nextLine();
        preparedStatement.setDouble(1, Double.parseDouble(salary));
        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }
        connection.close();
    }
}