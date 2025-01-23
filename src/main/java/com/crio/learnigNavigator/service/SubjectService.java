package com.crio.learnigNavigator.service;

import com.crio.learnigNavigator.exchanges.SubjectRequest;
import com.crio.learnigNavigator.model.Subject;

import java.util.List;

public interface SubjectService {
    public Subject createSubject(SubjectRequest subjectRequest);
    public boolean existsById(Integer subjectId) throws Exception;
    public Subject getSubjectById(Integer subjectId) throws Exception;
    public List<Subject> getAllSubjects();
    public Subject updateSubject(Integer subjectId, SubjectRequest subjectRequest) throws Exception;
    public void deleteSubject(Integer subjectId) throws Exception;
}
