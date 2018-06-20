/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.awt.BorderLayout;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;

/**
 *
 * @author Jacky
 */
public class AddQuestionsToExistingSubjectPanel extends javax.swing.JPanel {

    Connection con;
    Statement s;
    ResultSet rs;
    Admin adminFrame;
    private JPanel contentPanel;
    String subject;
    String standard;

    /**
     * Creates new form AddQuestionsToExistingSubjectPanel
     */
    AddQuestionsToExistingSubjectPanel(AddQuestionToDatabase aThis, Admin adminFrame) {
        initComponents();
        this.adminFrame = adminFrame;
        standardComboBox.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        standardLabel = new javax.swing.JLabel();
        standardComboBox = new javax.swing.JComboBox();
        subjectLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectList = new javax.swing.JList();
        nextButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        standardLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        standardLabel.setText("Standard");

        standardComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IX", "X" }));
        standardComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standardComboBoxActionPerformed(evt);
            }
        });

        subjectLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        subjectLabel.setText("Subject");

        subjectList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                subjectListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(subjectList);

        nextButton.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        nextButton.setText("NEXT");
        nextButton.setBorderPainted(false);
        nextButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nextButton.setIconTextGap(0);
        nextButton.setOpaque(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        cancelButton.setText("CANCEL");
        cancelButton.setBorderPainted(false);
        cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cancelButton.setIconTextGap(0);
        cancelButton.setOpaque(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(standardLabel)
                            .addComponent(subjectLabel))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(standardComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 54, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextButton)
                        .addGap(28, 28, 28)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(standardLabel)
                    .addComponent(standardComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(cancelButton))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void standardComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standardComboBoxActionPerformed
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:odbc:ProjectDatabase");
            s = con.createStatement();
            standard = standardComboBox.getSelectedItem().toString();
            int num = standard.equals("IX") ? 9 : 10;
            s.execute("select distinct Subject from Questions where Standard=" + num);
            rs = s.getResultSet();
            if (rs != null) {
                Vector<String> sub = new Vector<>();
                while (rs.next()) {
                    String st = rs.getString("Subject");
                    sub.add(st);
                }
                subjectList.setListData(sub);
                subjectList.clearSelection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_standardComboBoxActionPerformed

    private void subjectListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_subjectListValueChanged
        subject = subjectList.getSelectedValue().toString();
    }//GEN-LAST:event_subjectListValueChanged

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed

        if (subjectList.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(adminFrame, "Select a subject!!");
        } else {
            contentPanel = new JPanel(new BorderLayout());
            adminFrame.rightPanel = new AddNewQuestionsPanel(adminFrame, subject, standard);

            adminFrame.jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, adminFrame.leftPanel, adminFrame.rightPanel);
            adminFrame.jSplitPane1.setDividerLocation(120);

            contentPanel.add(adminFrame.jSplitPane1, BorderLayout.CENTER);
            adminFrame.setContentPane(contentPanel);
            adminFrame.getRootPane().updateUI();
            SwingUtilities.updateComponentTreeUI(this);
        }
        }//GEN-LAST:event_nextButtonActionPerformed

        private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
            this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JComboBox standardComboBox;
    private javax.swing.JLabel standardLabel;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JList subjectList;
    // End of variables declaration//GEN-END:variables
}
