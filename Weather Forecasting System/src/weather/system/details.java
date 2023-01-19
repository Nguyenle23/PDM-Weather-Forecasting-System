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

class details  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5;

    details(){
        f=new JFrame("Weather Detail");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("\\weather\\system\\icon\\details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,610,Image.SCALE_DEFAULT);
        l1.setIcon(i1);
        f.add(l1);

        l2 = new JLabel("Weather Details");
        l2.setBounds(430,20,200,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.black);
        l1.add(l2);

        b1=new JButton("Add");
        b1.setBounds(500,140,120,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setForeground(Color.LIGHT_GRAY);
        b1.setBackground(Color.darkGray);
        b1.addActionListener(this);
        l1.add(b1);


        b2=new JButton("View");
        b2.setBounds(500,80,120,40);    //500,80,120,40
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBackground(Color.darkGray);
        b2.addActionListener(this);
        l1.add(b2);
        
        b3=new JButton("View User");
        b3.setBounds(350,80,120,40);   //500,140,120,40
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.setForeground(Color.LIGHT_GRAY);
        b3.setBackground(Color.darkGray);
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("Update");
        b4.setBounds(500,200,120,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.setForeground(Color.LIGHT_GRAY);
        b4.setBackground(Color.darkGray);
        b4.addActionListener(this);
        l1.add(b4);
        
        b5=new JButton("Update User");
        b5.setBounds(350,140,120,40);   //500,200,120,40
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.setForeground(Color.LIGHT_GRAY);
        b5.setBackground(Color.DARK_GRAY);
        b5.addActionListener(this);
        l1.add(b5);

        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(350,150);

    }

    public void actionPerformed(ActionEvent ae){ //button to others screen
        if(ae.getSource()==b1){
            f.setVisible(false);
            new Add_wData();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new View_wData();
        }
        if(ae.getSource()==b4){
            f.setVisible(false);
            new Search_wData();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            View_User viewUser = new View_User();
            viewUser.setVisible(true);
        }
        if(ae.getSource()==b5){
            f.setVisible(false);
            new Update_User();
        }
    }

    public static void main(String[ ] arg){
        details d = new details();
    }
}