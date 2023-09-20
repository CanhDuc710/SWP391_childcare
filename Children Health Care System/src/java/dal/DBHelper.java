/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHelper {

    public Connection connection;

    public DBHelper() {

        try {
            String username = "sa"; //username of the mySQL
            String password = "123456"; //password of the mySQL

            String url = "jdbc:sqlserver://localhost:1433;databaseName=SWP391_Database"; //name of the database

            //make connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(new DBHelper().connection);
        } catch (Exception e) {
            
        }
    }

}
