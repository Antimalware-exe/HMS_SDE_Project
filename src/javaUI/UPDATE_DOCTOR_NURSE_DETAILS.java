package javaUI;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import logic.ConnectionProvider;
import logic.StaffDetails;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author dwive
 */
public class UPDATE_DOCTOR_NURSE_DETAILS extends javax.swing.JFrame {

    /**
     * Creates new form UPDATE_DOCTOR_NURSE_DETAILS
     */
    public UPDATE_DOCTOR_NURSE_DETAILS() {
        initComponents();
//        jTextField2.setVisible(false);//fname
//        jTextField3.setVisible(false);//lname
//        jTextField6.setVisible(false);//email
//        jComboBox2.setVisible(false);//gender
//        jComboBox3.setVisible(false);//country code
//        jTextField6.setVisible(false);//phone
//        jTextField6.setVisible(false);//quali
//        jTextField6.setVisible(false);//special
//        jComboBox1.setVisible(false);//status
//        jTextField39.setVisible(false);//house num
//        jTextField35.setVisible(false);//street
//        jTextField40.setVisible(false);//city
//        jTextField41.setVisible(false);//zip
//        jTextField51.setVisible(false);//state
//        jTextField52.setVisible(false);//country

        jLabel14.setVisible(false);// record not found label
        jButton2.setVisible(false); // update button

        Connection conn = ConnectionProvider.getCon();
//        Statement stm = conn.createStatement();
        try {
//            Connection conn = ConnectionProvider.getCon();
            Statement stm = conn.createStatement();
            ResultSet rscc = stm.executeQuery("select country_code from country_code");
            while (rscc.next()) {
                String cc = rscc.getString("country_code");
                jComboBox3.addItem(cc);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField51 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jTextField52 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jTextField53 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jTextField54 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel62 = new javax.swing.JLabel();
        jTextField55 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Enter Doctor/Nurse ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 25));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 210, 25));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("Record Not Found!!");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("First Name*");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 200, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Last Name*");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 200, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Email ID*");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 200, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Phone Number*");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, -1));
        getContentPane().add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 210, 25));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, -1, 25));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 90, 25));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaUI/back small.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, 39));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Status");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 60, 25));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 80, 25));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("House Number");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, 20));

        jTextField39.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField39.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField39ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 200, 25));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Street Name");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, 20));

        jTextField35.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField35.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField35ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 200, 25));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("City");
        getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, 20));

        jTextField40.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField40.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField40ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 200, 25));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("Zip Code");
        getContentPane().add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, -1, 20));

        jTextField41.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField41.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField41ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField41, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 200, 25));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("State");
        getContentPane().add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, -1, 20));

        jTextField51.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField51.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField51ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField51, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 200, 25));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("Country");
        getContentPane().add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, 20));

        jTextField52.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField52.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField52ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField52, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 200, 25));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setText("Qualification");
        getContentPane().add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 20));

        jTextField53.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField53.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField53ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField53, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 200, 25));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setText("Specialization");
        getContentPane().add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, 20));

        jTextField54.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField54.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField54ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField54, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 200, 25));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "active", "inactive" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 110, 25));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Gender");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, 25));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setText("Category");
        getContentPane().add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, -1, 20));

        jTextField55.setEditable(false);
        jTextField55.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField55.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField55ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField55, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 200, 25));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //Update doctor/Nurse to hospital
        String ID = jTextField1.getText();
        String s_fname = jTextField2.getText();//fname
        String s_lname = jTextField3.getText();//lname
        String s_email_address = jTextField6.getText();//email
        String s_gender = (String) jComboBox2.getSelectedItem();//gender
        String s_country_code = (String) jComboBox3.getSelectedItem();//country code
        String contact_number = jTextField12.getText();//phone
        String s_qualification = jTextField53.getText();//quali
        String s_specialization = jTextField54.getText();//special
        String s_status = (String) jComboBox1.getSelectedItem();//status
        String house_number = jTextField39.getText();//house num
        String s_street_name = jTextField35.getText();//street
        String s_city = jTextField40.getText();//city
        String zip = jTextField41.getText();//zip
        String s_state = jTextField51.getText();//state
        String s_country = jTextField52.getText();//country

        if (ID.equals("") || s_fname.equals("") || s_lname.equals("") || s_email_address.equals("") || contact_number.equalsIgnoreCase("") || house_number.equalsIgnoreCase("") || zip.equals("") || s_street_name.equals("") || s_city.equals("") || s_state.equals("") || s_country.equals("") || s_qualification.equals("") || s_specialization.equals("")) {

            JOptionPane.showMessageDialog(null, "Please enter all mandatory details");
        } else {
            int s_zip = Integer.parseInt(zip);
            long s_contact_number = Long.parseLong(contact_number);
            int s_house_number = Integer.parseInt(house_number);
            int staff_id = Integer.parseInt(ID);

            StaffDetails.updateStaff(staff_id, s_fname, s_lname, s_gender, s_country_code, s_contact_number, s_email_address, s_house_number, s_street_name, s_city, s_zip, s_state, s_country, s_specialization, s_qualification);
            StaffDetails.updateStatus(staff_id, s_status);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //Search Doctor/Nurse
        String ID = jTextField1.getText();

        if (ID.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter ID to search");
        } else {
            ResultSet rs_staff = StaffDetails.getStaffDetails(Integer.parseInt(ID));
            try {
                if (rs_staff.next()) {
                    jTextField2.setText(rs_staff.getString("s_fname"));//fname
                    jTextField3.setText(rs_staff.getString("s_lname"));//lname
                    jTextField6.setText(rs_staff.getString("s_email_address"));//email
                    jComboBox2.setSelectedItem(rs_staff.getString("s_gender"));//gender
                    jComboBox3.setSelectedItem(rs_staff.getString("s_country_code"));//country code
                    jTextField12.setText(Long.toString(rs_staff.getLong("s_contact_number")));//phone
                    jTextField53.setText(rs_staff.getString("s_qualification"));//quali
                    jTextField54.setText(rs_staff.getString("s_specialization"));//special
                    jComboBox1.setSelectedItem(rs_staff.getString("s_status"));//status
                    jTextField39.setText(Integer.toString(rs_staff.getInt("s_house_number")));//house num
                    jTextField35.setText(rs_staff.getString("s_street_name"));//street
                    jTextField40.setText(rs_staff.getString("s_city"));//city
                    jTextField41.setText(Integer.toString(rs_staff.getInt("s_zip")));//zip
                    jTextField51.setText(rs_staff.getString("s_state"));//state
                    jTextField52.setText(rs_staff.getString("s_country"));//country
                    jTextField55.setText(rs_staff.getString("s_category"));//country
                    jLabel14.setVisible(false);//record not found label
                    jButton2.setVisible(true); //update button
                } else {
                    jLabel14.setVisible(true);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new MAINSCREEN().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField39ActionPerformed

    private void jTextField35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField35ActionPerformed

    private void jTextField40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField40ActionPerformed

    private void jTextField41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField41ActionPerformed

    private void jTextField51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField51ActionPerformed

    private void jTextField52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField52ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField52ActionPerformed

    private void jTextField53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField53ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField53ActionPerformed

    private void jTextField54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField54ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField54ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField55ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        jButton2.setVisible(false);
    }//GEN-LAST:event_jTextField1KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UPDATE_DOCTOR_NURSE_DETAILS.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UPDATE_DOCTOR_NURSE_DETAILS.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UPDATE_DOCTOR_NURSE_DETAILS.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UPDATE_DOCTOR_NURSE_DETAILS.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UPDATE_DOCTOR_NURSE_DETAILS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
