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
public class StudentInformation implements Serializable{
   int studentId;
   String firstName;
   String lastName;
   int rollNumber;
   int standard;
   char division;
   int batch;

    public StudentInformation(int studentId, String firstName, String lastName, int rollNumber, int standard, char division, int batch) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
        this.standard = standard;
        this.division = division;
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "StudentInformation{" + "studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", rollNumber=" + rollNumber + ", standard=" + standard + ", division=" + division + ", batch=" + batch + '}';
    }
    
   
   
}
