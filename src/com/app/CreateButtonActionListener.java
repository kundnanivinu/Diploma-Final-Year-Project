/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

/**
 *
 * @author abd
 */


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;


public class CreateButtonActionListener implements ActionListener {
    SelectQuestionsSchema obj;
    Admin adminFrame;
    CreateButtonActionListener(SelectQuestionsSchema obj,Admin adminFrame) {
        this.adminFrame = adminFrame;
        this.obj = obj;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:odbc:ProjectDatabase");
            Statement s = con.createStatement();
            s.execute("select MAX(templateId) from Template");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                obj.maxTempId = rs.getInt(1);
            }
          //  s.execute("insert into Template(templateId,templateName,subject,standard,hours,minutes,seconds) values(" + (obj.maxTempId + 1) + ",'" + obj.createPanel.templateName + "','" + obj.createPanel.subject + "'," + obj.createPanel.standard + "," + obj.createPanel.hours + "," + obj.createPanel.minutes + "," + obj.createPanel.seconds + ")");
            for (int i = 0; i < obj.len; i++) {
           //     String temp = obj.createPanel.topics.get(i);
                int tempTopicNo = obj.questionNumbers[i];
          //      s.execute("insert into QuestionsSchema values (" + (obj.maxTempId + 1) + " , '" + temp + "' , " + tempTopicNo + ")");
            }
            JOptionPane.showMessageDialog(adminFrame,"Template Created");
            obj.setVisible(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
