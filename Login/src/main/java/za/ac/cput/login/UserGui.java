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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import za.ac.cput.login.dao.DAOConnection;
import za.ac.cput.login.user.admin.User;


public class UserGui implements ActionListener{
    
    private JFrame mainframe3;
    private JPanel panelcenter , panelsouth;
    private JLabel lblid, lblname, lblsurname , lblemail;
    private JTextField txtid, txtname, txtsurname, txtemail;
    private JButton btngo , btnupdate, btnexit;
    
     private DAOConnection dao;
    
    public UserGui(){
    
        mainframe3 = new JFrame ("User Gui");
        panelcenter = new JPanel();
        panelsouth= new JPanel();
        lblid = new JLabel("ID:");
        lblname= new JLabel("Name:");
        lblsurname = new JLabel("Surname:");
        lblemail= new JLabel("Email:");
        txtid= new JTextField();
        txtname = new JTextField();
        txtsurname = new JTextField();
        txtemail = new JTextField();
        
        btngo= new JButton ("Goo");
        btnupdate= new JButton("Update");
    btnexit=new JButton("Exit");
    
        mainframe3.setSize(500,250);
 mainframe3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainframe3.setVisible(true);
    
    btngo.setEnabled(true);
    
    }
    
    public boolean CreateConnection(){
    
   try {
            dao= new DAOConnection();
            return true;
        } catch (SQLException ex) {
            
            Logger.getLogger(UserGui.class.getName()).log(Level.SEVERE, null, ex);
            
        }
   return false;
    }
    
    public void setGui(){
    
        panelcenter.setLayout( new GridLayout (4,2));
        panelsouth.setLayout ( new GridLayout (1,3));
        
        panelcenter.add(lblid);
        panelcenter.add(txtid);
        
        panelcenter.add(lblname);
        panelcenter.add(txtname);
        
        panelcenter.add(lblsurname);
        panelcenter.add(txtsurname);
        
        panelcenter.add(lblemail);
        panelcenter.add(txtemail);
        
        panelsouth.add(btngo);
        panelsouth.add(btnupdate);
        panelsouth.add(btnexit);
        
        mainframe3.add(panelcenter, BorderLayout.CENTER);
   mainframe3.add(panelsouth, BorderLayout.SOUTH);
   
   
   btngo.addActionListener(this);
   btnupdate.addActionListener(this);
    btnexit.addActionListener(this);
    
    }
 public void btngoActionPerformed(java.awt.event.ActionEvent e) throws SQLException {                                     
       
    } 
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btngo){
           
            User st = new User( Integer.parseInt(txtid.getText()), txtname.getText(), txtsurname.getText(), txtemail.getText() );
       
            try {
               if( CreateConnection()){ 
                   dao.save(st);
                   txtid.setText("");
                   txtname.setText("");                  
                   txtsurname.setText("");
                   txtemail.setText("");
                   
                   
                   JOptionPane.showMessageDialog(null, "User added successfully","Success",JOptionPane.PLAIN_MESSAGE);
               }
                
            } catch (SQLException ex) {
                Logger.getLogger(UserGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }if (e.getSource() ==btnexit){
        
            if ("".equals(txtid.getText())){
                JOptionPane.showMessageDialog(null, "Please enter a number before exiting","Erorr",JOptionPane.ERROR_MESSAGE);
            } else {
                if( CreateConnection()){
                    dao.deleteUser(Integer.parseInt(txtid.getText()));
                    txtid.setText("");
                    JOptionPane.showMessageDialog(null, "user left successfully","Success",JOptionPane.PLAIN_MESSAGE);
                }
            }
         
        if (e.getSource() == btnupdate){
        
            if( CreateConnection()){
                dao.deleteUser(Integer.parseInt(txtid.getText()));
                txtid.setText("");
                JOptionPane.showMessageDialog(null, "user updated successfully","Success",JOptionPane.PLAIN_MESSAGE);
            
            
            }}}}
        
        
        
    
    
    public static void main(String[] args) {
        new UserGui().setGui();
    }
}
