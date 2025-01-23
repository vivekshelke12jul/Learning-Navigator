package com.crio.learnigNavigator.service;

import com.crio.learnigNavigator.exchanges.ExamRequest;
import com.crio.learnigNavigator.model.Exam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ExamService {

    public Exam createExam(ExamRequest examRequest) throws Exception;
    public boolean existsById(Integer examId) throws Exception;
    public Exam getExamById(Integer examId) throws Exception;
    public List<Exam> getAllExams();
    public Exam updateExam(Integer examId, ExamRequest examRequest) throws Exception;
    public void deleteExam(Integer examId) throws Exception;
}
