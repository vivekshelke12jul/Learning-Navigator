package com.crio.learnigNavigator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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
    private List<Subject> enrolledSubjects = new ArrayList<>();

    @ManyToMany
    private List<Exam> registeredExams = new ArrayList<>();

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
