/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Win
 */
public class WardDetails {

    private ResultSet ward_ResultSet = null;

    protected WardDetails() {
        String sql = "select * from ward_inventory";
        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            ward_ResultSet = stm.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    protected ResultSet getWardDetails() {
        return ward_ResultSet;
    }

}
