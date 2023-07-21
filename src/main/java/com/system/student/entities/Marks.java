/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.system.student.entities;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author yomie
 */
@Entity
@Table(name = "marks")
@NamedQueries({
    @NamedQuery(name = "Marks.findAll", query = "SELECT m FROM Marks m"),
    @NamedQuery(name = "Marks.findByMarksId", query = "SELECT m FROM Marks m WHERE m.marksId = :marksId"),
    @NamedQuery(name = "Marks.findByMaths", query = "SELECT m FROM Marks m WHERE m.maths = :maths"),
    @NamedQuery(name = "Marks.findByEnglish", query = "SELECT m FROM Marks m WHERE m.english = :english"),
    @NamedQuery(name = "Marks.findByChemistry", query = "SELECT m FROM Marks m WHERE m.chemistry = :chemistry"),
    @NamedQuery(name = "Marks.findByTotal", query = "SELECT m FROM Marks m WHERE m.total = :total"),
    @NamedQuery(name = "Marks.findByAverage", query = "SELECT m FROM Marks m WHERE m.average = :average"),
    @NamedQuery(name = "Marks.findByGrade", query = "SELECT m FROM Marks m WHERE m.grade = :grade")})
public class Marks implements Serializable {
    
   private static Marks instance;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "marks_id")
    private Integer marksId;
    @Column(name = "maths")
    private Integer maths;
    @Column(name = "english")
    private Integer english;
    @Column(name = "chemistry")
    private Integer chemistry;
    @Column(name = "total")
    private Integer total;
    @Column(name = "average")
    private Integer average;
    @Column(name = "grade")
    private String grade;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
  
    @ManyToOne()
      private Student studentId;
   
     private  Marks() {
    }
    
    public static Marks marksInstance(){
    if(instance==null){
      instance = new Marks();
    }
    return instance;
    }

   

    public Marks(Integer marksId) {
        this.marksId = marksId;
    }

    public Integer getMarksId() {
        return marksId;
    }

    public void setMarksId(Integer marksId) {
        this.marksId = marksId;
    }

    public Integer getMaths() {
        return maths;
    }

    public void setMaths(Integer maths) {
        this.maths = maths;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getChemistry() {
        return chemistry;
    }

    public void setChemistry(Integer chemistry) {
        this.chemistry = chemistry;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marksId != null ? marksId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marks)) {
            return false;
        }
        Marks other = (Marks) object;
        if ((this.marksId == null && other.marksId != null) || (this.marksId != null && !this.marksId.equals(other.marksId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.student.entities.Marks[ marksId=" + marksId + " ]";
    }
    
}
