/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

/**
 *
 * @author Administrator
 */
public class ShowAnalysisThread extends Thread {

    ClientTestScreen clientTestScreen;

    public ShowAnalysisThread(ClientTestScreen clientTestScreen) {
        this.clientTestScreen = clientTestScreen;
        start();
    }

    public void run() {
        clientTestScreen.questionsSplitPane.setLeftComponent(clientTestScreen.questionNavigationScrollPane);

        clientTestScreen.questionsSplitPane.setRightComponent(clientTestScreen.questionPanel);

        clientTestScreen.questionsSplitPane.setDividerLocation(100);
        clientTestScreen.startTestOrAnalysis();
    }
}
