package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException{

            String username = args[0];
            String password = args[1];
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind",
                    username, password);
            // create statement
// the statement is tied to the open connection
            // define your query
        String sql = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 2. Execute your query
            ResultSet resultSet = preparedStatement.executeQuery();

        System.out.printf("%-10s %-40s %-12s %-15s%n", "Product ID", "Product Name", "Unit Price", "Units In Stock");
// process the results
            while (resultSet.next()) {
                int productId = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName");
                double unitPrice = resultSet.getDouble("UnitPrice");
                int unitsInStock = resultSet.getInt("UnitsInStock");
                System.out.println("------------------------------------------------------------------------------");

                System.out.printf("%-10d %-40s $%-11.2f %-15d%n", productId, productName, unitPrice, unitsInStock);
                
            }
// 3. Close the connection
            connection.close();
    }
}