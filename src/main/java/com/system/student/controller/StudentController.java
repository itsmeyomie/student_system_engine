/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.system.student.controller;


import com.system.student.entities.Student;
import com.system.student.jpa.IStudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println("student name : "+student.getFirstName());
      return  service.save(student);
        

    }

    @PutMapping("/student")
    public Student editStudent(@RequestBody Student student) {
      return  service.save(student);
        
    }
    
    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") Long studentId) {
        service.deleteById(studentId);
       
    }

}
