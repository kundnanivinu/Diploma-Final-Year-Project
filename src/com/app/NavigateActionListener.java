/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author professional
 */
class NavigateActionListener implements ActionListener{

    ClientTestScreen client;
    public NavigateActionListener(ClientTestScreen client) {
        this.client = client;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(e.getActionCommand());
        client.displayQuestion(Integer.parseInt(e.getActionCommand()) - 1);
    }
}
