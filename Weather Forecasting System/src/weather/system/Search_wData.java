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

class Search_wData implements ActionListener{
    JFrame f;
    JTextField t,t2;
    JLabel l,l2,l5;
    JButton b,b2;

    Search_wData(){
        f=new JFrame("Search Data");
        f.setBackground(Color.green);
        f.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,500,270);
        l5.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("\\weather\\system\\icon\\view.jpg"));
        l5.setIcon(img);

        l=new JLabel("City");
        l.setVisible(true);
        l.setBounds(40,50,250,30);
        l.setForeground(Color.white);
        Font F1=new Font("serif",Font.BOLD,25);
        l.setFont(F1); 
        l5.add(l);
        f.add(l5);

        t=new JTextField();
        t.setBounds(240,50,220,30);
        l5.add(t);
        
        l2=new JLabel("Date");
        l2.setVisible(true);
        l2.setBounds(40,120,250,30);
        l2.setForeground(Color.white);
        Font F2=new Font("serif",Font.BOLD,25);
        l2.setFont(F1); 
        l5.add(l2);
        f.add(l5);

        t2=new JTextField();
        t2.setBounds(240,120,220,30);
        l5.add(t2);

        b=new JButton("Search");
        b.setBounds(240,180,100,30);
        b.setForeground(Color.LIGHT_GRAY);
        b.setBackground(Color.darkGray);
        b.addActionListener(this);
        l5.add(b);


        b2=new JButton("Cancel");
        b2.setBounds(360,180,100,30);
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBackground(Color.darkGray);
        b2.addActionListener(this);
        l5.add(b2);

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
            new Update_wData(t.getText(),t2.getText()); //run the function Update_wData
        }

    }
    
    public static void main(String[]ar){
        Search_wData search = new Search_wData();
    } 	
}