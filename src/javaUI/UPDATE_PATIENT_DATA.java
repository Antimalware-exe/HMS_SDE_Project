package javaUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.HeadlessException;
import logic.ConnectionProvider;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ComboBoxEditor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logic.BedDetails;
import logic.GuardianDetails;
import logic.PatientDetails;

/**
 *
 * @author dwive
 */
public class UPDATE_PATIENT_DATA extends javax.swing.JFrame {

    int p_id;

    /**
     * Creates new form UPDATE_PATIENT_DATA
     */
    public UPDATE_PATIENT_DATA(int patient_id) {
        p_id = patient_id;
//        System.out.println(patient_id);
        initComponents();
        //Disable field at screen initialization
//        jLabel14.setVisible(false); //error text invisible
//        jTabbedPane1.setVisible(false); //tabbed panel invisible
        jLabel36.setVisible(false);//ward type text
        jComboBox3.setVisible(false);// ward type combobox for selection
//        jLabel37.setVisible(false);//Start date text
//        jTextField31.setVisible(false);// start date input field
//        jLabel38.setVisible(false);//end date text
//        jTextField30.setVisible(false);//end date field        
//        jLabel39.setVisible(false);//total cost text
//        jTextField32.setVisible(false);//total cost input field   
        jLabel41.setVisible(false);//available bed text
        jComboBox9.setVisible(false);//input field for available beds

        Connection conn = ConnectionProvider.getCon();
//        Statement stm = conn.createStatement();
        try {
//            Connection conn = ConnectionProvider.getCon();
            Statement stm = conn.createStatement();
            ResultSet rscc = stm.executeQuery("select country_code from country_code");
            while (rscc.next()) {
                String cc = rscc.getString("country_code");
                jComboBox5.addItem(cc);
                jComboBox7.addItem(cc);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }

        //Patient Details
        ResultSet rspd = PatientDetails.getPatientDetails(p_id);
        try {
            while (rspd.next()) {
                jTextField2.setText(rspd.getString("p_fname"));
                jTextField3.setText(rspd.getString("p_lname"));
                jTextField7.setText(rspd.getString("p_DOB"));
                jTextField36.setText(rspd.getString("p_house_number"));
                jTextField34.setText(rspd.getString("p_street_name"));
                jTextField37.setText(rspd.getString("p_city"));
                jTextField38.setText(rspd.getString("p_zip"));
                jTextField49.setText(rspd.getString("p_state"));
                jTextField50.setText(rspd.getString("p_country"));
                jComboBox5.setSelectedItem(rspd.getString("p_country_code"));
                jTextField12.setText(rspd.getString("p_contact_number"));
                jTextField6.setText(rspd.getString("p_email"));
                jComboBox1.setSelectedItem(rspd.getString("p_gender"));
                jComboBox6.setSelectedItem(rspd.getString("p_blood_group"));
                jTextField10.setText(rspd.getString("p_age"));
                jTextField9.setText(rspd.getString("p_past_diseases"));
                jTextField35.setText(rspd.getString("SSN"));
            }
        } catch (HeadlessException | SQLException ex) {
        }

        //Guardian Details
        try {
//            Connection conn = ConnectionProvider.getCon();
            Statement stm = conn.createStatement();
            ResultSet rsrn = stm.executeQuery("select relationship_name from relationship_details");
            while (rsrn.next()) {
                String relationship_name = rsrn.getString("relationship_name");
                jComboBox8.addItem(relationship_name);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }

        ResultSet rsgd = GuardianDetails.getGuardian(p_id);

        try {
            while (rsgd.next()) {
                jTextField5.setText(rsgd.getString("g_fname"));
                jTextField13.setText(rsgd.getString("g_lname"));
                jComboBox2.setSelectedItem(rsgd.getString("g_gender"));
                jComboBox8.setSelectedItem(GuardianDetails.getRelationshipName(rsgd.getInt("g_relationship_id")));
                jTextField51.setText(rsgd.getString("g_house_number"));
                jTextField52.setText(rsgd.getString("g_street_name"));
                jTextField53.setText(rsgd.getString("g_city"));
                jTextField54.setText(rsgd.getString("g_zip"));
                jTextField55.setText(rsgd.getString("g_state"));
                jTextField56.setText(rsgd.getString("g_country"));
                jComboBox7.setSelectedItem(rsgd.getString("g_country_code"));
                jTextField21.setText(rsgd.getString("g_contact_number"));
            }
        } catch (HeadlessException | SQLException ex) {
        }

        //Triage, ward and bed -
        try {
//            Connection conn = ConnectionProvider.getCon();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select triage from triage");
            while (rs.next()) {
                String triage = rs.getString("triage");
                jComboBox4.addItem(triage);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            ResultSet rst = BedDetails.fetchTriageDetails(PatientDetails.getPatientTriageID(p_id));
            while (rst.next()) {
                jComboBox4.setSelectedItem(rst.getString("triage"));
                jTextField39.setText(rst.getString("patient_type"));
                if (rst.getString("patient_type").equals("in_patient")) {
                    jLabel36.setVisible(true);//ward type text
                    jComboBox3.setVisible(true);// ward type combobox for selection
                    jTextField30.setEditable(true);//end date field
                    jLabel41.setVisible(true);//available bed text
                    jComboBox9.setVisible(false);//input field for available beds
                } else {
                    jLabel36.setVisible(false);//ward type text
                    jComboBox3.setVisible(false);// ward type combobox for selection
                    jTextField30.setEditable(false);//end date field
                    jLabel41.setVisible(false);//available bed text
                    jComboBox9.setVisible(false);//input field for available beds}
                }
            }
        } catch (HeadlessException | SQLException ex) {
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTextField49 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jTextField50 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField21 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        jTextField51 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jTextField52 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jTextField53 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jTextField54 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jTextField55 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jTextField56 = new javax.swing.JTextField();
        jComboBox7 = new javax.swing.JComboBox<>();
        jComboBox8 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel31 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jTextField57 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jTextField58 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jComboBox9 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jButton15 = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTextField42 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jTextField43 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextField46 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("All fields are mandatory.");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 273, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaUI/back small.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, 39));

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255), 5));
        jPanel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("First Name*");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Last Name*");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Phone Number*");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Email ID*");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Gender");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Blood Group*");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Disease Suffered in the Past");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 210, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField2.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 210, 25));

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField3.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 210, 25));

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField6.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 270, 25));

        jTextField9.setText("NA");
        jTextField9.setActionCommand("<Not Set>");
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 270, 60));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Age*");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField10.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 110, 25));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(25, 25));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 110, 25));

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel16.setText("(200 words only)");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("DOB*");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jTextField7.setText("YYYY-MM-DD");
        jTextField7.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 110, 25));

        jTextField12.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 210, 25));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("UPDATE RECORD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, -1, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("SSN*");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jTextField35.setEditable(false);
        jTextField35.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField35.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField35ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 210, -1));

        jTextField34.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField34.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField34ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 270, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Street Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("House Number");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, 20));

        jTextField36.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField36.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField36ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField36, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 270, 25));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText("City");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, 20));

        jTextField37.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField37.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField37ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 270, 25));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText("Zip Code");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, 20));

        jTextField38.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField38.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField38ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 270, 25));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("State");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, -1, 20));

        jTextField49.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField49.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField49ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField49, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 270, 25));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setText("Country");
        jPanel1.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, -1, 20));

        jTextField50.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField50.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField50ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField50, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 270, 25));

        jPanel1.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 60, 25));

        jComboBox6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not known yet", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        jComboBox6.setVerifyInputWhenFocusTarget(false);
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 110, 25));

        jTabbedPane1.addTab("Edit Personal Details of Patient", jPanel1);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 255, 204), 5, true));
        jPanel2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Guardian First Name");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Guardian Last Name");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Phone Number");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Gender");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 200, 25));

        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 200, 25));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 80, 25));
        jPanel2.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 210, 25));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Relationship");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("UPDATE RECORD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, -1, -1));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("House Number");
        jPanel2.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, 20));

        jTextField51.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField51.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField51ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField51, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 200, 25));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setText("Street Name");
        jPanel2.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, -1, 20));

        jTextField52.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField52.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField52ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField52, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 200, 25));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setText("City");
        jPanel2.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, -1, 20));

        jTextField53.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField53.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField53ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField53, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 200, 25));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setText("Zip Code");
        jPanel2.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, -1, 20));

        jTextField54.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField54.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField54ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField54, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 200, 25));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setText("State");
        jPanel2.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, -1, 20));

        jTextField55.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField55.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField55ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField55, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 200, 25));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel64.setText("Country");
        jPanel2.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, -1, 20));

        jTextField56.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField56.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField56ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField56, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 200, 25));

        jPanel2.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 60, 25));

        jPanel2.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 200, 25));

        jTabbedPane1.addTab("Add/Edit Guardian Details", jPanel2);

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton14.setText("ADD");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, 25));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Doctor First Name");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Doctor Last Name");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Phone Number");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Email ID");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, -1));

        jTextField14.setEditable(false);
        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 250, 25));

        jTextField16.setEditable(false);
        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 250, 25));

        jTextField17.setEditable(false);
        jTextField17.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, 200, 25));

        jTextField19.setEditable(false);
        jTextField19.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 250, 25));

        jTextField23.setEditable(false);
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 50, 25));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Doctor Id", "First Name", "Last Name", "Country Code", "Contact Number", "Email ID", "Specialization", "Qualification", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(jTable3);

        jPanel7.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 580, 290));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Show All Available Doctors");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 25));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Show All Unvailable Doctors");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, 25));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Show All Doctors");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, 25));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Doctor ID");
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, -1));

        jTextField24.setEditable(false);
        jPanel7.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 250, 25));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel65.setText("Specialization");
        jPanel7.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, -1, -1));

        jTextField57.setEditable(false);
        jTextField57.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField57ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField57, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 250, 25));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel66.setText("Qualification");
        jPanel7.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, -1, -1));

        jTextField58.setEditable(false);
        jTextField58.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField58ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField58, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 250, 25));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setText("Assign to patient");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 340, -1, 25));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("Assign Doctors", jPanel3);

        jPanel5.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("UPDATE RECORD");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, -1, 25));

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 180, 25));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Ward Type");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("Start Date*");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("End Date*");
        jPanel5.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 80, -1));

        jTextField30.setEditable(false);
        jTextField30.setText("YYYY-MM-DD");
        jPanel5.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 180, 25));

        jTextField31.setEditable(false);
        jTextField31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField31ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 180, 25));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("Patient type");
        jPanel5.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 180, 25));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("Available beds");
        jPanel5.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("Triage");
        jPanel5.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTextField39.setEditable(false);
        jTextField39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField39ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 180, 25));

        jPanel5.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 180, 25));

        jTabbedPane1.addTab("Assign Ward", jPanel5);

        jPanel6.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("UPDATE RECORD");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 340, -1, -1));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nurse Id", "First Name", "Last Name", "Country Code", "Contact Number", "Email ID", "Specialization", "Qualification", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(jTable4);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 580, 290));

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Show All Nurse");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, 25));

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Show All Unvailable Nurse");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, 25));

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setSelected(true);
        jRadioButton6.setText("Show All Available Nurse");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 25));

        jButton15.setText("ADD");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, 25));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("Nurse ID");
        jPanel6.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, -1));

        jTextField41.setEditable(false);
        jPanel6.add(jTextField41, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 250, 25));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setText("Nurse First Name");
        jPanel6.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, -1));

        jTextField42.setEditable(false);
        jTextField42.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField42ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField42, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 250, 25));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setText("Nurse Last Name");
        jPanel6.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        jTextField43.setEditable(false);
        jTextField43.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField43ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField43, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 250, 25));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setText("Phone Number");
        jPanel6.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

        jTextField44.setEditable(false);
        jTextField44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField44ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField44, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 50, 25));

        jTextField45.setEditable(false);
        jTextField45.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField45ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField45, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, 200, 25));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setText("Email ID");
        jPanel6.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, -1));

        jTextField46.setEditable(false);
        jTextField46.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField46ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField46, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 250, 25));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel67.setText("Specialization");
        jPanel6.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, -1, -1));

        jTextField59.setEditable(false);
        jTextField59.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField59ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField59, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 250, 25));

        jTextField60.setEditable(false);
        jTextField60.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField60ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField60, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 250, 25));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel68.setText("Qualification");
        jPanel6.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, -1, -1));

        jTabbedPane1.addTab("Assign Nurse", jPanel6);

        jPanel4.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setText("UPDATE RECORD");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Medicine Name*");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 20));

        jTextField25.setEditable(false);
        jTextField25.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 200, 25));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("No. of Dose*");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 20));

        jTextField26.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField26.setText("0");
        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 70, 25));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("No. of Days*");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, 20));

        jTextField27.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField27.setText("0");
        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 70, 25));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Comments");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, 20));

        jLabel35.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel35.setText("(100 words only)");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, 20));

        jTextField28.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField28.setText("Diagnosis:");
        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 200, 50));

        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, 30));

        jButton12.setText("Remove");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug ID", "Drug Name", "No. Of Dose", "No. Of Days"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 570, 140));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug ID", "Drug Name", "Drug Category", "Available Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 990, 140));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("Medicine Inventory");
        jPanel4.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("Patient Medicine Inventory");
        jPanel4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setText("Medicine ID*");
        jPanel4.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 20));

        jTextField40.setEditable(false);
        jTextField40.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextField40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField40ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 70, 25));

        jTabbedPane1.addTab("Assign Medicines", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 400));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Patient Details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, 25));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        // Add/Edit personal details of patient        
        String p_firstname = jTextField2.getText();
        String p_lastname = jTextField3.getText();

        String date = jTextField7.getText();
        LocalDate p_DOB = LocalDate.parse(date);

        String h_num = jTextField36.getText();
        int p_house_number = 0;
        if (!"".equals(h_num)) {
            p_house_number = Integer.parseInt(h_num);
        }
        String p_street = jTextField34.getText();
        String p_city = jTextField37.getText();
        String zipString = jTextField38.getText();
        int p_zip = 0;
        if (!"".equals(zipString)) {
            p_zip = Integer.parseInt(zipString);
        }
        String p_state = jTextField49.getText();
        String p_country = jTextField50.getText();

        String country_code = (String) jComboBox5.getSelectedItem();

        //type conversion for contactnumber to integer
        String phone_number = jTextField12.getText();
        long contact_number = Long.parseLong(phone_number);

        String p_email = jTextField6.getText();

        String p_gender = (String) jComboBox1.getSelectedItem();

        String blood_group = (String) jComboBox6.getSelectedItem();

        //type conversion for age to integer
        String age = jTextField10.getText();
        int p_age = Integer.parseInt(age);

        String past_diseases = jTextField9.getText();
        String SSN = jTextField35.getText();

        int triage_id = 0;
        int bed_id = 0;

        if (!"".equals(p_firstname) && !"".equals(p_lastname) && !"YYYY-MM-DD".equals(date) && !"".equals(h_num) && !"".equals(p_street) && !"".equals(p_city) && !"".equals(zipString) && !"".equals(p_state) && !"".equals(p_country) && !"".equals(p_email) && !"".equals(phone_number) && !"".equals(SSN)) {

            PatientDetails.updatePatient(p_id, p_firstname, p_lastname, p_DOB, p_age, p_gender, blood_group, country_code, contact_number, p_email, p_house_number, p_street, p_city, p_zip, p_state, p_country, SSN, past_diseases);

        } else {
            JOptionPane.showMessageDialog(null, "Please enter mandatory field data!");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Patient_Data_Selection().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        // Add/Edit Guardian details of patient
        String g_fname = jTextField5.getText();
        String g_lname = jTextField13.getText();
        String g_relationship = (String) jComboBox8.getSelectedItem();
        String g_gender = (String) jComboBox2.getSelectedItem();
//        String g_address = jTextField18.getText();
        String g_country_code = (String) jComboBox7.getSelectedItem();
        //type conversion for contactnumber to integer
        String g_phone_number = jTextField21.getText();
        long g_contact_number = Long.parseLong(g_phone_number);

        String h_num = jTextField51.getText();
        int g_house_number = 0;
        if (!"".equals(h_num)) {
            g_house_number = Integer.parseInt(h_num);
        }
        String g_street = jTextField52.getText();
        String g_city = jTextField53.getText();
        String zipString = jTextField54.getText();
        int g_zip = 0;
        if (!"".equals(zipString)) {
            g_zip = Integer.parseInt(zipString);
        }
        String g_state = jTextField55.getText();
        String g_country = jTextField56.getText();

        if (g_fname.equals("") || g_lname.equals("") || g_country_code.equals("") || g_contact_number == 0 || g_house_number == 0 || g_zip == 0 || g_street.equals("") || g_city.equals("") || g_state.equals("") || g_country.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter all mandatory details");
        } else {

            int RelationshipID = GuardianDetails.getRelationshipID(g_relationship);

            boolean isUpdated = GuardianDetails.updateGuardian(g_fname, g_lname, g_gender, g_country_code, g_contact_number, g_house_number, g_street, g_city, g_zip, g_state, g_country, RelationshipID, p_id);

            if (isUpdated) {
                setVisible(false);
                new UPDATE_PATIENT_DATA(p_id).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Some error occurred");
            }

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        // Add/Update Nurse records
        String nur_id = jTextField41.getText();

        DefaultTableModel tm = (DefaultTableModel) jTable4.getModel();
        int SelectedRowIndex = jTable4.getSelectedRow();

        if (SelectedRowIndex != -1) {
            if (nur_id.equals(tm.getValueAt(SelectedRowIndex, 0).toString()) && !nur_id.equals("")) {
                if ("inactive".equals(tm.getValueAt(SelectedRowIndex, 8).toString())) {
                    JOptionPane.showMessageDialog(null, "Selected nurse is not available, please select another!");
                } else {
                    int nurse_id = Integer.parseInt(nur_id);
                    PatientDetails.assignNurseToPatient(p_id, nurse_id);
                    setVisible(false);
                    new UPDATE_PATIENT_DATA(p_id).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please add the nurse before assigning");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No nurse selected");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String SSN = "qwerty";
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        if (tm.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No data added in Patient Inventory");
        } else {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String drug_name, comments, drugid, noofdose, noofdays;
            String querry = "insert into medicines_assigned(drug_id,drug_name,no_of_dose,no_of_days,comments,SSN,timestamp) values(?,?,?,?,?,?,?)";

            try {
                //Call connection
                Connection con = ConnectionProvider.getCon();

                for (int i = 0; i < tm.getRowCount(); i++) {
                    drugid = tm.getValueAt(i, 0).toString();
                    int drug_id = Integer.parseInt(drugid);

                    drug_name = tm.getValueAt(i, 1).toString();

                    noofdose = tm.getValueAt(i, 2).toString();
                    int no_of_dose = Integer.parseInt(noofdose);

                    noofdays = tm.getValueAt(i, 3).toString();
                    int no_of_days = Integer.parseInt(noofdays);

                    comments = tm.getValueAt(i, 4).toString();

                    PreparedStatement ps = con.prepareStatement(querry);

                    ps.setInt(1, drug_id);
                    ps.setString(2, drug_name);
                    ps.setInt(3, no_of_dose);
                    ps.setInt(4, no_of_days);
                    ps.setString(5, comments);
                    ps.setString(6, SSN);
                    ps.setTimestamp(7, timestamp);
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Medicines Successfully assigned to patients");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        // Add/Update Doctor records
        //Type conversion from String to Integer
        String doc_id = jTextField24.getText();

        DefaultTableModel tm = (DefaultTableModel) jTable3.getModel();
        int SelectedRowIndex = jTable3.getSelectedRow();

        if (SelectedRowIndex != -1) {
            if (doc_id.equals(tm.getValueAt(SelectedRowIndex, 0).toString()) && !doc_id.equals("")) {
                if ("inactive".equals(tm.getValueAt(SelectedRowIndex, 8).toString())) {
                    JOptionPane.showMessageDialog(null, "Selected doctor is not available, please select another!");
                } else {
                    //Call connection
                    int doctor_id = Integer.parseInt(doc_id);
                    PatientDetails.assignDoctorToPatient(p_id, doctor_id);
                    setVisible(false);
                    new UPDATE_PATIENT_DATA(p_id).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please add the doctor before assigning");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No doctor selected");
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField31ActionPerformed

    private void jTextField35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField35ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        //Show Available Doctors only
        if (jRadioButton1.isSelected());
        {
            try {
                //Call connection
                Connection con = ConnectionProvider.getCon();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select * from staff_details where s_category ='Doctor' and s_status='active'");
                DefaultTableModel tm = (DefaultTableModel) jTable3.getModel();
                tm.setRowCount(0);
                while (rs.next()) {
                    Object obj[] = {rs.getString("staff_id"), rs.getString("s_fname"), rs.getString("s_lname"), rs.getString("s_country_code"), rs.getString("s_contact_number"), rs.getString("s_email_address"), rs.getString("s_specialization"), rs.getString("s_qualification"), rs.getString("s_status")};
                    tm.addRow(obj);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        //Show UNAvailable Doctors only
        if (jRadioButton2.isSelected());
        {
            try {
                //Call connection
                Connection con = ConnectionProvider.getCon();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select * from staff_details where s_category ='Doctor' and s_status='inactive'");
                DefaultTableModel tm = (DefaultTableModel) jTable3.getModel();
                tm.setRowCount(0);
                while (rs.next()) {
                    Object obj[] = {rs.getString("staff_id"), rs.getString("s_fname"), rs.getString("s_lname"), rs.getString("s_country_code"), rs.getString("s_contact_number"), rs.getString("s_email_address"), rs.getString("s_specialization"), rs.getString("s_qualification"), rs.getString("s_status")};
                    tm.addRow(obj);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        //Show All Doctors
        if (jRadioButton3.isSelected());
        {
            try {
                //Call connection
                Connection con = ConnectionProvider.getCon();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select * from staff_details where s_category ='Doctor'");
                DefaultTableModel tm = (DefaultTableModel) jTable3.getModel();
                tm.setRowCount(0);
                while (rs.next()) {
                    Object obj[] = {rs.getString("staff_id"), rs.getString("s_fname"), rs.getString("s_lname"), rs.getString("s_country_code"), rs.getString("s_contact_number"), rs.getString("s_email_address"), rs.getString("s_specialization"), rs.getString("s_qualification"), rs.getString("s_status")};
                    tm.addRow(obj);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        //Jtable to Jtextfield
        DefaultTableModel tm = (DefaultTableModel) jTable3.getModel();
        int SelectedRowIndex = jTable3.getSelectedRow();

        jTextField24.setText(tm.getValueAt(SelectedRowIndex, 0).toString());
        jTextField14.setText(tm.getValueAt(SelectedRowIndex, 1).toString());
        jTextField16.setText(tm.getValueAt(SelectedRowIndex, 2).toString());
        jTextField23.setText(tm.getValueAt(SelectedRowIndex, 3).toString());
        jTextField17.setText(tm.getValueAt(SelectedRowIndex, 4).toString());
        jTextField19.setText(tm.getValueAt(SelectedRowIndex, 5).toString());
        jTextField57.setText(tm.getValueAt(SelectedRowIndex, 6).toString());
        jTextField58.setText(tm.getValueAt(SelectedRowIndex, 7).toString());

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:  
        DefaultTableModel tm = (DefaultTableModel) jTable2.getModel();
        int SelectedRowIndex = jTable2.getSelectedRow();
        jTextField25.setText(tm.getValueAt(SelectedRowIndex, 1).toString());
        jTextField40.setText(tm.getValueAt(SelectedRowIndex, 0).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28ActionPerformed

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jTextField40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField40ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        String drug_name = jTextField25.getText();
        String drug_id = jTextField40.getText();
        String no_of_dose = jTextField26.getText();
        String no_of_days = jTextField27.getText();
        String Comments = jTextField28.getText();
        if (no_of_dose.equals("") || no_of_days.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter some value in mandatory fields");
        } else {
            String data[] = {drug_id, drug_name, no_of_dose, no_of_days, Comments};
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            tm.addRow(data);
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        int SelectedRowIndex = jTable1.getSelectedRow();
        tm.removeRow(SelectedRowIndex);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        //Show all nurse
        if (jRadioButton4.isSelected());
        {
            try {
                //Call connection
                Connection con = ConnectionProvider.getCon();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select * from staff_details where s_category ='Nurse'");
                DefaultTableModel tm = (DefaultTableModel) jTable4.getModel();
                tm.setRowCount(0);
                while (rs.next()) {
                    Object obj[] = {rs.getString("staff_id"), rs.getString("s_fname"), rs.getString("s_lname"), rs.getString("s_country_code"), rs.getString("s_contact_number"), rs.getString("s_email_address"), rs.getString("s_specialization"), rs.getString("s_qualification"), rs.getString("s_status")};
                    tm.addRow(obj);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
        //Show all unavailable nurse
        if (jRadioButton5.isSelected());
        {
            try {
                //Call connection
                Connection con = ConnectionProvider.getCon();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select * from staff_details where s_category ='Nurse' and s_status='inactive'");
                DefaultTableModel tm = (DefaultTableModel) jTable4.getModel();
                tm.setRowCount(0);
                while (rs.next()) {
                    Object obj[] = {rs.getString("staff_id"), rs.getString("s_fname"), rs.getString("s_lname"), rs.getString("s_country_code"), rs.getString("s_contact_number"), rs.getString("s_email_address"), rs.getString("s_specialization"), rs.getString("s_qualification"), rs.getString("s_status")};
                    tm.addRow(obj);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
        // Show all available nurse
        if (jRadioButton6.isSelected());
        {
            try {
                //Call connection
                Connection con = ConnectionProvider.getCon();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select * from staff_details where s_category ='Nurse' and s_status='active'");
                DefaultTableModel tm = (DefaultTableModel) jTable4.getModel();
                tm.setRowCount(0);
                while (rs.next()) {
                    Object obj[] = {rs.getString("staff_id"), rs.getString("s_fname"), rs.getString("s_lname"), rs.getString("s_country_code"), rs.getString("s_contact_number"), rs.getString("s_email_address"), rs.getString("s_specialization"), rs.getString("s_qualification"), rs.getString("s_status")};
                    tm.addRow(obj);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        //Jtable to Jtextfield
        DefaultTableModel tm = (DefaultTableModel) jTable4.getModel();
        int SelectedRowIndex = jTable4.getSelectedRow();

        jTextField41.setText(tm.getValueAt(SelectedRowIndex, 0).toString());
        jTextField42.setText(tm.getValueAt(SelectedRowIndex, 1).toString());
        jTextField43.setText(tm.getValueAt(SelectedRowIndex, 2).toString());
        jTextField44.setText(tm.getValueAt(SelectedRowIndex, 3).toString());
        jTextField45.setText(tm.getValueAt(SelectedRowIndex, 4).toString());
        jTextField46.setText(tm.getValueAt(SelectedRowIndex, 5).toString());
        jTextField59.setText(tm.getValueAt(SelectedRowIndex, 6).toString());
        jTextField60.setText(tm.getValueAt(SelectedRowIndex, 7).toString());
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jTextField42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField42ActionPerformed

    private void jTextField43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField43ActionPerformed

    private void jTextField44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField44ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField44ActionPerformed

    private void jTextField45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField45ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField45ActionPerformed

    private void jTextField46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField46ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
        // Validation for invisible fields
        String text = jComboBox4.getSelectedItem().toString();
        String patient_type = BedDetails.getPatientType(text);
        jTextField39.setText(patient_type.toUpperCase());

        if (patient_type.equals("in_patient")) {
            jLabel36.setVisible(true);//ward type text
            jComboBox3.setVisible(true);// ward type combobox for selection
            jTextField30.setEditable(true);//end date field
            jLabel41.setVisible(true);//available bed text
            jComboBox9.setVisible(false);//input field for available beds
        } else {
            jLabel36.setVisible(false);//ward type text
            jComboBox3.setVisible(false);// ward type combobox for selection
            jTextField30.setEditable(false);//end date field
            jLabel41.setVisible(false);//available bed text
            jComboBox9.setVisible(false);//input field for available beds}
        }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:

        String text = jComboBox3.getSelectedItem().toString();
        try {
            //Call connection
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from ward_inventory where ward_type='" + text + "'");
            while (rs.next()) {
//                jTextField33.setText(rs.getString(3));
//                    jTextField29.setText(rs.getString(4));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField34ActionPerformed

    private void jTextField36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField36ActionPerformed

    private void jTextField37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField37ActionPerformed

    private void jTextField38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField38ActionPerformed

    private void jTextField49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField49ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField49ActionPerformed

    private void jTextField50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField50ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField50ActionPerformed

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

    private void jTextField55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField55ActionPerformed

    private void jTextField56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField56ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField56ActionPerformed

    private void jTextField57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField57ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField57ActionPerformed

    private void jTextField58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField58ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField58ActionPerformed

    private void jTextField59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField59ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField59ActionPerformed

    private void jTextField60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField60ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField60ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        try {
            //Call connection
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from staff_details where s_category ='Doctor' and s_status='active'");
            DefaultTableModel tm = (DefaultTableModel) jTable3.getModel();
            tm.setRowCount(0);
            while (rs.next()) {
                Object obj[] = {rs.getString("staff_id"), rs.getString("s_fname"), rs.getString("s_lname"), rs.getString("s_country_code"), rs.getString("s_contact_number"), rs.getString("s_email_address"), rs.getString("s_specialization"), rs.getString("s_qualification"), rs.getString("s_status")};
                tm.addRow(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            //Call connection
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from staff_details where s_category ='Nurse' and s_status='active'");
            DefaultTableModel tm = (DefaultTableModel) jTable4.getModel();
            tm.setRowCount(0);
            while (rs.next()) {
                Object obj[] = {rs.getString("staff_id"), rs.getString("s_fname"), rs.getString("s_lname"), rs.getString("s_country_code"), rs.getString("s_contact_number"), rs.getString("s_email_address"), rs.getString("s_specialization"), rs.getString("s_qualification"), rs.getString("s_status")};
                tm.addRow(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTextField39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField39ActionPerformed

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
            java.util.logging.Logger.getLogger(UPDATE_PATIENT_DATA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UPDATE_PATIENT_DATA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UPDATE_PATIENT_DATA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UPDATE_PATIENT_DATA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UPDATE_PATIENT_DATA(24).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
