/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author professional
 */
public class EditTemplateNamePanel extends javax.swing.JPanel {
    boolean flag;
    Connection con;
    Statement s;
    Admin adminFrame;

    /**
     * Creates new form EditTemplatePanel1
     */
    public EditTemplateNamePanel() {
        initComponents();
    }

    EditTemplateNamePanel(Admin adminFrame) {
        this.adminFrame = adminFrame;
        initComponents();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            con = DriverManager.getConnection("jdbc:odbc:ProjectDatabase", "", "");
            s = con.createStatement();
            s.execute("select templateName from Template"); // insert some data into the table  
            ResultSet rs = s.getResultSet();
            while(rs.next())
            {
                templateNameComboBox.addItem(rs.getString("templateName"));
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

        templateNameLabel = new javax.swing.JLabel();
        templateNameComboBox = new javax.swing.JComboBox();
        newTemplateNameLabel = new javax.swing.JLabel();
        newTemplateNameTextField = new javax.swing.JTextField();
        changeTemplateNameButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        templateNameLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        templateNameLabel.setText("Template Name");

        templateNameComboBox.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N

        newTemplateNameLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        newTemplateNameLabel.setText("New Template Name");

        newTemplateNameTextField.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N

        changeTemplateNameButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        changeTemplateNameButton.setText("Change");
        changeTemplateNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeTemplateNameButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
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
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(templateNameLabel)
                    .addComponent(newTemplateNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newTemplateNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(templateNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(changeTemplateNameButton)
                .addGap(54, 54, 54)
                .addComponent(cancelButton)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(templateNameLabel)
                    .addComponent(templateNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newTemplateNameLabel)
                    .addComponent(newTemplateNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeTemplateNameButton)
                    .addComponent(cancelButton))
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void changeTemplateNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeTemplateNameButtonActionPerformed
        flag = true;
        String temp = new String( newTemplateNameTextField.getText());
        if (temp.equals(""))
        {
            JOptionPane.showMessageDialog(adminFrame,"Enter Template Name");
            flag = false;
        }
        try {
            String templateName = (String) templateNameComboBox.getSelectedItem();
            String changeTemplateName = new String(newTemplateNameTextField.getText());
            if(flag)
            {
                s.execute("update Template set templateName ='" + changeTemplateName + "'where templateName ='" + templateName + "'"); // insert some data into the table
                JOptionPane.showMessageDialog(adminFrame,"Template Name changed");
                this.setVisible(false);
            }
            s.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_changeTemplateNameButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton changeTemplateNameButton;
    private javax.swing.JLabel newTemplateNameLabel;
    private javax.swing.JTextField newTemplateNameTextField;
    private javax.swing.JComboBox templateNameComboBox;
    private javax.swing.JLabel templateNameLabel;
    // End of variables declaration//GEN-END:variables
}
