package com.crio.learnigNavigator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

//    Student Registration ID (Unique Identifier)
//    Student Name
//    List of enrolled Subjects
//    List of registered Exams

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> enrolledSubjects = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "student_exam",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "exam_id")
    )
    private List<Exam> registeredExams = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    // TODO : unenrolling from a subject should unregister from the exam of that subject.
    public void toggleEnrolledSubject(Subject subject) {
        if (enrolledSubjects.contains(subject)) {
            enrolledSubjects.remove(subject);
        } else {
            enrolledSubjects.add(subject);
        }
    }

    public void toggleRegisteredExam(Exam exam) {
        if (registeredExams.contains(exam)) {
            registeredExams.remove(exam);
        } else {
            registeredExams.add(exam);
        }
    }

}
