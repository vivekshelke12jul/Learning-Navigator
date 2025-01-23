package com.crio.learnigNavigator.service;

import com.crio.learnigNavigator.exchanges.StudentRequest;
import com.crio.learnigNavigator.model.Student;
import com.crio.learnigNavigator.model.Subject;
import com.crio.learnigNavigator.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ExamService examService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Student createStudent(StudentRequest studentRequest) {
        Student student = mapper.map(studentRequest, Student.class);
        return studentRepository.save(student);
    }

    @Override
    public boolean existsById(Integer studentId) throws Exception {
        if(!studentRepository.existsById(studentId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id:" + studentId);
        }
        return true;
    }

    @Override
    public Student getStudentById(Integer studentId) throws Exception {
        existsById(studentId);
        return studentRepository.findById(studentId).get();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Integer studentId, StudentRequest studentRequest) throws Exception {
        existsById(studentId);
        Student student = studentRepository.findById(studentId).get();
        student.setName(studentRequest.getName());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer studentId) throws Exception {
        existsById(studentId);
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student enrolForSubject(Integer studentId, Integer subjectId) throws Exception {
        existsById(studentId);
        Student student = studentRepository.findById(studentId).get();

        subjectService.existsById(subjectId);
        Subject subject = subjectService.getSubjectById(subjectId);

        student.toggleEnrolledSubject(subject);
        return studentRepository.save(student);
    }
}
