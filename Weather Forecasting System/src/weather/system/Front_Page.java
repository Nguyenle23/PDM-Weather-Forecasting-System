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
import java.lang.Thread;
import java.awt.event.*;

class Front_Page implements ActionListener{
    JFrame f; 
    JLabel id,l1;
    JButton b;

    Front_Page(){
 
        f=new JFrame("Weather Forecast System");        //create a Frame to hold all the objects
        f.setBackground(Color.red);
        f.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("\\weather\\system\\icon\\front.jpg"));      //load in the image
        Image i2 = i1.getImage().getScaledInstance(1360,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        
        l1.setBounds(0,150,1360,530);
        f.add(l1);


        b = new JButton("CLICK HERE TO CONTINUE");          //Button to get into the login screen
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        

        b.setBounds(500,600,300,70);
        b.addActionListener(this);

        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);
        
   

        JLabel lid=new JLabel("WEATHER FORECAST SYSTEM");           //Create a label for the frame
        lid.setBounds(80,30,1500,100);
        lid.setFont(new Font("serif",Font.PLAIN,70));
        lid.setForeground(Color.MAGENTA);
        id.add(lid);

        id.add(b);
        f.add(id);
        
        
        f.getContentPane().setBackground(Color.DARK_GRAY);      //set background color to white

        f.setVisible(true);                 //display the frame
        f.setSize(1360,750);                //frame size
        f.setLocation(0,10);                //frame location

        while(true){
            lid.setVisible(false); // lid =  j label
            try{
                Thread.sleep(500); //1000 = 1 second
            }catch(Exception e){} 
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }

    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){          //function to get to the login screen
            f.setVisible(false);
            new login();    
        }
    }

    public static void main(String[] arg){
        Front_Page f = new Front_Page();    //create the object to display the frame
    }
}