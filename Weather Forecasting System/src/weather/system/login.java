/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.system;

/**
 *
 * @author Asus
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;

class login  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    public static JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3;

    login(){

        f=new JFrame("Login");          //create a frame to hold objects

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        f.add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        f.add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        f.add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("\\weather\\system\\icon\\login.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        f.add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);
        
        b3 = new JButton("Sign-up");
        b3.setBounds(110,180,120,30);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        f.add(b3);
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(400,300);

    }

    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1) //if button 1(login) is pressed
        try{
            conn c1 = new conn();       //get the connection to the database
            String u = t1.getText();    //get the text from Username text field
            String v = t2.getText();    //get the text from Password Password field
            
            //String for sql statement to display all the information that have the inputted username and password
            String q = "select * from login where username='"+u+"' and upassword='"+v+"'";
            
            //String for sql statement to display "role" of the inputted username and password
            String e = "select role from login where username='"+u+"' and upassword='"+v+"' and role = 'user'";
           
            PreparedStatement statement1 = c1.c.prepareStatement(q); //statement for q
            PreparedStatement statement2 = c1.c.prepareStatement(e); //statement for e
            
            ResultSet isRS1 = statement1.executeQuery();            //result set for statement1
            ResultSet isRS2 = statement2.executeQuery();            //result set for statement2
            
            if(isRS1.next()){           //check if input is valid (is part of the login table from database)
                isRS1.close();          //close to move to the other result set
                if(isRS2.next()){       //check if the input is an admin or an user
                    new detailsUser().f.setVisible(true);   //display the USER's details screen
                    f.setVisible(false);                    //stop displaying the login screen
                }
                else{
                    new details().f.setVisible(true);       //display the ADMIN's details screen
                    f.setVisible(false);                    //stop displaying the login screen
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid login");   //if the input is not part of the database then show the Message Dialog
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        else if(ae.getSource() == b3){ //Sign-up button
            new Signup().f.setVisible(true);    //display the signup screen
            f.setVisible(false);                //stop displaying the login screen
        }
        
    }
    
    public static String getUsername(){     //function to return the current User
        return t1.getText();
    }
    
    public static void main(String[] arg){  //create the object to display the login screen
        login l=new login();
    }
}
