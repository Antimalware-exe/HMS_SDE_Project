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
public class TriageDetails {

    private ResultSet triage_ResultSet = null;

    protected TriageDetails() {
        String sql = "select * from triage";
        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            triage_ResultSet = stm.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    protected ResultSet getTriageDetails() {
        return triage_ResultSet;
    }
}
