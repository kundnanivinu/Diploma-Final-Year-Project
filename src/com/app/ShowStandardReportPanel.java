/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.sql.*;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abd
 */
public class ShowStandardReportPanel extends javax.swing.JPanel {

    /**
     * Creates new form ShowStandardReportPanel
     */
    Connection con;
    Statement s;
    Statement stmt;
    Statement stmt1;
    ResultSet rs;
    ResultSet rset;
    ResultSet rset1;
    Admin adminFrame;
    private JPanel contentPanel;
    DefaultTableModel stdReportModel;
    StandardWiseReportPanel reportPanel;
    Object data[] = new Object[7];
    int bat;
    int testId;
    int marks;
    int tempId;
    String tempName;
    int roll;
    String sName;
    String div;
    String date;
    String sub;
    int marksScored;
    int maxMarks;
    int studId;
    String firstName;
    String lastName;

    public ShowStandardReportPanel(Admin adminFrame, StandardWiseReportPanel reportPanel) {
        this.adminFrame = adminFrame;
        this.reportPanel = reportPanel;
        int j = 0;
        initComponents();
        standardTextField.setText(Integer.toString(reportPanel.num));
        int bat = reportPanel.batch;
        batchTextField.setText(Integer.toString(reportPanel.batch));

        stdReportModel = (DefaultTableModel) showStdReportTable.getModel();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection("jdbc:odbc:ProjectDatabase");
            s = con.createStatement();
            stmt = con.createStatement();
            stmt1 = con.createStatement();
            s.execute("select * from Test where Batch = " + reportPanel.batch + " and Standard = " + reportPanel.num);
            rs = s.getResultSet();
            Vector<StandardWiseReportTableFields> fields = new Vector<>();
            if (rs != null) {
                while (rs.next()) {
                    testId = rs.getInt("TestId");
                    date = rs.getString("Date");
                    sub = rs.getString("Subject");
                    maxMarks = rs.getInt("Marks");
                    div = rs.getString("Division");
                    tempId = rs.getInt("templateId");

                    stmt.execute("select distinct StudentId from StudentTestRecord where TestId = " + testId);
                    rset = stmt.getResultSet();
                    if (rset != null) {
                        while (rset.next()) {
                            studId = rset.getInt("StudentId");
                            
                            StandardWiseReportTableFields temp = new StandardWiseReportTableFields(testId, date, sub, div, maxMarks, tempId, studId);
                            fields.add(temp);
//                            System.out.println(temp);
                            stmt1.execute("select sum(MarksScored) from StudentTestRecord where StudentId = " + studId + "and TestId = " + testId);
                            rset1 = stmt1.getResultSet();
                            if (rset1 != null) {
                                while (rset1.next()) {
                                    marksScored = rset1.getInt(1);
                                    fields.elementAt(j).marksScored = marksScored;
                                }
                            }

                            stmt1.execute("select firstName,lastName from Student where rollNumber =  " + studId + "and standard = " + reportPanel.num + "and division='" + fields.elementAt(j).div + "' and batch = " + reportPanel.batch);

                            rset1 = stmt1.getResultSet();
                            if (rset1 != null) {
                                while (rset1.next()) {
                                    firstName = rset1.getString("firstName");
                                    lastName = rset1.getString("lastName");
                                    tempName = firstName + " " + lastName;
                                    fields.elementAt(j).studName = tempName;
                                }
                            }
                            j++;
                        }
                    }
                }
            }

            for (int k = 0; k < fields.size(); k++) {
                data[0] = fields.elementAt(k).rollNumber;
                data[1] = fields.elementAt(k).studName;
                data[2] = fields.elementAt(k).div;
                data[3] = fields.elementAt(k).date;
                data[4] = fields.elementAt(k).sub;
                data[5] = fields.elementAt(k).marksScored;
                data[6] = fields.elementAt(k).maxMarks;
                stdReportModel.insertRow(k, data);
                showStdReportTable.validate();
                showStdReportTable.repaint();
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

        studentInfoPanel = new javax.swing.JPanel();
        standardLabel = new javax.swing.JLabel();
        divisionLabel = new javax.swing.JLabel();
        batchTextField = new javax.swing.JTextField();
        standardTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        showStdReportTable = new javax.swing.JTable();
        OKButton = new javax.swing.JButton();

        standardLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        standardLabel.setText("Standard");

        divisionLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        divisionLabel.setText("Batch");

        batchTextField.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        batchTextField.setEnabled(false);

        standardTextField.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        standardTextField.setEnabled(false);
        standardTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standardTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentInfoPanelLayout = new javax.swing.GroupLayout(studentInfoPanel);
        studentInfoPanel.setLayout(studentInfoPanelLayout);
        studentInfoPanelLayout.setHorizontalGroup(
            studentInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentInfoPanelLayout.createSequentialGroup()
                .addGroup(studentInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(studentInfoPanelLayout.createSequentialGroup()
                        .addComponent(standardLabel)
                        .addGap(28, 28, 28)
                        .addComponent(standardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(studentInfoPanelLayout.createSequentialGroup()
                        .addComponent(divisionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(batchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        studentInfoPanelLayout.setVerticalGroup(
            studentInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentInfoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(studentInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(standardLabel)
                    .addComponent(standardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(studentInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(divisionLabel)
                    .addComponent(batchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        showStdReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Roll Number", "Student Name", "Division", "Date", "Subject", "Marks Scored", "Maximum Marks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        showStdReportTable.setName("");
        jScrollPane1.setViewportView(showStdReportTable);
        showStdReportTable.getColumnModel().getColumn(0).setResizable(false);
        showStdReportTable.getColumnModel().getColumn(1).setResizable(false);
        showStdReportTable.getColumnModel().getColumn(2).setResizable(false);
        showStdReportTable.getColumnModel().getColumn(3).setResizable(false);
        showStdReportTable.getColumnModel().getColumn(4).setResizable(false);
        showStdReportTable.getColumnModel().getColumn(5).setResizable(false);

        OKButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(422, 422, 422)
                        .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(377, 461, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(studentInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void standardTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standardTextFieldActionPerformed
    }//GEN-LAST:event_standardTextFieldActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OKButton;
    private javax.swing.JTextField batchTextField;
    private javax.swing.JLabel divisionLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable showStdReportTable;
    private javax.swing.JLabel standardLabel;
    private javax.swing.JTextField standardTextField;
    private javax.swing.JPanel studentInfoPanel;
    // End of variables declaration//GEN-END:variables
}
