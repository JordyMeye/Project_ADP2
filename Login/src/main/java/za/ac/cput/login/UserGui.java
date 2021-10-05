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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class UserGui extends JFrame implements ActionListener{
    
    private JFrame mainframe3;
    private JPanel panelcenter , panelsouth;
    private JLabel lblid, lblname, lblsurname , lblemail;
    private JTextField txtid, txtname, txtsurname, txtemail;
    private JButton btnadd;
    
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
        
        btnadd= new JButton ("Goo");
                
        mainframe3.setSize(500,250);
 mainframe3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainframe3.setVisible(true);
    
    btnadd.setEnabled(true);
    
    }
    
    public void setGui(){
    
        panelcenter.setLayout( new GridLayout (4,2));
        panelsouth.setLayout ( new GridLayout (1,2));
        
        panelcenter.add(lblid);
        panelcenter.add(txtid);
        
        panelcenter.add(lblname);
        panelcenter.add(txtname);
        
        panelcenter.add(lblsurname);
        panelcenter.add(txtsurname);
        
        panelcenter.add(lblemail);
        panelcenter.add(txtemail);
        
        panelsouth.add(btnadd);
        
        
        mainframe3.add(panelcenter, BorderLayout.CENTER);
   mainframe3.add(panelsouth, BorderLayout.SOUTH);
   
   
   btnadd.addActionListener(this);
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         
    }
    
    public static void main(String[] args) {
        new UserGui().setGui();
    }
}
