/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.system.student.jpa;

import com.system.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yomie
 */

public interface IStudentService extends  JpaRepository<Student,Long>{
    
}
