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

    @Autowired
    IMarksService service;

    @GetMapping("/marks/{id}")
    public ResponseEntity<Marks> getStudentMarks(@PathVariable("id") Long studentId) {
        try {
            Marks marks = service.findByStudentId(studentId);
            if (marks.getStudentId() != null) {
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
        System.out.println(marks.getChemistry());
        return service.save(marks);
    }

    @PatchMapping("/marks/{id}")
    public Marks patchMarks(@RequestBody Marks marks) {
        System.out.println("");
        return service.save(marks);

    }

    @DeleteMapping("/marks/{id}")
    public ResponseEntity<Marks> deleteMarks(@PathVariable("id") Long studentId) {
        try {
            Marks marks = service.deleteByStudentId(studentId);
            if (marks.getStudentId() != null) {
                return ResponseEntity.ok(marks);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
