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
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class Update_User extends Add_wData implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,id16;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    JButton b,b1,b2; 

    Update_User(){
        super(0);
        f=new JFrame("Update User Data");
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(200,150);
        f.setBackground(Color.white);
        f.setLayout(null);

        id15=new JLabel();
        id15.setBounds(0,0,900,500);
        id15.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("\\weather\\system\\icon\\update.jpg"));
        Image i2 = img.getImage().getScaledInstance(1360,671,Image.SCALE_DEFAULT);
        id15.setIcon(img);

        id8 = new JLabel("Update User Data:");
        id8.setBounds(50,10,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,40));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

        id2 = new JLabel("Password:");
        id2.setBounds(50,150,100,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(200,150,150,30);
        id15.add(t2);

        id3= new JLabel("Role:");
        id3.setBounds(50,200,100,30); 
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);//200,150,150,30
        id15.add(t3);

        id4= new JLabel("Email:");
        id4.setBounds(400,150,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,150,150,30);   
        id15.add(t4);

        b=new JButton("Update");
        b.setBounds(250,400,100,30);
        b.setForeground(Color.LIGHT_GRAY);
        b.setBackground(Color.darkGray);
        b.addActionListener(this);
        id15.add(b);

        b1=new JButton("Cancel");
        b1.setBounds(450,400,100,30);
        b1.setForeground(Color.LIGHT_GRAY);
        b1.setBackground(Color.darkGray);
        b1.addActionListener(this);
        id15.add(b1);
        
        b2=new JButton("Show");
        b2.setBounds(400,80,100,30);
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBackground(Color.darkGray);
        b2.addActionListener(this);
        id15.add(b2);
        
        id16= new JLabel("Username:");
        id16.setBounds(50,80,100,30);  
        id16.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id16);
        
        t12=new JTextField();
        t12.setBounds(200,80,150,30);
        id15.add(t12);
        
    }

    int i=0;
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
        try{
            conn con = new conn();
            //sql statement to display all the data of username input in the t12 text field in the login table
            String str = "select * from login where username = '"+t12.getText()+"'";
            ResultSet rs = con.s.executeQuery(str);

            if(rs.next()){
                i=1;
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(3));
                t4.setText(rs.getString(4));
            }
            if(i==0){
                JOptionPane.showMessageDialog(null,"User not found.");
            }
        }
        catch(Exception ex){}
        }
        
        if(ae.getSource()==b && i==1){
            try{
                conn con = new conn();
                //sql statement to update the data of the username input in the t12 text field to the login table
                String str = "update login set  upassword = '"+t2.getText()+"'"
                        + ", role = '"+t3.getText()+"', Email = '"+t4.getText()+"' where username ='"+t12.getText()+"';";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"successfully updated");
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        
        if(ae.getSource()==b1){
            f.setVisible(false);
            details d=new details();
        }
    }

    public static void main(String[] arg){
        new Update_User();
    }
}
