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

/**
 *
 * @author User
 */
public class Gui extends JFrame implements ActionListener {
    
    private JFrame mainframe;
    private JPanel panelcenter, panelsouth;
    private JLabel lblname, lblpassword ;
    private JTextField txtname, txtpassword ;
    private JButton btnadmin, btnuser;
    
    public Gui (){
    
    mainframe = new JFrame ("Login");
    panelcenter = new JPanel ();
    panelsouth = new JPanel();
    lblname = new JLabel("Name:");
    lblpassword = new JLabel ("passwprd:");
    txtname = new JTextField(10);
    txtpassword = new JTextField(10);
    btnadmin = new JButton("Admin");
    btnuser = new JButton ("User");
    
    
     mainframe.setSize(500,250);
 mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainframe.setVisible(true);
    
    }
    
    public void setGui(){
    
    panelcenter.setLayout( new GridLayout (2,2));
        panelsouth.setLayout ( new GridLayout (1,2));
        
        panelcenter.add(lblname);
        panelcenter.add(txtname);
        
        panelcenter.add(lblpassword);
        panelcenter.add(txtpassword);
        
        
        panelsouth.add(btnadmin);
        panelsouth.add(btnuser);
        
        
         mainframe.add(panelcenter, BorderLayout.CENTER);
   mainframe.add(panelsouth, BorderLayout.SOUTH);
   
   
   btnadmin.addActionListener(this);
   //AdminGui gui2 = new AdminGui();
       
        
          btnuser.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if (e.getSource() == btnadmin){
            new AdminGui().setGui();
        
        }
        
        if (e.getSource() ==btnuser){
        new UserGui().setGui();
        }
    }
    
    
    
    public static void main(String[] args) {
        
        new Gui().setGui();
        
        
    }
}
