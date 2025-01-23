package com.crio.learnigNavigator.controller;

import com.crio.learnigNavigator.exchanges.StudentRequest;
import com.crio.learnigNavigator.model.Student;
import com.crio.learnigNavigator.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class SutudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) throws Exception {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentRequest studentRequest) throws Exception {
        return studentService.createStudent(studentRequest);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody StudentRequest studentRequest) throws Exception {
        return studentService.updateStudent(id, studentRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) throws Exception {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{studentId}/enroll-subject/{subjectId}")
    public Student enrolForSubject(@PathVariable Integer studentId, @PathVariable Integer subjectId) throws Exception {
        return studentService.enrolForSubject(studentId, subjectId);
    }
}
