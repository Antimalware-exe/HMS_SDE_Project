/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.awt.HeadlessException;
import java.sql.*;
import java.time.Instant;
import javax.swing.JOptionPane;

/**
 *
 * @author Win
 */
public class MedicineDetails {

    public static void addNewMedicine(String drug_name, String drug_category, int drug_total_qty) {
                
        String sql = "insert into medicine_inventory(drug_name, drug_category, drug_total_qty, drug_added_on) values (?,?,?,?)";

        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, drug_name);
            ps.setString(2, drug_category);
            ps.setInt(3, drug_total_qty);
            ps.setTimestamp(4, Timestamp.from(Instant.now()));

            boolean isExecuted = ps.execute();

            if (isExecuted) {
                JOptionPane.showMessageDialog(null, "Drug/Medicine added successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Some error occurred");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet getMedicineDetails(int drug_id) {
        ResultSet rs = null;

        String sql = "select * from medicine_inventory where drug_id='" + drug_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    public static ResultSet getMedicineDetails(String drug_name) {
        ResultSet rs = null;

        String sql = "select * from medicine_inventory where drug_name='" + drug_name + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    public static ResultSet getMedicineDetails() {
        ResultSet rs = null;

        String sql = "select * from medicine_inventory";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    public static void updateMedicineData(int drug_id, String drug_name, String drug_category, int drug_total_qty) {
        String sql = "update medicine_inventory set drug_name='" + drug_name + "' drug_category='" + drug_category + "' drug_total_qty='" + drug_total_qty + "' where drug_id='" + drug_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            int isExecuted = stm.executeUpdate(sql);

            if (isExecuted == 1) {
                JOptionPane.showMessageDialog(null, "Drug data updated succesfully");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteMedicine(int drug_id) {
        String sql = "delete from medicine_inventory where drug_id='" + drug_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            int isExecuted = stm.executeUpdate(sql);

            if (isExecuted == 1) {
                JOptionPane.showMessageDialog(null, "Drug has been removed from the inventory");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
