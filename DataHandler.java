package com.example.firstjavafxproject;
import java.sql.*;

public class DataHandler {
    private String username;
    private String password;
    private int userCount;
    private String uname = "root";
    private String sqlPassword = "Coatesville21!";
    private String url = "jdbc:mysql://localhost:3306/database_name";
    private Connection myConn;
    private PreparedStatement myStmt;
    private ResultSet myRs;



    public void setUserN(String userN){
        username = userN;
        System.out.print(username);
    }
    public void setPass(String pass){
        password = pass;
        System.out.print(password);
    }

    public void storeUP() {
        try {
            // 1. Get A connection to database
            myConn = DriverManager.getConnection(url, uname, sqlPassword);
            // 2. Create a statment
            myStmt = myConn.prepareStatement("insert into login_info"
                    + "(userN, pass)" + "values (?, ?)");
            // 3. Set the statment
            myStmt.setString(1, username);
            myStmt.setString(2, password);
            // 4. Execute SQL query
            myStmt.executeUpdate();

            System.out.print(username + ", " + password + " is stored");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isUniqueUser() {
        try {
            // 1. Get A connection to database
            myConn = DriverManager.getConnection(url, uname, sqlPassword);
            // 2. Create a statment
            String query = "select * from login_info where userN=?";
            myStmt = myConn.prepareStatement(query);
            // 3. Set the statment
            myStmt.setString(1, username);
            // 4. Execute SQL query
            myRs = myStmt.executeQuery();

            if (myRs.next())
                return false;
            System.out.print("User is Unique");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean validLoginInfo() {
        try {
            // 1. Get A connection to database
            myConn = DriverManager.getConnection(url, uname, sqlPassword);
            // 2. Create a statment
            String query = "select pass from login_info where userN=?";
            myStmt = myConn.prepareStatement(query);
            // 3. Set the statment
            myStmt.setString(1, username);
            // 4. Execute SQL query
            myRs = myStmt.executeQuery();
            // System.out.println(myRs.next());
            if (myRs.next()) {
                if (myRs.getString("pass").equals(password)) {
                    System.out.println("Login successful");
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Username and password don't match");
        return false;
    }
}
