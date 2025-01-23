package com.crio.learnigNavigator.service;

import com.crio.learnigNavigator.exchanges.StudentRequest;
import com.crio.learnigNavigator.model.Student;

import java.util.List;

public interface StudentService {
    public Student createStudent(StudentRequest studentRequest);
    public boolean existsById(Integer studentId) throws Exception;
    public Student getStudentById(Integer studentId) throws Exception;
    public List<Student> getAllStudents();
    public Student updateStudent(Integer studentId, StudentRequest studentRequest) throws Exception;
    public void deleteStudent(Integer studentId) throws Exception;

    public Student enrolForSubject(Integer studentId, Integer subjectId) throws Exception;
}
