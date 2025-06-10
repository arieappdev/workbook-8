package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Set up connection variables
        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = "username";  // replace with your MySQL username
        String password = "password";  // replace with your MySQL password

        // 3. Create connection
        Connection connection = DriverManager.getConnection(url, username, password);

        // 4. PreparedStatement
        String query = "SELECT ProductName FROM products";
        PreparedStatement statement = connection.prepareStatement(query);

        // 5. Execute the query and get results
        ResultSet results = statement.executeQuery();

        // 6. Loop through results and print each product name
        while (results.next()) {
            String productName = results.getString("ProductName");
            System.out.println(productName);
        }

        // 7. Close all resources
        results.close();
        statement.close();
        connection.close();
    }
}

//        try {
//            // load the MySQL Driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            // 1. open a connection to the database
//// use the database URL to point to the correct database
//
//            String url = "jdbc:mysql://localhost.3306/northwind";
//            String username = "root";
//            String password = "yearup";
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind",
//                    username, password);
//            // create statement
//// the statement is tied to the open connection
//            Statement statement = connection.createStatement();
//            // define your query
//            String query = "SELECT ProductName FROM products";
//            // 2. Execute your query
//            ResultSet results = statement.executeQuery(query);
//// process the results
//            while (results.next()) {
//                String name = results.getString("ProductName");
//                System.out.println(name);
//            }
//// 3. Close the connection
//            connection.close();
//
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
