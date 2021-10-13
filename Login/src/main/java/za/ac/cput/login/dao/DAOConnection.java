
package za.ac.cput.login.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
     
     public ArrayList<User> getAllUsers(){
        ArrayList<User> list = new ArrayList<>();

        try {
            PreparedStatement ps = this.con.prepareStatement("SELECT * from U");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                

                list.add(new User( id, name, surname, email));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
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
     
      public void updateUser(User user){
        try {
            PreparedStatement ps = this.con.prepareStatement("UPDATE U SET name=?, lastname=?, login=?, password=? WHERE id=?");
            ps.setInt(1,user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSurname());
            ps.setString(4, user.getEmail());
            

            int rowAffected = ps.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
       public void deleteUser(int id){
        try {
            PreparedStatement statement=this.con.prepareStatement("delete from users where id=?");
            statement.setInt(1, id);
            int rows=statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
