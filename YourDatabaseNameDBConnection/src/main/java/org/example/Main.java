package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        YourDatabaseDBConnection.connect();

        if (YourDatabaseDBConnection.connection == null) {
            System.out.println("Database connection failed. Exiting program.");
            return;
        }

        try {
            String data = getAllCustomers();
            System.out.println("Current Customers:\n" + data);
        } catch (Exception e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        try {
            insertNewCustomer(customerId, firstName, lastName, address);
            System.out.println("New customer added successfully.");
        } catch (Exception e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }

        scanner.close();
    }

    public static String getAllCustomers() throws SQLException {
        Statement statement = YourDatabaseDBConnection.connection.createStatement();
        String query = "SELECT cust_id, first_name, last_name, address FROM SQL_Workbench.customer"; // Update table name
        ResultSet resultSet = statement.executeQuery(query);

        StringBuilder results = new StringBuilder();
        while (resultSet.next()) {
            results.append(resultSet.getInt(1)).append(" ")
                    .append(resultSet.getString(2)).append(" ")
                    .append(resultSet.getString(3)).append(" ")
                    .append(resultSet.getString(4)).append("\n");
        }
        return results.toString();
    }

    public static void insertNewCustomer(int customerId, String firstName, String lastName, String address) throws SQLException {
        String insertQuery = "INSERT INTO SQL_Workbench.customer (cust_id, first_name, last_name, address) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = YourDatabaseDBConnection.connection.prepareStatement(insertQuery);

        statement.setInt(1, customerId);
        statement.setString(2, firstName);
        statement.setString(3, lastName);
        statement.setString(4, address);

        statement.executeUpdate();
    }
}
