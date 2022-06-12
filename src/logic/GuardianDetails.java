/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Win
 */
public class GuardianDetails {

    public static void addGuardian(String g_fname, String g_lname, String g_gender, String g_country_code, int g_contact_number, int g_house_number, String g_street_name, String g_city, int g_zip, String g_state, String g_country, int g_relationship_id, int patient_id) {

        String query = "insert into guardian_details(g_fname, g_lname, g_gender, g_country_code, g_contact_number,g_house_number, g_street_name, g_city, g_zip, g_state , g_country, g_relationship_id, patient_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, g_fname);
            ps.setString(2, g_lname);
            ps.setString(3, g_gender);
            ps.setString(4, g_country_code);
            ps.setInt(5, g_contact_number);
            ps.setInt(6, g_house_number);
            ps.setString(7, g_street_name);
            ps.setString(8, g_city);
            ps.setInt(9, g_zip);
            ps.setString(10, g_state);
            ps.setString(11, g_country);
            ps.setInt(12, g_relationship_id);
            ps.setInt(13, patient_id);

            boolean isExecuted = ps.execute();

            if (isExecuted) {
                JOptionPane.showMessageDialog(null, "Guardian details added successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Some error occurred");
            }

        } catch (HeadlessException | SQLException e) {
        }
    }

    public static ResultSet getGuardian(int patient_id) {
        ResultSet rs = null;
        String sql = "select * from guardian_details where patient_id='" + patient_id + "'";
        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public static boolean updateGuardian(String g_fname, String g_lname, String g_gender, String g_country_code, long g_contact_number, int g_house_number, String g_street_name, String g_city, int g_zip, String g_state, String g_country, int g_relationship_id, int patient_id) {

        String sql = "update guardian_details set g_fname='" + g_fname + "', g_lname='" + g_lname + "', g_gender='" + g_gender + "', g_country_code='" + g_country_code + "', g_contact_number='" + g_contact_number + "', g_house_number='" + g_house_number + "', g_street_name='" + g_street_name + "', g_city='" + g_city + "', g_zip='" + g_zip + "', g_state='" + g_state + "', g_country='" + g_country + "', g_relationship_id='" + g_relationship_id + "' where patient_id='" + patient_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            int isExecuted = stm.executeUpdate(sql);

            if (isExecuted == 1) {
                JOptionPane.showMessageDialog(null, "Guardian data updated succesfully");
                return true;
            } else {
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static void delGuardian(int patient_id) {

        String sql = "DELETE FROM guardian_details WHERE patient_id = '" + patient_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            int isExecuted = stm.executeUpdate(sql);

            if (isExecuted == 1) {
                JOptionPane.showMessageDialog(null, "Guardian deleted succesfully");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getRelationshipID(String relationship_name) {
        int g_relationship_id = 1;

        String sql = "select * from relationship_details where relationship_name='" + relationship_name + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                g_relationship_id = rs.getInt("relationship_id");
            }
        } catch (SQLException e) {
            System.out.println("1: ");
            System.out.println(e.getMessage());
        }

        return g_relationship_id;
    }

    public static String getRelationshipName(int g_relationship_id) {
        String relationship_name = null;

        String sql = "SELECT relationship_name FROM relationship_details where relationship_id = " + g_relationship_id;

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                relationship_name = rs.getString("relationship_name");
            }
        } catch (SQLException e) {
            System.out.println("2: ");
            System.out.print(e.getMessage());
        }

        return relationship_name;
    }
}
