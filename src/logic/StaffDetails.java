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
public class StaffDetails {

    public static void addStaff(String s_fname, String s_lname, String s_gender, String s_country_code, long s_contact_number, String s_email_address, int s_house_number, String s_street_name, String s_city, int s_zip, String s_state, String s_country, String s_specialization, String s_qualification, String s_category) {

        String sql = "insert into staff_details(s_fname, s_lname, s_gender, s_country_code, s_contact_number, s_email_address, s_house_number, s_street_name, s_city, s_zip, s_state, s_country, s_status, s_specialization, s_qualification, s_category) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s_fname);
            ps.setString(2, s_lname);
            ps.setString(3, s_gender);
            ps.setString(4, s_country_code);
            ps.setLong(5, s_contact_number);
            ps.setString(6, s_email_address);
            ps.setInt(7, s_house_number);
            ps.setString(8, s_street_name);
            ps.setString(9, s_city);
            ps.setInt(10, s_zip);
            ps.setString(11, s_state);
            ps.setString(12, s_country);
            ps.setString(13, "active");
            ps.setString(14, s_specialization);
            ps.setString(15, s_qualification);
            ps.setString(16, s_category);

            boolean isExecuted = ps.execute();

            if (!isExecuted) {
                JOptionPane.showMessageDialog(null, "Staff added successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Some error occurred");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet getStaffDetails(int staff_id) {

        ResultSet rs = null;
        String sql = "select * from staff_details where staff_id='" + staff_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public static ResultSet getAvailableDoctors() {

        ResultSet rs = null;
        String sql = "select * from staff_details where s_category='doctor' AND s_status='active'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public static ResultSet getAvailableNurses() {

        ResultSet rs = null;
        String sql = "select * from staff_details where s_category='nurse' AND s_status='active'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public static void updateStaff(int staff_id, String s_fname, String s_lname, String s_gender, String s_country_code, long s_contact_number, String s_email_address, int s_house_number, String s_street_name, String s_city, int s_zip, String s_state, String s_country, String s_specialization, String s_qualification) {

        String sql = "update staff_details set s_fname='" + s_fname + "', s_lname='" + s_lname + "', s_gender='" + s_gender + "', s_country_code='" + s_country_code + "', s_contact_number='" + s_contact_number + "', s_email_address='" + s_email_address + "', s_house_number='" + s_house_number + "', s_street_name='" + s_street_name + "', s_city='" + s_city + "', s_zip='" + s_zip + "', s_state='" + s_state + "', s_country='" + s_country + "', s_specialization='" + s_specialization + "', s_qualification='" + s_qualification + "' where staff_id='" + staff_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            int isExecuted = stm.executeUpdate(sql);

            if (isExecuted == 1) {
                JOptionPane.showMessageDialog(null, "Staff data updated succesfully");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void softDeleteStaff(int staff_id) {
        String sql = "update staff_details set s_status = 'inactive' where staff_id='" + staff_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            int isExecuted = stm.executeUpdate(sql);

            if (isExecuted == 1) {
                JOptionPane.showMessageDialog(null, "Staff with staff id: " + staff_id + "has been marked as 'inactive'");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
