package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    public static Connection getCon() {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Define the connection URL
            String url = "jdbc:mysql://localhost:3308/inventory?useSSL=false&serverTimezone=UTC";
            String username = "root"; // Replace with your username
            String password = "soukaina123.."; // Replace with your password

            // Establish the connection
            Connection con = DriverManager.getConnection(url, username, password);
            return con;

        } catch (Exception e) {
            // Print error to the console
            System.out.println("Error in ConnectionProvider: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}