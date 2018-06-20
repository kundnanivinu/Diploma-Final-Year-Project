/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.io.Serializable;

/**
 *
 * @author professional
 */
class Question implements Serializable{
    int questionId;
    String subject;
    String topic;
    int standard;
    int type;
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    String correctAnswer;

    public Question (int questionId, String subject, String topic, int standard, int type, String question, String option1, String option2, String option3, String option4, String correctAnswer) {
        this.questionId = questionId;
        this.subject = subject;
        this.topic = topic;
        this.standard = standard;
        this.type = type;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" + "questionId=" + questionId + ", subject=" + subject + ", topic=" + topic + ", standard=" + standard + ", type=" + type + ", question=" + question + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", correctAnswer=" + correctAnswer + '}';
    }
    
    
}
