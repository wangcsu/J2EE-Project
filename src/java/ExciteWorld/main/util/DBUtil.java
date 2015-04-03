/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExciteWorld.main.util;

import ExciteWorld.main.bean.UserAccount;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Frank
 */
public class DBUtil {
    public static final String url = "jdbc:mysql://localhost:3306/ExciteWorld";
    public static final String username = "root";
    public static final String password = "19891016wk";
    
    public static void insert(UserAccount user){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(url, username, password);
            Statement myStmt = myConn.createStatement();
            
            String query = "INSERT INTO User (email, firstname, lastname, username, password) " +
                    "VALUES ('" + user.getEmail() + "'," + 
                            "'" + user.getFirstname() + "'," + 
                            "'" + user.getLastname() + "'," + 
                            "'" + user.getUsername() + "'," +
                            "'" + user.getPassword() + "')";
            myStmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static boolean emailExists(String emailAddress){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(url, username, password);
            Statement myStmt = myConn.createStatement();
            ResultSet rs = null;
            String query = "SELECT email FROM User WHERE email = " + emailAddress;
            rs = myStmt.executeQuery(query);
            return rs.next();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static ResultSet getUserAccounts(){
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(url, username, password);
            Statement myStmt = myConn.createStatement();
            rs = myStmt.executeQuery("SELECT * FROM User");
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public static void delete(UserAccount user){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = null;
            
            String query = "DELETE FROM User " + "WHERE email = ?";
            
            ps = myConn.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
