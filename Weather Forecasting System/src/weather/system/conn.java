/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.system;

import java.sql.*;

public class conn{
    
    public Connection c;            //for easier access to connection, don't have to have multiple connection
    public Statement s;             //for easier access to statement to use for sql query
    
    public conn(){
     try{
            Class.forName("com.mysql.jdbc.Driver");         //Driver
            c = DriverManager.getConnection("jdbc:sqlserver://localhost:53494;databaseName=Weather;user=sa;password=sa");
            //connection string to the database
            s = c.createStatement();        //easier to createStament
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}