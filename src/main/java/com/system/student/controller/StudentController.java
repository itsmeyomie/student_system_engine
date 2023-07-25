/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.system.student.controller;

import com.system.student.entities.Student;
import com.system.student.jpa.IStudentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    IStudentService service;

    @GetMapping("/students")
    public List<Student> getStudent() {
        return service.findAll();
    }

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        System.out.println("student name :" + student.getFirstName());
        return service.save(student);

    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable("id") Long studentId,@RequestBody Student _student) {

        Student student = service.findByStudentId(studentId);
        System.out.println(_student.getFirstName());
        
        if (student == null) {
            return ResponseEntity.notFound().build();
        } else {
            if (_student.getFirstName() != null) {
                student.setFirstName(_student.getFirstName());
            }

            if (_student.getLastName() != null) {
                student.setLastName(_student.getLastName());
            }

            if (_student.getForm() != null) {
                student.setForm(_student.getForm());
            }

            if (_student.getAdmissionNumber() != null) {
                student.setAdmissionNumber(_student.getAdmissionNumber());
            }

        }
        
        return new ResponseEntity<>(service.save(student), HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") Long studentId
    ) {
        service.deleteById(studentId);

    }

}
