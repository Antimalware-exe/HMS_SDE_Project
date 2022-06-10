/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;
import logic.ConnectionProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Win
 */
public class LoginHandler {
    
    public static boolean stmt(String username, String password){
        String sql = "select * from"+" user_login"+" where"+" username='"+username+"' and password='"+password+"'";
        try {
            //ESTABLISH CONNECTION TO DB
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            // hms query will run
            ResultSet rs = stm.executeQuery(sql);
//            System.err.println(rs.next());
//            if(!rs.next()){
//                con.close();
//                return false;
//            }
            return rs.next(); //If userid and password is correct then true
        } catch (SQLException ex) {
            Logger.getLogger(LoginHandler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
  }
