/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.system.student.controller;

import com.system.student.entities.Marks;
import com.system.student.jpa.IMarksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MarksController {

    Average average = Average.averageInstance();
    Grader grade = Grader.gradeInstance();

    @Autowired
    IMarksService service;

    @GetMapping("/marks/{id}")
    public ResponseEntity<Marks> getMarks(@PathVariable("id") Long studentId) {
        try {
            Marks marks = service.findByStudentId(studentId);
            if (marks != null) {
                return ResponseEntity.ok(marks);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/marks")
    public Marks addMarks(@RequestBody Marks marks) {
        average.calculateAverage(marks);
        grade.calculateGrade(average, marks);
        return service.save(marks);
    }

    @PutMapping("/marks/{id}")
    public ResponseEntity<Marks>editMarks(@PathVariable("id") Long studentId, @RequestBody Marks _marks) {
        Marks marks = service.findByStudentId(studentId);
        if (marks == null) {
            return ResponseEntity.notFound().build();
        } else {
            if (_marks.getMaths() != null) {
                marks.setMaths(_marks.getMaths());
            }
            if (_marks.getEnglish() != null) {
                marks.setEnglish(_marks.getEnglish());
            }
            if (_marks.getChemistry() != null) {
                marks.setChemistry(_marks.getChemistry());
            }
            average.calculateAverage(marks);
            grade.calculateGrade(average, marks);
        }
        return new ResponseEntity<>(service.save(marks), HttpStatus.OK);
    }

    @DeleteMapping("/marks/{id}")
    public void deleteMarks(@PathVariable("id") Long marksId) {

        service.deleteById(marksId);

    }

}
