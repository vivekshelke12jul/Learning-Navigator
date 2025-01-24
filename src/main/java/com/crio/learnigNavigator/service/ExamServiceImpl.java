package com.crio.learnigNavigator.service;

import com.crio.learnigNavigator.exchanges.ExamRequest;
import com.crio.learnigNavigator.model.Exam;
import com.crio.learnigNavigator.model.Subject;
import com.crio.learnigNavigator.repository.ExamRepository;
import com.crio.learnigNavigator.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Exam createExam(ExamRequest examRequest) throws Exception {
        Exam exam = new Exam(examRequest.getName());
        System.out.println(exam);

        Subject subject = subjectService.getSubjectById(examRequest.getSubjectId());
        if(subject.getExam() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Subject already has an exam");
        }
        Exam savedExam = examRepository.save(exam);
        subject.setExam(savedExam);
        subjectRepository.save(subject);
        return savedExam;
    }

    @Override
    public boolean existsById(Integer examId) throws Exception {
        if(!examRepository.existsById(examId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exam not found with id:" + examId);
        }
        return true;
    }

    @Override
    public Exam getExamById(Integer examId) throws Exception {
        existsById(examId);
        return examRepository.findById(examId).get();
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public Exam updateExam(Integer examId, ExamRequest examRequest) throws Exception {
        existsById(examId);
        Exam exam = examRepository.findById(examId).get();
        exam.setName(examRequest.getName());
        return examRepository.save(exam);
    }

    @Override
    public void deleteExam(Integer examId) throws Exception {
        existsById(examId);
        examRepository.deleteById(examId);
    }
}
