package com.crio.learnigNavigator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subject {
//    Subject ID (Unique Identifier)
//    Subject Name
//    List of registered Students

    @Id
    @GeneratedValue
    private Integer id;
    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_id")
    private Exam exam;

    //    Managed from Student side
    //    private List<Student> registeredStudents;
}
