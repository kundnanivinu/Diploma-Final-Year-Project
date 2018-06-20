/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

/**
 *
 * @author abd
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelButtonActionListener implements ActionListener {
    
    SelectQuestionsSchema obj;
    CancelButtonActionListener(SelectQuestionsSchema obj) {
        this.obj = obj;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        obj.setVisible(false);
    } 
}
