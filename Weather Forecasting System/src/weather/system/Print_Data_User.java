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

class Print_Data_User implements ActionListener{
    JFrame f;
    JLabel id8,id,aid,id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id9,id10,id11,id12,id13,id14,id15,id16,id17,lab;
    String wCity,wDate,MaxTemp,MinTemp,Weather,FeelsLike,Wind,Humidity,RainChance,RainAmount,UV;
    JButton b1,b2;
    ImageIcon icon;
    
    

    Print_Data_User(String w_City,String w_date){
        try{
            conn con = new conn();
            //sql statement to display all data of "w_City" and "w_date" in WeatherData table
            String str = "select * from WeatherData where wCity = '"+w_City+"' and wDate ='"+w_date+"' ";
            ResultSet rs= con.s.executeQuery(str);

            while(rs.next()){

               
                wCity = rs.getString("wCity");
                wDate = rs.getString("wDate");
                MaxTemp = rs.getString("MaxTemp");
                MinTemp = rs.getString("MinTemp");
                Weather = rs.getString("Weather");
                FeelsLike = rs.getString("FeelsLike");
                Wind = rs.getString("Wind");
                Humidity = rs.getString("Humidity");
                RainChance = rs.getString("RainChance");
                RainAmount = rs.getString("RainAmount");
                UV = rs.getString("UV");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
 
        f=new JFrame("Print Data");
        f.setVisible(true);
        f.setSize(595,642);
        f.setLocation(400,100);
        f.setBackground(Color.white);
        f.setLayout(null);


        id9=new JLabel();
        id9.setBounds(0,0,595,642);
        id9.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("\\weather\\system\\icon\\print.jpg"));
        id9.setIcon(img);

        id8 = new JLabel("Weather Details");
        id8.setBounds(50,10,250,30);
        f.add(id8);
        id8.setFont(new Font("serif",Font.BOLD,25));
        id9.add(id8);
        f.add(id9);

        id = new JLabel("City:");
        id.setBounds(50,70,120,30);
        id.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id);

        aid = new JLabel(wCity);
        aid.setBounds(200,70,200,30);
        aid.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid);

        id1 = new JLabel("Date:");
        id1.setBounds(50,120,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id1);

        aid1 = new JLabel(wDate);
        aid1.setBounds(200,120,300,30);
        aid1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid1);

  
        id2 = new JLabel("MaxTemp:"); 
        id2.setBounds(50,170,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id2);

        aid2 = new JLabel(MaxTemp);
        aid2.setBounds(200,170,300,30);
        aid2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid2);

        id3= new JLabel("MinTemp:");
        id3.setBounds(50,220,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id3);

        aid3= new JLabel(MinTemp);
        aid3.setBounds(200,220,300,30);
        aid3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid3);


        id4= new JLabel("Weather:");  
        id4.setBounds(50,270,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id4);

        aid4= new JLabel(Weather);
        aid4.setBounds(200,270,300,30); 
        aid4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid4);

        
        id5= new JLabel("FeelsLike:");
        id5.setBounds(50,320,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id5);

        aid5= new JLabel(FeelsLike);
        aid5.setBounds(200,320,300,30);
        aid5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid5);

        
        id6= new JLabel("Wind:");
        id6.setBounds(50,370,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id6);

        aid6= new JLabel(Wind);
        aid6.setBounds(200,370,300,30); 
        aid6.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid6);


        id7= new JLabel("Humidity:");
        id7.setBounds(50,420,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id7);

        aid7= new JLabel(Humidity);
        aid7.setBounds(200,420,300,30);
        aid7.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid7);

        
        b1=new JButton("Save");
        b1.setForeground(Color.LIGHT_GRAY);
        b1.setBackground(Color.darkGray);
        b1.setBounds(100,520,100,30);
        b1.addActionListener(this);
        id9.add(b1);

        b2=new JButton("Cancel");
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBackground(Color.darkGray);
        b2.setBounds(250,520,100,30);
        b2.addActionListener(this);
        id9.add(b2);


    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            try{
            conn cc = new conn();
                String q =  "INSERT INTO weatherSaved(username,wCity,wDate,MaxTemp,MinTemp,Weather,FeelsLike,Wind,Humidity,RainChance,RainAmount,UV) "
                        + "  SELECT a.username,b.wCity,b.wDate,b.MaxTemp,b.MinTemp,Weather,b.FeelsLike,b.Wind,b.Humidity,b.RainChance,b.RainAmount,UV"
                        + "  FROM login a, dbo.weatherData b"
                        + "  WHERE b.wCity = '"+wCity+"' and b.wDate = '"+wDate+"' and a.username = '"+login.getUsername()+"'";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Data Successfully Saved.");
                f.setVisible(false);
                new detailsUser();
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
    }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new detailsUser();
        }
    }
    public static void main(String[] args){
        new Print_Data_User("Print Data","Data");
    }

}
