/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author professional
 */
public class TourFrame extends javax.swing.JFrame {

    /**
     * Creates new form TourFrame
     */
    
    public TourFrame() {
        initComponents();
        jSplitPane1.setDividerLocation(300);
        jSplitPane1.updateUI();
        setSize(1000,700);    
        setResizable(false);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)       
            {
                dispose();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        displayPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(200);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Contents");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Template Creation");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Selecting subject and topics");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Selecting total questions for topics");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Test Conduction");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Scheduling of test");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Viewing test status");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Performing Test");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Starting test");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Navigation options");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Ending test");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Viewing analysis");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(displayPanel);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        String str = jTree1.getLastSelectedPathComponent().toString();
//        System.out.println(str);
        if (str.equals("Template Creation")) {
            displayPanel = new JPanel(new BorderLayout());
            displayPanel.add(new HelpTemplateCreationPanel(), BorderLayout.CENTER);
            jSplitPane1.setBottomComponent(displayPanel);
            jSplitPane1.setDividerLocation(300);
            jScrollPane1.updateUI();
        } else if(str.equals("Selecting subject and topics")) {
            displayPanel = new JPanel(new BorderLayout());
            displayPanel.add(new HelpSelectingSubjectsAndTopicsPanel(), BorderLayout.CENTER);
            jSplitPane1.setBottomComponent(displayPanel);
            jSplitPane1.setDividerLocation(300);
            jScrollPane1.updateUI();
        } else if(str.equals("Selecting total questions for topics")) {
            displayPanel = new JPanel(new BorderLayout());
            displayPanel.add(new HelpSelectingQuestionsForTopicPanel(), BorderLayout.CENTER);
            jSplitPane1.setBottomComponent(displayPanel);
            jSplitPane1.setDividerLocation(300);
            jScrollPane1.updateUI();
        } else if(str.equals("Test Conduction")) {
            displayPanel = new JPanel(new BorderLayout());
            displayPanel.add(new HelpTestConductionPanel(), BorderLayout.CENTER);
            jSplitPane1.setBottomComponent(displayPanel);
            jSplitPane1.setDividerLocation(300);
            jScrollPane1.updateUI();
        } else if(str.equals("Scheduling of test")) {
            displayPanel = new JPanel(new BorderLayout());
            displayPanel.add(new HelpSchedulingTestPanel(), BorderLayout.CENTER);
            jSplitPane1.setBottomComponent(displayPanel);
            jSplitPane1.setDividerLocation(300);
            jScrollPane1.updateUI();
        } else if(str.equals("Viewing test status")) {
            displayPanel = new JPanel(new BorderLayout());
            displayPanel.add(new HelpViewingTestStatusPanel(), BorderLayout.CENTER);
            jSplitPane1.setBottomComponent(displayPanel);
            jSplitPane1.setDividerLocation(300);
            jScrollPane1.updateUI();
        } else if(str.equals("Performing Test")) {
            displayPanel = new JPanel(new BorderLayout());
            displayPanel.add(new HelpPerformingTestPanel(), BorderLayout.CENTER);
            jSplitPane1.setBottomComponent(displayPanel);
            jSplitPane1.setDividerLocation(300);
            jScrollPane1.updateUI();
        } else if(str.equals("Starting test")) {
            displayPanel = new JPanel(new BorderLayout());
            displayPanel.add(new HelpStartingTestPanel(), BorderLayout.CENTER);
            jSplitPane1.setBottomComponent(displayPanel);
            jSplitPane1.setDividerLocation(300);
            jScrollPane1.updateUI();
        } else if(str.equals("Navigation options")) {
            displayPanel = new JPanel(new BorderLayout());
            displayPanel.add(new HelpNavigationOptionsPanel(), BorderLayout.CENTER);
            jSplitPane1.setBottomComponent(displayPanel);
            jSplitPane1.setDividerLocation(300);
            jScrollPane1.updateUI();
        } else if(str.equals("Ending test")) {
            displayPanel = new JPanel(new BorderLayout());
            displayPanel.add(new HelpEndingTestPanel(), BorderLayout.CENTER);
            jSplitPane1.setBottomComponent(displayPanel);
            jSplitPane1.setDividerLocation(300);
            jScrollPane1.updateUI();
        } else if(str.equals("Viewing analysis")) {
            displayPanel = new JPanel(new BorderLayout());
            displayPanel.add(new HelpViewingAnalysisPanel(), BorderLayout.CENTER);
            jSplitPane1.setBottomComponent(displayPanel);
            jSplitPane1.setDividerLocation(300);
            jScrollPane1.updateUI();
        } 
    }//GEN-LAST:event_jTree1ValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TourFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TourFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TourFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TourFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TourFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel displayPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
