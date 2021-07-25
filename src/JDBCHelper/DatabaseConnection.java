/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuant
 */
public class DatabaseConnection {
    public static Connection getConnection(String databaseName, String username, String password) throws SQLException{
        String url = String.format("jdbc:sqlserver://localhost;Database=%s", databaseName);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static Connection getDBConnection() throws SQLException{
        String databaseName = "ThiTA";
        String username = "admin";
        String password = "123";
        String url = String.format("jdbc:sqlserver://localhost;Database=%s", databaseName);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
