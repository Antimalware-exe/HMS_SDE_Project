/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;
import java.sql.*;
/**
 *
 * @author dwive
 */
//DB name is hms + //uid is root + //password is Srh@1234
//Modularized connection provider class
public class ConnectionProvider 
{
    public static Connection getCon()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "Srh@1234");
            return con;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
}
