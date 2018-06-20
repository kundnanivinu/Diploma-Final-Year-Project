/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author abd
 */
public class JSpinnerChangeValueListener implements ChangeListener{
   
    
    SelectQuestionsSchema obj;
    JSpinnerChangeValueListener(SelectQuestionsSchema obj) {
        this.obj = obj;
    }
    @Override
    public void stateChanged(ChangeEvent ce)
    {
    
        int sum = 0;
        for(int i = 0 ; i < obj.len ; i++)
        {
            int temp;
            temp = (int) obj.numberSpinner[i].getValue();
            sum += temp;
        }
        obj.displayUserSelectedLabel.setText(Integer.toString(sum));
        obj.displayUserSelectedLabel.updateUI();
        if (sum > obj.createPanel.totalQuestions || sum < obj.createPanel.totalQuestions)
        {
            obj.createButton.setEnabled(false);
        }
        else
        {
            obj.createButton.setEnabled(true);
        }
    }
    
}
