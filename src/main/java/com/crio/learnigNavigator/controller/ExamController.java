package com.crio.learnigNavigator.controller;

import com.crio.learnigNavigator.exchanges.ExamRequest;
import com.crio.learnigNavigator.model.Exam;
import com.crio.learnigNavigator.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService examService;


    @GetMapping
    public List<Exam> getAllExams(){
        return examService.getAllExams();
    }

    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Integer id) throws Exception{
        return examService.getExamById(id);
    }

    @PostMapping
    public Exam createExam(@RequestBody ExamRequest examRequest){
        return examService.createExam(examRequest);
    }

    @PutMapping("/{id}")
    public Exam updateExam(@PathVariable Integer id, @RequestBody ExamRequest examRequest) throws Exception{
        return examService.updateExam(id, examRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable Integer id) throws Exception{
        examService.deleteExam(id);
    }
}
