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

class Update_wData extends Add_wData implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b,b1,b2,b3; 
    String wCity,wDate;

    Update_wData(String city,String date){
        super(0);
        f=new JFrame("Update Weather Data");
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(450,250);
        f.setBackground(Color.white);
        f.setLayout(null);

        wCity=city;    
        wDate=date;
        id15=new JLabel();
        id15.setBounds(0,0,900,500);
        id15.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("\\weather\\system\\icon\\update.jpg"));
        Image i2 = img.getImage().getScaledInstance(1360,671,Image.SCALE_DEFAULT);
        id15.setIcon(img);

        id8 = new JLabel("Update Weather Data:");
        id8.setBounds(50,10,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,40));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);


        id1 = new JLabel("City:");  
        id1.setBounds(50,100,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,100,150,30);
        id15.add(t1);

        id2 = new JLabel("Date:");
        id2.setBounds(400,100,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,100,150,30);
        id15.add(t2);

        id3= new JLabel("MaxTemp:");
        id3.setBounds(50,150,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,150,150,30);
        id15.add(t3);

        id4= new JLabel("MinTemp:");
        id4.setBounds(400,150,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,150,150,30);   
        id15.add(t4);

        id5= new JLabel("Weather:");
        id5.setBounds(50,200,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,200,150,30);
        id15.add(t5);

        id6= new JLabel("FeelsLike:");
        id6.setBounds(400,200,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));    
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,200,150,30);
        id15.add(t6);

        id7= new JLabel("Wind:");
        id7.setBounds(50,250,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,250,150,30);
        id15.add(t7);

        id9= new JLabel("Humidity:");
        id9.setBounds(400,250,100,30);  
        id9.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id9);

        t8=new JTextField();
        t8.setBounds(600,250,150,30);
        id15.add(t8);

        id10= new JLabel("Rain Chance:");
        id10.setBounds(50,300,150,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id10);
        
        t9=new JTextField();
        t9.setBounds(200,300,150,30);
        id15.add(t9);
        
        id11= new JLabel("Rain Amount:");
        id11.setBounds(400,300,150,30);
        id11.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id11);
        
        t10=new JTextField();
        t10.setBounds(600,300,150,30);
        id15.add(t10);
        
        id12= new JLabel("UV:");
        id12.setBounds(50,350,150,30);
        id12.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id12);
        
        t11=new JTextField();
        t11.setBounds(200,350,150,30);
        id15.add(t11);

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

        showData(city,date);
    }

    int i=0;

    void showData(String w_City,String w_date){
        try{
            conn con = new conn();
            //sql statement to display all the data of w_city at w_date in the WeatherData table
            String str = "select * from WeatherData where wCity = '"+w_City+"' and wDate ='"+w_date+"' ";
            ResultSet rs = con.s.executeQuery(str);

            if(rs.next()){
                //get all the data from result set
                i=1;
                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(3));
                t4.setText(rs.getString(4));
                t5.setText(rs.getString(5));
                t6.setText(rs.getString(6));
                t7.setText(rs.getString(7));
                t8.setText(rs.getString(8));
                t9.setText(rs.getString(9));
                t10.setText(rs.getString(10));
                t11.setText(rs.getString(11));


            }
            if(i==0){
                JOptionPane.showMessageDialog(null,"City is not found");
                new Search_wData();
            }
        }catch(Exception ex){}
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(400,100);
    }

   public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b && i==1){
            try{
                conn con = new conn();
                //sql statement to update the new data from the input textfield to the WeatherData table
                String str = "update WeatherData set  (wCity = '"+t1.getText()+"'"
                        + ", wDate = '"+t2.getText()+"', MaxTemp = '"+t3.getText()+"'"
                        + ", MinTemp = '"+t4.getText()+"', Weather = '"+t5.getText()+"'"
                        + ", FeelsLike = '"+t6.getText()+"', Wind = '"+t7.getText()+"'"
                        + ", Humidity = '"+t8.getText()+"', RainChance = '"+t9.getText()+"'"
                        + ", RainAmount = '"+t10.getText()+"', UV = '"+t11.getText()+"';";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"successfully updated");
                f.setVisible(false);
                new Search_wData();
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
        new Update_wData("Update Data","Data");
    }
}
