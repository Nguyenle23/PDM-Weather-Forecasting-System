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

class detailsUser  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JButton b1,b2,b3,b4;

    detailsUser(){
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


        b1=new JButton("View");
        b1.setBounds(530,80,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setForeground(Color.LIGHT_GRAY);
        b1.setBackground(Color.darkGray);
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("Saved");
        b2.setBounds(530,140,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBackground(Color.darkGray);
        b2.addActionListener(this);
        l1.add(b2);
        
        b3=new JButton("User");
        b3.setBounds(530,200,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.setForeground(Color.LIGHT_GRAY);
        b3.setBackground(Color.darkGray);
        b3.addActionListener(this);
        l1.add(b3);

        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(350,150);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            new View_wData_User();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            Saved_wData saved = new Saved_wData();
            saved.setVisible(true);
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            new Update_User_user();
        }
    }

    public static void main(String[ ] arg){
        detailsUser d = new detailsUser();
    }
}