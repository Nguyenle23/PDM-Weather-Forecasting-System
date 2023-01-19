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

class Signup  implements ActionListener{

    JFrame f;
    JLabel l1,l2,l3;
    JTextField t1,t3;
    JPasswordField t2;
    JButton b1,b2;

    Signup(){

        f=new JFrame("Sign-up");        //create frame to hold objects

        f.setBackground(Color.white);   
        f.setLayout(null);

        l1 = new JLabel("Username");    //label for username
        l1.setBounds(40,20,100,30);
        f.add(l1);
        
        l2 = new JLabel("Password");    //label for password
        l2.setBounds(40,70,100,30);
        f.add(l2);
        
        l3 = new JLabel("Email");       //label for email
        l3.setBounds(40,120,100,30);
        f.add(l3);
 
        t1=new JTextField();            //text field for username
        t1.setBounds(150,20,150,30);
        f.add(t1);

        t2=new JPasswordField();        //text field for password
        t2.setBounds(150,70,150,30);
        f.add(t2);
        
        t3=new JTextField();            //text field for email
        t3.setBounds(150,120,150,30);
        f.add(t3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("\\weather\\system\\icon\\login.png"));  //load image
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        f.add(l3);


        b1 = new JButton("Sign-up");                //button for sign-up
        b1.setBounds(40,180,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");                   //button for cancel
        b2.setBounds(180,180,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);
        
        f.getContentPane().setBackground(Color.WHITE);     //set fram color to white

        f.setVisible(true);         //display the frame
        f.setSize(600,300);
        f.setLocation(400,300);

    }

    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1)
        try{
            
            if("".equals(t1.getText()) || "".equals(t2.getText()) || "".equals(t3.getText())){  //check if all the text field has been filled
                JOptionPane.showMessageDialog(null,"Please fill in all the information");
            }
            else{
            conn c1 = new conn();       //connection to the database
            String u = t1.getText();    //get text from username text field
            String v = t2.getText();    //get text from password text field
            String w = t3.getText();    //get text from email text field
            
            //sql statement to insert username,password,email with role as user into login table
            String q = "insert into login " +
                       "values ('"+u+"','"+v+"','user','"+w+"');"; 
            c1.s.executeUpdate(q); //execute the query
            JOptionPane.showMessageDialog(null,"Successfully Sign-up-ed");  //show a pop-up message to annouce successfully sign-up
            f.setVisible(false);            //stop displaying the sign-up screen
            new login().f.setVisible(true); //display the login screen
            }
        }
        catch(Exception ee){
                System.out.println("The error is:"+ee); //print the error to the console if there an error
        }
        else if(ae.getSource() == b2){
            new login().f.setVisible(true); //display the login screen
            f.setVisible(false);            //stop displaying the sign-up screen
        }
    }
    
    public static void main(String[] arg){
        Signup l=new Signup();
    }
}
