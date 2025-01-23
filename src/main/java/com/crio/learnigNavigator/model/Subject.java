package com.crio.learnigNavigator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Subject {
//    Subject ID (Unique Identifier)
//    Subject Name
//    List of registered Students

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToOne
    private Exam exam;

    //    Managed from Student side
    //    private List<Student> registeredStudents;
}
