package com.crio.learnigNavigator.controller;

import com.crio.learnigNavigator.exchanges.SubjectRequest;
import com.crio.learnigNavigator.model.Subject;
import com.crio.learnigNavigator.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSubject(@PathVariable Integer id) throws Exception {
        return subjectService.getSubjectById(id);
    }

    @PostMapping
    public Subject createSubject(@RequestBody SubjectRequest subjectRequest) {
        return subjectService.createSubject(subjectRequest);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable Integer id,@RequestBody SubjectRequest subjectRequest) throws Exception {
        return subjectService.updateSubject(id, subjectRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Integer id) throws Exception {
        subjectService.deleteSubject(id);
    }
}
