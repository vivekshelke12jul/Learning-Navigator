package com.crio.learnigNavigator.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Exam {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    // Managed from subject Side
    // private Subject subject;

    // Managed from student Side
    // List<Student> enrolledStudents
}
