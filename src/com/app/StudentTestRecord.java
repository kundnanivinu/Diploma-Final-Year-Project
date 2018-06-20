/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class StudentTestRecord implements Serializable{
    
    int questionNumber;
    int clientSideQuestionNumber;
    String answerByStudent;
    String correctAnswer;
    int marksScored;

    public StudentTestRecord(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    @Override
    public String toString() {
        return "StudentTestRecord{" + "questionNumber=" + questionNumber + ", clientSideQuestionNumber=" + clientSideQuestionNumber + ", answerByStudent=" + answerByStudent + ", correctAnswer=" + correctAnswer + ", marksScored=" + marksScored + '}';
    }
   
    public void insert(int clientSideQuestionNumber, String correctAnswer)
    {
        this.clientSideQuestionNumber = clientSideQuestionNumber;
        this.correctAnswer = correctAnswer;
    }
}
