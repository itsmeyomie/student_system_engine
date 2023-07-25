/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.system.student.jpa;

import com.system.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author yomie
 */

public interface IStudentService extends  JpaRepository<Student,Long>{
      @Query(value = "SELECT * FROM student s WHERE s.student_id = :id", nativeQuery = true)
      Student findByStudentId(@Param("id") Long studentId);
    
}
