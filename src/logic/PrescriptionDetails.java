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
public class PrescriptionDetails {

    static Connection con = ConnectionProvider.getCon();

    public static int generatePrescription(String comments, int patient_id, int doctor_id) {
        Timestamp currStmp = Timestamp.from(Instant.now());
        int prescription_id = 0;
        String sql = "insert into prescriptions(prescription_created_date,comments,patient_id,doctor_id) values(?,?,?,?)";

        try {
//            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, currStmp.toString().split("\\.")[0]);
            ps.setString(2, comments);
            ps.setInt(3, patient_id);
            ps.setInt(4, doctor_id);

            boolean isNotExecuted = ps.execute();

            if (!isNotExecuted) {
                System.out.println(currStmp.toString().split("\\.")[0]);
                String query = "select prescription_id from prescriptions where prescription_created_date = '" + currStmp.toString().split("\\.")[0] + "'";
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while (rs.next()) {
                    prescription_id = rs.getInt("prescription_id");
                    System.out.println("in while: " + prescription_id);
                }
                JOptionPane.showMessageDialog(null, "Prescription with id: " + prescription_id + " generated successfully");
            }

        } catch (HeadlessException | SQLException e) {
            System.out.println("for SQL");
            System.out.println(e.getMessage());
        }
        return prescription_id;
    }

    public static void addMedicinesToPrescription(int prescription_id, int drug_id, int no_of_dose, int no_of_days) {
        String sql = "insert into medicines_assigned(prescription_id,drug_id,no_of_dose,no_of_days) values(?,?,?,?)";

        try {
//            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, prescription_id);
            ps.setInt(2, drug_id);
            ps.setInt(3, no_of_dose);
            ps.setInt(4, no_of_days);

            boolean isNotExecuted = ps.execute();
            if (!isNotExecuted) {
                System.out.println("medicine added to prescription");
            } else {
                System.out.println("medicine not added to prescription");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("in addMedicinesToPrescription");
            System.out.println(e.getMessage());
        }
    }
}
