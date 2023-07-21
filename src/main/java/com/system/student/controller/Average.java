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
public class Average {

    private static Average instance;

    public int calculateAverage(Marks marks) {

        int total= (marks.getChemistry() + marks.getEnglish() + marks.getMaths());
        int average=total/3;
        
        marks.setTotal(total);
        marks.setAverage(average);
        return average;
    }

    public static Average averageInstance() {
        if (instance == null) {
            instance = new Average();
        }
        return instance;

    }

    private Average() {
    }
}
