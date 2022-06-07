/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Win
 */
public class PatientDetails {

    public static String addPatient(String p_firstname, String p_lastname, LocalDate p_DOB, String p_address, String p_ccode, int p_cnum, String p_email, String p_gender, String p_bGroup, int p_age, String p_pdisease, String SSN, int triage_id, int doctor_id, int nurse_id, int ward_id, int guardian_id) {
        String query = "insert into patient_details(p_firstname, p_lastname, p_DOB, address, country_code, contact_number, p_email, p_gender, blood_group, p_age, past_diseases, SSN, "
                + "triage_id, doctor_id, nurse_id, ward_id, guardian_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {//Call connection
            Connection con = ConnectionProvider.getCon();
//                Statement stm = con.createStatement();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, p_firstname);
            ps.setString(2, p_lastname);
            ps.setDate(3, java.sql.Date.valueOf(p_DOB));
            ps.setString(4, p_address);
            ps.setString(5, p_ccode);
            ps.setInt(6, p_cnum);
            ps.setString(7, p_email);
            ps.setString(8, p_gender);
            ps.setString(9, p_bGroup);
            ps.setInt(10, p_age);
            ps.setString(11, p_pdisease);
            ps.setString(12, SSN);
            ps.setInt(13, triage_id);
            ps.setInt(14, doctor_id);
            ps.setInt(15, nurse_id);
            ps.setInt(16, ward_id);
            ps.setInt(17, guardian_id);
//                ps.setString(17, SSN);
            ps.execute();
//            System.out.println(ps.execute());
            return "SUCCESS";
        } catch (SQLException e) {
            System.out.println(e);
            return e.getMessage();
        }
    }

    public void getPatient(int id) {

    }

    public void deletePatient(int id) {

    }

    public void updatePatient(int id) {

    }
}
