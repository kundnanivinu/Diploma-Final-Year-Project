/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

/**
 *
 * @author professional
 */
public class HelpTestConductionPanel extends javax.swing.JPanel {

    /**
     * Creates new form HelpTemplateCreationPanel
     */
    public HelpTestConductionPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();

        titleLabel.setFont(new java.awt.Font("Walt Disney Script v4.1", 3, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(153, 0, 255));
        titleLabel.setText("Test Conduction");

        infoLabel.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(204, 153, 255));
        infoLabel.setText("<html><body>There are two steps : <br> - Scheduling of Test <br> - Viewing Test Status</body></html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 47, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(infoLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(106, 106, 106)
                .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
