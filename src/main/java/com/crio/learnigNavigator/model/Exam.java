package com.crio.learnigNavigator.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Exam {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    // Managed from student Side
    // List<Student> enrolledStudents

    public Exam(String name){
        this.name = name;
    }
}
