/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.system.student.jpa;

import com.system.student.entities.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yomie
 */
@Repository
public interface IMarksService extends JpaRepository<Marks, Long> {

    @Query(value = "SELECT * FROM marks m WHERE m.student_id = :id", nativeQuery = true)
    Marks findByStudentId(@Param("id") Long studentId);
    
    
     @Query(value = "delete  FROM marks  WHERE student_id = :id", nativeQuery = true)
    Marks deleteByStudentId(@Param("id") Long studentId);
}


