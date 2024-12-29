package dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;

        try {
            // Get a connection
            con = ConnectionProvider.getCon();
            // Create a statement object
            st = con.createStatement();
            //st.executeUpdate("create table category(category_pk int AUTO_INCREMENT primary key, name varchar(200))");
            // st.executeUpdate("create table product(product_pk int AUTO_INCREMENT primary key, name varchar(200),quanitity int,price int,description varchar(500),category_fk int)");
            //st.executeUpdate("create table customer (customer_pk int AUTO_INCREMENT primary key, name varchar(200), mobileNumber varchar(200),email varchar(200))");
            st.executeUpdate("create table orderDetail (order_pk int AUTO_INCREMENT primary key, orderId varchar(200), customer_fk int,orderDate varchar(200),totalPaid int)");
            // Ensure the connection is not null
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
                return;
            }

            // Insert data into the appuser table
            String insertQuery = "INSERT INTO appuser (userRole, name, mobileNumber, email, password, address, status) "
                    + "VALUES ('SuperAdmin', 'Super Admin', '12345', 'superadmin@testemail.com', 'admin', 'MAROC', 'Active')";

            st.executeUpdate(insertQuery);

            JOptionPane.showMessageDialog(null, "Table Created successfully!");

        } catch (Exception e) {
            // Display error message
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                // Close resources
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
