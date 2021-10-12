
package za.ac.cput.login.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import za.ac.cput.login.connection.db_connection;
import za.ac.cput.login.user.admin.Admin;
import za.ac.cput.login.user.admin.User;


public class DAOConnection {

    private final Connection con;
     //private final prepareStatement statement ;
     
     
     public DAOConnection() throws SQLException {
     this.con = db_connection.derbeyConnection();
     
     //this.statement = this.con.prepareStatement();
     }
     
     public User save (User user ) throws SQLException {

     String query = "insert into U (id_user, name_user, surname_user, email_user) values (?,?,?,?)";

     PreparedStatement ps = this.con.prepareStatement(query);
     ps.setInt(1,user.getId());
     ps.setString(2, user.getName());
     ps.setString(3, user.getSurname());
     ps.setString(4, user.getEmail());
     
     ps.executeUpdate();
     ps.close();
     return user ;
}
     
     public Admin save (Admin admin ) throws SQLException {

     String query = "insert into VENUE (name_venue, location_venue, type_venue, cost_venue, number_venue, availability_venue, date_venue) values (?,?,?,?)";

     PreparedStatement ps = this.con.prepareStatement(query);
     ps.setString(1,admin.getName());
     ps.setString(2, admin.getLocation());
      ps.setString(3, admin.getType());
     ps.setString(4, admin.getCost());
     ps.setInt(5, admin.getNumber());
      ps.setString(6, admin.getAvailability());
       ps.setString(7, admin.getDate());
    
     
     
     ps.executeUpdate();
     ps.close();
     return admin ;
     
     
     }
}
