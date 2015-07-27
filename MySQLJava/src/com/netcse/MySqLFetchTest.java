package com.netcse;

import java.sql.*;

class MysqlFetch {

    public static void mysqlFetch(String DB_URL, String USER, String PASS) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");


            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;


            sql = "SELECT Username, Password, Role FROM table1";

            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String role = rs.getString("Role");

                //Display values
                System.out.print("Username: " + username);
                System.out.print(", Password: " + password);
                System.out.print(", Role: " + role);

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

}


public class MySqLFetchTest {

    // JDBC driver name and database URL
    // static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/my_db";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "netcse";

    public static void main(String[] args) {
        new MysqlFetch().mysqlFetch(DB_URL, USER, PASS);
    }//end main

}//end FirstExample