/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class ClientTestScreen extends javax.swing.JFrame {

    /**
     * Creates new form ClientTestScreen
     */
    Connection con;
    Statement s;
    Vector<Question> clientQuestions;               // Vector of Questions for client side
    Vector<Question> questions;                     // Vector of Questions for server side
    NavigateActionListener navigate;
    int currentQuestion;
    long totalSeconds;
    boolean finished;
    Timer timer;
    StudentTestRecord records[];
    int map[];
    int totalMarksScored;
    boolean showAnalysisFlag;
    boolean analysis;
  //  StartClientCommunication startClientCommunication;
    int hourStart;
    int minuteStart;
    int secondStart;
    JButton[] questionButtons;

    public ClientTestScreen() {
        navigate = new NavigateActionListener(this);
        setTitle("Test");
        initComponents();
        questionNavigationScrollPane.getVerticalScrollBar().setUnitIncrement(60);
        Dimension d = getToolkit().getScreenSize();                // stores the resolution of the current screen
        setSize(d.width, d.height - 30);                          // sets the screen size
        nextButton.setVisible(false);
        previousButton.setVisible(false);
        questionsSplitPane.setVisible(false);
        showAnalysisFlag = false;
        questionPanel.setLayout(new BorderLayout());
      //  startClientCommunication = new StartClientCommunication(this);
      //  makeClientQuestions(startClientCommunication.studentInformation.rollNumber);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informationPanel = new javax.swing.JPanel();
        startStopToggleButton = new javax.swing.JToggleButton();
        timeLabel = new javax.swing.JLabel();
        timeLeftLabel = new javax.swing.JLabel();
        nameTitleLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        rollNumberTitleLabel = new javax.swing.JLabel();
        rollNumberLabel = new javax.swing.JLabel();
        batchTitleLabel = new javax.swing.JLabel();
        batchLabel = new javax.swing.JLabel();
        standardTitleLabel = new javax.swing.JLabel();
        standardLabel = new javax.swing.JLabel();
        divisionTitleLabel = new javax.swing.JLabel();
        divisionLabel = new javax.swing.JLabel();
        questionsSplitPane = new javax.swing.JSplitPane();
        questionNavigationScrollPane = new javax.swing.JScrollPane();
        questionNavigationPanel = new javax.swing.JPanel();
        questionPanel = new javax.swing.JPanel();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        informationPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        startStopToggleButton.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        startStopToggleButton.setText("START");
        startStopToggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                startStopToggleButtonItemStateChanged(evt);
            }
        });
        startStopToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startStopToggleButtonActionPerformed(evt);
            }
        });

        timeLabel.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(255, 0, 51));

        timeLeftLabel.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        timeLeftLabel.setForeground(new java.awt.Color(255, 255, 0));

        nameTitleLabel.setBackground(new java.awt.Color(204, 204, 204));
        nameTitleLabel.setFont(new java.awt.Font("Cambria Math", 1, 26)); // NOI18N
        nameTitleLabel.setForeground(new java.awt.Color(0, 255, 255));
        nameTitleLabel.setText("Name :");

        nameLabel.setBackground(new java.awt.Color(204, 204, 204));
        nameLabel.setFont(new java.awt.Font("Cambria Math", 1, 26)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 255, 255));

        rollNumberTitleLabel.setBackground(new java.awt.Color(204, 204, 204));
        rollNumberTitleLabel.setFont(new java.awt.Font("Cambria Math", 1, 26)); // NOI18N
        rollNumberTitleLabel.setForeground(new java.awt.Color(0, 255, 255));
        rollNumberTitleLabel.setText("Roll Number :");

        rollNumberLabel.setBackground(new java.awt.Color(204, 204, 204));
        rollNumberLabel.setFont(new java.awt.Font("Cambria Math", 1, 26)); // NOI18N
        rollNumberLabel.setForeground(new java.awt.Color(0, 255, 255));

        batchTitleLabel.setBackground(new java.awt.Color(204, 204, 204));
        batchTitleLabel.setFont(new java.awt.Font("Cambria Math", 1, 26)); // NOI18N
        batchTitleLabel.setForeground(new java.awt.Color(0, 255, 255));
        batchTitleLabel.setText("Batch : ");

        batchLabel.setBackground(new java.awt.Color(204, 204, 204));
        batchLabel.setFont(new java.awt.Font("Cambria Math", 1, 26)); // NOI18N
        batchLabel.setForeground(new java.awt.Color(0, 255, 255));

        standardTitleLabel.setBackground(new java.awt.Color(204, 204, 204));
        standardTitleLabel.setFont(new java.awt.Font("Cambria Math", 1, 26)); // NOI18N
        standardTitleLabel.setForeground(new java.awt.Color(0, 255, 255));
        standardTitleLabel.setText("Standard :");

        standardLabel.setBackground(new java.awt.Color(204, 204, 204));
        standardLabel.setFont(new java.awt.Font("Cambria Math", 1, 26)); // NOI18N
        standardLabel.setForeground(new java.awt.Color(0, 255, 255));

        divisionTitleLabel.setBackground(new java.awt.Color(204, 204, 204));
        divisionTitleLabel.setFont(new java.awt.Font("Cambria Math", 1, 26)); // NOI18N
        divisionTitleLabel.setForeground(new java.awt.Color(0, 255, 255));
        divisionTitleLabel.setText("Division :");

        divisionLabel.setBackground(new java.awt.Color(204, 204, 204));
        divisionLabel.setFont(new java.awt.Font("Cambria Math", 1, 26)); // NOI18N
        divisionLabel.setForeground(new java.awt.Color(0, 255, 255));

        javax.swing.GroupLayout informationPanelLayout = new javax.swing.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addComponent(nameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addComponent(standardTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(standardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(divisionTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(divisionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(timeLeftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(startStopToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(rollNumberTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rollNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(batchTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(batchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(batchTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addGap(0, 24, Short.MAX_VALUE)
                        .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeLeftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(startStopToggleButton)
                                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(standardTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(standardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rollNumberTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rollNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(divisionTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(divisionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        questionsSplitPane.setDividerLocation(100);
        questionsSplitPane.setOneTouchExpandable(true);

        javax.swing.GroupLayout questionNavigationPanelLayout = new javax.swing.GroupLayout(questionNavigationPanel);
        questionNavigationPanel.setLayout(questionNavigationPanelLayout);
        questionNavigationPanelLayout.setHorizontalGroup(
            questionNavigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        questionNavigationPanelLayout.setVerticalGroup(
            questionNavigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        questionNavigationScrollPane.setViewportView(questionNavigationPanel);

        questionsSplitPane.setLeftComponent(questionNavigationScrollPane);

        questionPanel.setForeground(new java.awt.Color(103, 36, 36));

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1461, Short.MAX_VALUE)
        );
        questionPanelLayout.setVerticalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        questionsSplitPane.setRightComponent(questionPanel);

        previousButton.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        previousButton.setText("PREVIOUS");
        previousButton.setBorderPainted(false);
        previousButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        previousButton.setIconTextGap(0);
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        nextButton.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        nextButton.setText("NEXT");
        nextButton.setBorderPainted(false);
        nextButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nextButton.setIconTextGap(0);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(previousButton)
                        .addGap(61, 61, 61)
                        .addComponent(nextButton)
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(questionsSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1567, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(informationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(174, 174, 174)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(questionsSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousButton)
                    .addComponent(nextButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        displayQuestion(currentQuestion - 2);
    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        displayQuestion(currentQuestion);
    }//GEN-LAST:event_nextButtonActionPerformed

    private void startStopToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startStopToggleButtonActionPerformed
    }//GEN-LAST:event_startStopToggleButtonActionPerformed

    private void startStopToggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_startStopToggleButtonItemStateChanged
        if (!showAnalysisFlag) {
            int state = evt.getStateChange();
            if (state == ItemEvent.SELECTED) {
               // startTestOrAnalysis();
               // startStopToggleButton.setText("END");

            } else {
                //System.out.println("Deselected");
                timer.stop();
            //    totalMarksScored = calculateResult();
//                for(int i = 0; i < records.length; i++)
//                {
//                    System.out.println(records[i]);
//                }
           //     try {
           //         startClientCommunication.outObj.writeObject(records);
           //         startClientCommunication.outObj.flush();
//                    System.out.println("Records sent");
            //    } catch (IOException ex) {
            //        ex.printStackTrace();
                }
            //    removeComponents();
                showAnalysisFlag = true;
             //   showResults();
           // }
        }
    }//GEN-LAST:event_startStopToggleButtonItemStateChanged

    public void timerActionPerformed(ActionEvent e) {
        totalSeconds--;

        if (totalSeconds == 0) {
            //System.out.println("Zero Seconds Timer Stopped");
            timer.stop();
            totalMarksScored = calculateResult();
            removeComponents();
            showAnalysisFlag = true;
            showResults();
            finished = true;
        } else {
            timer.restart();
        }

        long hours = totalSeconds / 3600;
        StringBuffer time = new StringBuffer();
        if (hours < 10) {
            time.append(0);
        }
        time.append(hours);
        time.append(" : ");
        long minutes = (totalSeconds % 3600) / 60;
        if (minutes < 10) {
            time.append(0);
        }
        time.append(minutes);
        time.append(" : ");
        long seconds = totalSeconds % 60;
        if (seconds < 10) {
            time.append(0);
        }
        time.append(seconds);
        //System.out.println(time);

        String timeSet = time.toString();
        timeLabel.setText(timeSet);
    }

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
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//
//
//                }
//            }
            UIManager.setLookAndFeel("com.plaf.hifi.HiFiLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientTestScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientTestScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientTestScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientTestScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ClientTestScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel batchLabel;
    private javax.swing.JLabel batchTitleLabel;
    public javax.swing.JLabel divisionLabel;
    private javax.swing.JLabel divisionTitleLabel;
    private javax.swing.JPanel informationPanel;
    public javax.swing.JLabel nameLabel;
    public javax.swing.JLabel nameTitleLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    public javax.swing.JPanel questionNavigationPanel;
    public javax.swing.JScrollPane questionNavigationScrollPane;
    public javax.swing.JPanel questionPanel;
    public javax.swing.JSplitPane questionsSplitPane;
    public javax.swing.JLabel rollNumberLabel;
    private javax.swing.JLabel rollNumberTitleLabel;
    public javax.swing.JLabel standardLabel;
    private javax.swing.JLabel standardTitleLabel;
    private javax.swing.JToggleButton startStopToggleButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeLeftLabel;
    // End of variables declaration//GEN-END:variables

    private void makeClientQuestions(int rollNumber) {
        clientQuestions = new Vector();
        int value;
        int i = 0;
        Random random = new Random();

        // map array is used to map the client side questions with server side questions
        map = new int[questions.size()];
        records = new StudentTestRecord[questions.size()];

        for (int j = 0; j < records.length; j++) {
            records[j] = new StudentTestRecord(j + 1);
            
        }

        // generating random questions for client side
        while (clientQuestions.size() != questions.size()) {
            // value stores the size of questions - 1 in the Questions array
            value = random.nextInt(questions.size());

            // temp holds the question at value
            Question temp = questions.elementAt(value);

            // if the client question vector contains temp then temp will not be added in the clientQuestions Vector
            if (clientQuestions.contains(temp)) {
                continue;
            }

            // opt[] stores the options of question stored in temp array
            String opt[] = new String[]{temp.option1, temp.option2, temp.option3, temp.option4};

            // Vector for storing the randomised options
            Vector<Integer> position = new Vector<>();

            // stores the lenght of options
            int len = 0;

            // type 1 - MCQs
            // type 2 - True or False
            // type 3 - Blanks
            if (temp.type == 1) {
                len = 4;
            } else if (temp.type == 2) {
                len = 2;
            } else {
                len = 3;
            }

            // randomising the options
            while (position.size() != len) {

                // value stores the size of len - 1
                value = random.nextInt(len);

                // temp holds the question at value
                if (position.contains(value)) {
                    continue;
                }

                // adds the option to the position Vector
                position.add(value);
            }

            temp.option1 = opt[position.elementAt(0)];
            temp.option2 = opt[position.elementAt(1)];


            if (temp.type != 2) {
                temp.option3 = opt[position.elementAt(2)];
                if (temp.type != 3) {
                    temp.option4 = opt[position.elementAt(3)];
                }
            }

            // add question
            clientQuestions.add(temp);

            map[clientQuestions.indexOf(temp)] = questions.indexOf(temp) + 1;
            records[questions.indexOf(temp)].insert(clientQuestions.indexOf(temp) + 1, temp.correctAnswer);
        }

        //  For testing

//        System.out.println("Server side....");
//        for (i = 0; i < questions.size(); i++) {
//            System.out.println(questions.elementAt(i));
//        }
//
//        System.out.println("Client side....");
//        for (i = 0; i < clientQuestions.size(); i++) {
//            System.out.println(clientQuestions.elementAt(i));
//        }
//        
//        System.out.println("Map....");
//        for (i = 0; i < map.length; i++) {
//            System.out.println(i + "  " + map[i]);
//        }

//        System.out.println("Records....");
//        for (i = 0; i < records.length; i++) {
//            System.out.println(records[i]);
//        }
}
void displayQuestion(int i) {
        if (showAnalysisFlag == false) {
            Question q = clientQuestions.elementAt(i);
            currentQuestion = i + 1;
            check(currentQuestion);
            questionPanel.removeAll();
            if (q.type == 1) {
               // questionPanel.add(new Type1QuestionsPanel(i, this), BorderLayout.CENTER);
            } else if (q.type == 2) {
              //  questionPanel.add(new Type2QuestionsPanel(i, this), BorderLayout.CENTER);
            } else if (q.type == 3) {
              //  questionPanel.add(new Type3QuestionsPanel(i, this), BorderLayout.CENTER);
            }
            getRootPane().updateUI();
            SwingUtilities.updateComponentTreeUI(this);
        } else {
            Question q = clientQuestions.elementAt(i);
            currentQuestion = i + 1;
            check(currentQuestion);
            questionPanel.removeAll();
            if (q.type == 1) {
               // questionPanel.add(new Type1QuestionsPanelForAnalysis(i, this), BorderLayout.CENTER);
            } else if (q.type == 2) {
              //  questionPanel.add(new Type2QuestionsPanelForAnalysis(i, this), BorderLayout.CENTER);
            } else if (q.type == 3) {
               // questionPanel.add(new Type3QuestionsPanelForAnalysis(i, this), BorderLayout.CENTER);
            }
            getRootPane().updateUI();
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

    private void check(int currentQuestion) {
        if (currentQuestion == 1) {
            previousButton.setEnabled(false);
        } else {
            previousButton.setEnabled(true);
        }

        if (currentQuestion == clientQuestions.size()) {
            nextButton.setEnabled(false);
        } else {
            nextButton.setEnabled(true);
        }
    }

    private int calculateResult() {
        int totalMarksScored = 0;
        for (int i = 0; i < records.length; i++) {
            if (records[i].answerByStudent != null) {
                if (records[i].answerByStudent.equals(records[i].correctAnswer)) {
                    records[i].marksScored = 1;
                    totalMarksScored += 1;
                } else {
                    records[i].marksScored = 0;
                }
            }
        }
//        System.out.println(totalMarksScored);
        return totalMarksScored;
    }

    public void startTestOrAnalysis() {
        previousButton.setVisible(true);
        nextButton.setVisible(true);
        questionsSplitPane.setVisible(true);

        createButtonsForNavigation();

        //startStopToggleButton.setText("END");

        displayQuestion(0);

        currentQuestion = 1;

        check(currentQuestion);

        startTimer();

        getRootPane().updateUI();
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void createButtonsForNavigation() {
        questionNavigationPanel.removeAll();
        questionNavigationScrollPane.getVerticalScrollBar().setValue(0);
        questionNavigationScrollPane.setWheelScrollingEnabled(true);
        questionNavigationPanel.setLayout(new GridLayout(clientQuestions.size(), 1));
        questionButtons = new JButton[clientQuestions.size()];
        for (int i = 0; i < clientQuestions.size(); i++) {
            questionButtons[i] = new JButton("" + (i + 1));
            questionButtons[i].setFont(new Font("Century", Font.BOLD, 18));
            questionNavigationPanel.add(questionButtons[i]);
            questionButtons[i].addActionListener(navigate);
        }
        questionNavigationPanel.validate();
        questionNavigationPanel.repaint();
    }

    private void startTimer() {
        timeLeftLabel.setText("Time Left");
//        hourStart = 0;
//        minuteStart = 10;
//        secondStart = 00;

        totalSeconds = secondStart + (minuteStart * 60) + (hourStart * 60 * 60);
        finished = true;

        timer = new Timer(1000, new java.awt.event.ActionListener() {

            @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerActionPerformed(evt);

            }
        });
        timer.start();
        while (!finished);
    }

    private void removeComponents() {
        nextButton.setVisible(false);
        previousButton.setVisible(false);
        informationPanel.remove(startStopToggleButton);
        informationPanel.remove(timeLabel);
        informationPanel.remove(timeLeftLabel);
        informationPanel.invalidate();
        informationPanel.repaint();
    }

    private void showResults() {
        JLabel resultHeaderLabel = new JLabel("<html>R<br>E<br>S<br>U<br>L<br>T<br>S<br></html>");
        resultHeaderLabel.setFont(new Font("Century", Font.BOLD, 24));
        questionsSplitPane.setLeftComponent(resultHeaderLabel);
        ShowResultPanel resultPanel = new ShowResultPanel(this);
        questionsSplitPane.setRightComponent(resultPanel);
    }
}
