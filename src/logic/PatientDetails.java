/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.awt.HeadlessException;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Win
 */
public class PatientDetails {

    public static boolean addPatient(String p_fname, String p_lname, LocalDate p_DOB, int p_age, String p_gender, String p_blood_group, String p_country_code, long p_contact_number, String p_email, int p_house_number, String p_street_name, String p_city, int p_zip, String p_state, String p_country, String SSN, String p_past_diseases, LocalDate p_visit_date, int triage_id, int doctor_id, int nurse_id, int bed_id, Timestamp start_date, Timestamp end_date) {

        String query1 = "insert into patient_details(p_fname, p_lname, p_DOB, p_age, p_gender, p_blood_group, p_country_code, p_contact_number, p_email, p_house_number, p_street_name, p_city, p_zip, p_state, p_country, SSN, p_past_diseases, p_visit_date) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        boolean isNotExecuted = false;
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement(query1);

            ps.setString(1, p_fname);
            ps.setString(2, p_lname);
            ps.setDate(3, java.sql.Date.valueOf(p_DOB));
            ps.setInt(4, p_age);
            ps.setString(5, p_gender);
            ps.setString(6, p_blood_group);
            ps.setString(7, p_country_code);
            ps.setLong(8, p_contact_number);
            ps.setString(9, p_email);
            ps.setInt(10, p_house_number);
            ps.setString(11, p_street_name);
            ps.setString(12, p_city);
            ps.setInt(13, p_zip);
            ps.setString(14, p_state);
            ps.setString(15, p_country);
            ps.setString(16, SSN);
            ps.setString(17, p_past_diseases);
            ps.setDate(18, java.sql.Date.valueOf(p_visit_date));
//            ps.setInt(19, triage_id);
//            ps.setInt(20, doctor_id);
//            ps.setInt(21, nurse_id);
//            ps.setInt(22, bed_id);
//            ps.setTimestamp(23, start_date);
//            ps.setTimestamp(24, end_date);

            isNotExecuted = ps.execute();

        } catch (HeadlessException | SQLException e) {
            System.out.println("for SQL");
            System.out.println(e.getMessage());
        }
        return isNotExecuted;
    }

    public static ResultSet getPatientDetails(int patient_id) {
        ResultSet rs = null;
        String sql = "SELECT * FROM patient_details where patient_id = " + patient_id;
        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public static ResultSet getPatients(String SSN) {
        ResultSet rs = null;
        String sql = "SELECT * FROM patient_details where SSN = '" + SSN + "'";
        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public static void updatePatient(int patient_id, String p_fname, String p_lname, LocalDate p_DOB, int p_age, String p_gender, String p_blood_group, String p_country_code, long p_contact_number, String p_email, int p_house_number, String p_street_name, String p_city, int p_zip, String p_state, String p_country, String SSN, String p_past_diseases, LocalDate p_visit_date, int triage_id, int doctor_id, int nurse_id, int bed_id, Timestamp start_date, Timestamp end_date) {

        String triageString = triage_id == 0 ? null : Integer.toString(triage_id);
        String doctorString = triage_id == 0 ? null : Integer.toString(doctor_id);
        String nurseString = triage_id == 0 ? null : Integer.toString(nurse_id);
        String bedString = triage_id == 0 ? null : Integer.toString(bed_id);

        String IDstring = "triage_id=" + triageString + ", doctor_id=" + doctorString + ", nurse_id=" + nurseString + ", bed_id=" + bedString + "";

        String sql = "update patient_details set p_fname='" + p_fname + "', p_lname='" + p_lname + "', p_DOB='" + p_DOB + "', p_age='" + p_age + "', p_gender='" + p_gender + "', p_blood_group='" + p_blood_group + "', p_country_code='" + p_country_code + "', p_contact_number='" + p_contact_number + "', p_email='" + p_email + "', p_house_number='" + p_house_number + "', p_street_name='" + p_street_name + "', p_city='" + p_city + "', p_zip='" + p_zip + "', p_state='" + p_state + "', p_country='" + p_country + "', SSN='" + SSN + "', p_past_diseases='" + p_past_diseases + "', p_visit_date='" + p_visit_date + "', " + IDstring + ", start_date=" + start_date + ", end_date=" + end_date + " where patient_id='" + patient_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            int isExecuted = stm.executeUpdate(sql);

            if (isExecuted == 1) {
                JOptionPane.showMessageDialog(null, "Patient data updated succesfully");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delPatient(int patient_id) {

        String sql = "DELETE FROM patient_details WHERE patient_id = '" + patient_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            int isExecuted = stm.executeUpdate(sql);

            if (isExecuted == 1) {
                JOptionPane.showMessageDialog(null, "Patient deleted succesfully");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
