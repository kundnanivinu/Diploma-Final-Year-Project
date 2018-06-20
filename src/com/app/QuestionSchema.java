/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

/**
 *
 * @author edit
 */
public class QuestionSchema {
    String getTopic;
    int getNumberOfQuestionsOfTopic;
    public QuestionSchema(String tempTopic,int tempNumberOfQuestionsOfTopic)
    {
         getTopic = tempTopic;
         getNumberOfQuestionsOfTopic = tempNumberOfQuestionsOfTopic;
    }

    @Override
    public String toString() {
        return "QuestionSchema{" + "getTopic=" + getTopic + ", getNumberOfQuestionsOfTopic=" + getNumberOfQuestionsOfTopic + '}';
    }
}