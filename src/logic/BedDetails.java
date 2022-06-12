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
public class BedDetails extends WardDetails {

    static Connection con = ConnectionProvider.getCon();

    public static ResultSet fetchBedDetails() {
        ResultSet rs = null;
        String sql = "select * from bed_details";
        try {
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public static ResultSet fetchBedDetails(String bed_number) {
        ResultSet rs = null;
        String sql = "select * from bed_details where bed_number='" + bed_number + "'";
        try {
//            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public static ResultSet fetchBedDetails(int bed_id) {
        ResultSet rs = null;
        String sql = "select * from bed_details where bed_id='" + bed_id + "'";
        try {
//            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public static void updateBedStatus(int bed_id, String bed_status) {
        String sql = "update bed_details set bed_status='" + bed_status + "' where bed_id='" + bed_id + "'";

        try {
//            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            int isExecuted = stm.executeUpdate(sql);

            if (isExecuted == 1) {
                System.out.println("Bed status updated");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet fetchTriageDetails() {
        TriageDetails triage_Obj = new TriageDetails();
        return triage_Obj.getTriageDetails();
    }

    public static ResultSet fetchTriageDetails(int triage_id) {
        ResultSet rs = null;
        String sql = "select * from triage where triage_id='" + triage_id + "'";
        try {
//            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public static int getTriageId(String triage) {
        int triage_id = 1;
        ResultSet rs = fetchTriageDetails();

        try {
            while (rs.next()) {
                if (rs.getString("triage").equals(triage)) {
                    triage_id = rs.getInt("triage_id");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return triage_id;
    }

    public static String getTriageName(int triage_id) {
        String triage = null;
        ResultSet rs = fetchTriageDetails();

        try {
            while (rs.next()) {
                if (rs.getInt("triage_id") == triage_id) {
                    triage = rs.getString("triage");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return triage;
    }

    public static String getPatientType(String triage) {
        String patient_type = null;
        ResultSet rs = fetchTriageDetails();

        try {
            while (rs.next()) {
                if (rs.getString("triage").equals(triage)) {
                    patient_type = rs.getString("patient_type");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return patient_type;
    }

    public static String getWardType(int ward_id) {
        String ward_type = null;
        WardDetails ward_Obj = new WardDetails();
        ResultSet rs = ward_Obj.getWardDetails();

        try {
            while (rs.next()) {
                if (rs.getInt("ward_id") == ward_id) {
                    ward_type = rs.getString("ward_type");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ward_type;
    }

    public static void allocateBedTo(int patient_id, String bed_number) {
        {
            try {
                ResultSet BD = fetchBedDetails(bed_number);
                int bed_id = BD.getInt("bed_id");
                String sql = "update patient_details set bed_id='" + bed_id + "' where patient_id='" + patient_id + "'";

                Connection con = ConnectionProvider.getCon();
                Statement stm = con.createStatement();
                int isExecuted = stm.executeUpdate(sql);

                if (isExecuted == 1) {
                    updateBedStatus(bed_id, "occupied");
                    JOptionPane.showMessageDialog(null, "Bed allocated to the patient");
                }
            } catch (HeadlessException | SQLException ex) {
//                Logger.getLogger(BedDetails.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }

        }
    }
}
