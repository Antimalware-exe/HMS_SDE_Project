/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.awt.HeadlessException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Win
 */
public class PatientDetails {

    public static boolean addPatient(String p_fname, String p_lname, LocalDate p_DOB, int p_age, String p_gender, String p_blood_group, String p_country_code, long p_contact_number, String p_email, int p_house_number, String p_street_name, String p_city, int p_zip, String p_state, String p_country, String SSN, String p_past_diseases) {

        String query1 = "insert into patient_details(p_fname, p_lname, p_DOB, p_age, p_gender, p_blood_group, p_country_code, p_contact_number, p_email, p_house_number, p_street_name, p_city, p_zip, p_state, p_country, SSN, p_past_diseases) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
//            ps.setDate(18, java.sql.Date.valueOf(p_visit_date));
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

    public static void updatePatient(int patient_id, String p_fname, String p_lname, LocalDate p_DOB, int p_age, String p_gender, String p_blood_group, String p_country_code, long p_contact_number, String p_email, int p_house_number, String p_street_name, String p_city, int p_zip, String p_state, String p_country, String SSN, String p_past_diseases) {

        String sql = "update patient_details set p_fname='" + p_fname + "', p_lname='" + p_lname + "', p_DOB='" + p_DOB + "', p_age='" + p_age + "', p_gender='" + p_gender + "', p_blood_group='" + p_blood_group + "', p_country_code='" + p_country_code + "', p_contact_number='" + p_contact_number + "', p_email='" + p_email + "', p_house_number='" + p_house_number + "', p_street_name='" + p_street_name + "', p_city='" + p_city + "', p_zip='" + p_zip + "', p_state='" + p_state + "', p_country='" + p_country + "', SSN='" + SSN + "', p_past_diseases='" + p_past_diseases + "' where patient_id = '" + patient_id + "'";

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

    public static void assignDoctorToPatient(int patient_id, int doctor_id) {

        String sql = "update patient_details set doctor_id='" + doctor_id + "' where patient_id = '" + patient_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            int isExecuted = stm.executeUpdate(sql);

            if (isExecuted == 1) {
                JOptionPane.showMessageDialog(null, "Doctor has been assigned to the patient");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void assignNurseToPatient(int patient_id, int nurse_id) {

        String sql = "update patient_details set nurse_id='" + nurse_id + "' where patient_id = '" + patient_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            int isExecuted = stm.executeUpdate(sql);

            if (isExecuted == 1) {
                JOptionPane.showMessageDialog(null, "Nurse has been assigned to the patient");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getPatientTriageID(int patient_id) {
        ResultSet rs = getPatientDetails(patient_id);
        int triage_id = 1;
        try {
            while (rs.next()) {
                triage_id = rs.getInt("triage_id");
            }
        } catch (SQLException ex) {
//            Logger.getLogger(PatientDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        return triage_id;
    }

    public static int getPatientBedID(int patient_id) throws SQLException {
        int id = 0;
        ResultSet rs = getPatientDetails(patient_id);
        while (rs.next()) {
            id = rs.getInt("bed_id");
        }
        return id;
    }

    public static void setStayDuration(int patient_id) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timeStamp = timestamp.toString().split("\\.")[0];

//        String sql = "update patient_details set start_date='" + +", 'end_date='" + timestamp.toString().split("\\.")[0] + "' where patient_id='" + patient_id + "'";
        String query = "UPDATE patient_details SET start_date = '" + timeStamp + "', end_date = '" + timeStamp + "' WHERE patient_id = '" + patient_id + "'";
        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            int isExecuted = stm.executeUpdate(query);

            if (isExecuted == 1) {
//                JOptionPane.showMessageDialog(null, "");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void setStayDuration(int patient_id, String start_date, String end_date) {
        String endQueryString = "";
        if (!end_date.equalsIgnoreCase("yyyy-mm-dd") && !end_date.isEmpty()) {
            Timestamp end_timestamp = Timestamp.valueOf(end_date);
            endQueryString = ",end_date='" + end_timestamp + "' ";
        } else {
            endQueryString = "";
        }
        String sql = "update patient_details set start_date='" + start_date + "' " + endQueryString + "where patient_id = '" + patient_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            int isExecuted = stm.executeUpdate(sql);

            if (isExecuted == 1) {
//                JOptionPane.showMessageDialog(null, "");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void delPatientProcedure(int patient_id) {
        String sql0 = "{call ADD_PATIENT_HISTORY(?)}";
        String sql1 = "DELETE FROM guardian_details WHERE patient_id = '" + patient_id + "'";
        String sql2 = "update prescriptions set patient_id=NULL";
        String sql3 = "DELETE FROM patient_details WHERE patient_id = '" + patient_id + "'";

        try {
            Connection con = ConnectionProvider.getCon();
            CallableStatement cstmt = con.prepareCall(sql0);
            cstmt.setInt(1, patient_id);
            cstmt.executeUpdate();

            Statement stm = con.createStatement();
            int is1Executed = stm.executeUpdate(sql1);
            if (is1Executed == 1) {
                int is2Executed = stm.executeUpdate(sql2);
                if (is2Executed == 1) {
                    int is3Executed = stm.executeUpdate(sql3);
                    if (is3Executed == 1) {
                        JOptionPane.showMessageDialog(null, "Patient deleted succesfully");
                    }
                }
            }

        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
