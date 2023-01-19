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
import java.awt.event.*;
import javax.swing.*;

class View_wData implements ActionListener{

    JFrame f;
    JTextField t,t1;
    JLabel l1,l2,l3;
    JButton b,b2;

    View_wData(){
        f=new JFrame("View");
        f.setBackground(Color.green);
        f.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,500,270);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("\\weather\\system\\icon\\view.jpg"));
        l1.setIcon(img);


        l2=new JLabel("City");
        l2.setVisible(true);
        l2.setBounds(40,60,250,30);
        l2.setForeground(Color.white);
        Font F1 = new Font("serif",Font.BOLD,30);
        l2.setFont(F1); 
        l1.add(l2);
        f.add(l1);
        
        l3=new JLabel("Date");
        l3.setVisible(true);
        l3.setBounds(40,130,250,30);
        l3.setForeground(Color.white);
        Font F2 = new Font("serif",Font.BOLD,30);
        l3.setFont(F1); 
        l1.add(l3);
        f.add(l1);


        t=new JTextField();
        t.setBounds(240,60,220,30);
        l1.add(t);
        
        t1=new JTextField();
        t1.setBounds(240,130,220,30);
        l1.add(t1);

        b=new JButton("Search");
        b.setBounds(240,180,100,30);
        b.setForeground(Color.LIGHT_GRAY);
        b.setBackground(Color.darkGray);
        b.addActionListener(this);
        l1.add(b);

        b2=new JButton("Cancel");
        b2.setBounds(360,180,100,30);
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBackground(Color.darkGray);
        b2.addActionListener(this);
        l1.add(b2);

        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b2){
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b){
            f.setVisible(false);
            Print_Data p=new Print_Data(t.getText(),t1.getText()); //function to print out data
        }

    }

    public static void main(String[]ar){
        View_wData v=new View_wData();
    }
}