/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.login;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import za.ac.cput.login.connection.db_connection;
import za.ac.cput.login.dao.DAOConnection;
import za.ac.cput.login.user.admin.Admin;
import za.ac.cput.login.user.admin.User;

/**
 *
 * @author User
 */
public class AdminGui extends JFrame implements ActionListener, ItemListener {
    
    private JFrame mainframe2;
    
    private JPanel panelcenter , panelsouth;
    
    private JLabel lblname, lbllocation, lbltype , lblcost , lblmax , lblavailab , lbldate;
            
            private JTextField txtname , txtlocation ,  txtcost, txtmax, txtavailab, txtdate;
            
            private JComboBox ctype;
            
            private JButton btnadd;
    
            private DAOConnection duo;
    
    public AdminGui (){
        
        mainframe2 = new JFrame ("Benue Booking");
        panelcenter = new JPanel();
        panelsouth = new JPanel ();
        
        lblname= new JLabel("Name:");
        txtname = new JTextField (25);
        
        lbllocation = new JLabel("Location:");
        txtlocation = new JTextField (25);
        
        String [] choose = {"-no selction made-" , "hotel restaurant" , "conference centre" , "sport clubhouse", "community hall"};
        ctype = new JComboBox(choose);
        lbltype =new JLabel("Type");
        
        lblcost = new JLabel("Cost");
        txtcost = new JTextField (25);
        
        
        lblmax = new JLabel("Maximum Number:");
        txtmax = new JTextField (25);
        
        lblavailab = new JLabel("Availability:");
        txtavailab = new JTextField (25);
        
        lbldate = new JLabel("Date:");
        txtdate = new JTextField (25);
        
        
        
    
    btnadd= new JButton ("Add");
    
    
    mainframe2.setSize(800,450);
 mainframe2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainframe2.setVisible(true);
    
    btnadd.setEnabled(true);
    

}
    
     public boolean CreateConnection(){
    
   try {
            duo= new DAOConnection();
            return true;
        } catch (SQLException ex) {
            
            Logger.getLogger(AdminGui.class.getName()).log(Level.SEVERE, null, ex);
            
        }
   return false;
    }
    public void setGui(){
    
        panelcenter.setLayout( new GridLayout (7,2));
        panelsouth.setLayout ( new GridLayout (1,1));
        
        
        panelcenter.add(lblname);
        panelcenter.add(txtname);
        
        panelcenter.add(lbllocation);
        panelcenter.add(txtlocation);
        
        panelcenter.add(lbltype);
        panelcenter.add(ctype);
        
        panelcenter.add(lblcost);
        panelcenter.add(txtcost);
        
        panelcenter.add(lblmax);
        panelcenter.add(txtmax);
        
        panelcenter.add(lblavailab);
        panelcenter.add(txtavailab);
        
        panelcenter.add(lbldate);
        panelcenter.add(txtdate);
        
        panelsouth.add(btnadd);
        
        
        mainframe2.add(panelcenter, BorderLayout.CENTER);
   mainframe2.add(panelsouth, BorderLayout.SOUTH);
   
   
   btnadd.addActionListener(this);
         
            
    
    }
    
    public static void main(String[] args) {
        
        
        new AdminGui().setGui();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       /** if (e.getSource() == btnadd){
           
            
            if( CreateConnection()){
                //duo.save(ad);
                txtname.setText("");
                txtlocation.setText("");
                
                txtcost.setText("");
                txtmax.setText("");
                txtavailab.setText("");
                txtdate.setText("");
                
                
                JOptionPane.showMessageDialog(null, "Item inserted successfully","Success",JOptionPane.PLAIN_MESSAGE);
            }
        
        
        }
*/ 
        
}


    @Override
    public void itemStateChanged(ItemEvent e) {
        
        if (e.getSource() == btnadd){
        //ctype.getSelectedItem().toString();
        
        
         //if (e.getSource() == ctype) {

            // We must check that the combobox is not null and that we selected a valid item
            if (ctype.getSelectedItem() != null && !ctype.getSelectedItem().equals("-no-selection-made-")) {

                // Now we use the getOne method from the database to return a single vehicle object to work with
                Admin v = new db_connection().getOne(ctype.getSelectedItem().toString());

                // We set each text field to the corresponding value in our vehicle object
                txtname.setEnabled(true);
                txtname.setText(v.getName());

                txtlocation.setEnabled(true);
                txtlocation.setText(v.getLocation());

                txtcost.setEnabled(true);
                txtcost.setText(v.getCost());

                
                
                txtavailab.setEnabled(true);
                txtavailab.setText(v.getAvailability());
                
                txtdate.setEnabled(true);
                txtdate.setText(v.getDate());

                
            } else {

                // If our combobox is null or we dont have a valid selection, we return the form to its disabled state
                resetForm();
            }




        }
        
        }

    private void resetForm() {
        
        txtname.setEnabled(true);
                txtname.setText("");

                txtlocation.setEnabled(true);
                txtlocation.setText("");

                txtcost.setEnabled(true);
                txtcost.setText("");

                
                
                txtavailab.setEnabled(true);
                txtavailab.setText("");
                
                txtdate.setEnabled(true);
                txtdate.setText("");
    }
    }


    

