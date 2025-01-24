package com.crio.learnigNavigator.service;


import com.crio.learnigNavigator.exchanges.StudentRequest;
import com.crio.learnigNavigator.model.Exam;
import com.crio.learnigNavigator.model.Student;
import com.crio.learnigNavigator.model.Subject;
import com.crio.learnigNavigator.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StudentServiceTests {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private SubjectServiceImpl subjectService;

    @BeforeEach
    public void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEnrollForSubject() throws Exception {


        Exam exam = new Exam(1, "DSA");
        Subject subject = new Subject(1, "CS", exam);

        Student expectedStudent = new Student(
                1,
                "vivek",
                new ArrayList<Subject>(List.of(subject)),
                new ArrayList<Exam>(List.of(exam))
        );


        when(studentRepository.existsById(1))
                .thenReturn(true);
        when(studentRepository.findById(1))
                .thenReturn(Optional.of(expectedStudent));
        when(subjectService.existsById(1))
                .thenReturn(true);
        when(subjectService.getSubjectById(1))
                .thenReturn(subject);
        when(studentRepository.save(ArgumentMatchers.any()))
                .thenReturn(expectedStudent);

        Student student = studentService.enrolForSubject(1, 1);
        assertEquals(expectedStudent, student);
    }
}
