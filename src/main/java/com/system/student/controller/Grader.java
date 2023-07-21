/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.system.student.controller;

import com.system.student.entities.Marks;

/**
 *
 * @author yomie
 */
public class Grader {

    private static Grader instance;

    public Marks calculateGrade(Average averages, Marks marks) {

        int average = averages.calculateAverage(marks);
        String grade;

        if (average >= 0 && average <= 15) {
            grade = "E";
        } else if (average >= 16 && average <= 25) {
            grade = "D-";
        } else if (average >= 26 && average <= 32) {
            grade = "D";
        } else if (average >= 33 && average <= 39) {
            grade = "D+";
        } else if (average >= 40 && average <= 44) {
            grade = "C-";
        } else if (average >= 45 && average <= 49) {
            grade = "C";
        } else if (average >= 50 && average <= 59) {
            grade = "C+";
        } else if (average >= 60 && average <= 65) {
            grade = "B-";
        } else if (average >= 66 && average <= 69) {
            grade = "B";
        } else if (average >= 70 && average <= 74) {
            grade = "B+";
        } else if (average >= 75 && average <= 100) {
            grade = "A";
        } else {
            grade = "Invalid average value. The average should be between 0 and 100.";
        }
        marks.setGrade(grade);
        return marks;
    }

    public static Grader gradeInstance() {
        if (instance == null) {
            instance = new Grader();
        }
        return instance;
    }
    
    private Grader(){}
}
