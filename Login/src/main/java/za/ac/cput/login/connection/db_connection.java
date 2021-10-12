/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.login.connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import za.ac.cput.login.user.admin.Admin;

/**
 *
 * @author User
 */
public class db_connection {
    
    public static java.sql.Connection derbeyConnection() throws SQLException{
    
        
        String URL = "jdbc:derby://localhost:1527/Booking";
        String name =  "cput";
        String password = "term4";
        
        return DriverManager.getConnection(URL, name, password);
        
    }

    public Admin getOne(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
