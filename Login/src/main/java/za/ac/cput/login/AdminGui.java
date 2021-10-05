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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class AdminGui extends JFrame implements ActionListener{
    
    private JFrame mainframe2;
    
    private JPanel panelcenter , panelsouth;
    
    private JLabel lblname, lbllocation, lbltype , lblcost , lblmax , lblavailab , lbldate;
            
            private JTextField txtname , txtlocation ,  txtcost, txtmax, txtavailab, txtdate;
            
            private JComboBox ctype;
            
            private JButton btnadd;
    
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
