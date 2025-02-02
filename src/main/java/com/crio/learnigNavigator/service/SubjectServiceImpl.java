package com.crio.learnigNavigator.service;

import com.crio.learnigNavigator.exchanges.SubjectRequest;
import com.crio.learnigNavigator.model.Subject;
import com.crio.learnigNavigator.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Subject createSubject(SubjectRequest subjectRequest) {
        Subject subject = mapper.map(subjectRequest, Subject.class);
        return subjectRepository.save(subject);
    }

    public boolean existsById(Integer subjectId) throws Exception {
        if(!subjectRepository.existsById(subjectId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject not found with id:" + subjectId);
        }
        return true;
    }

    @Override
    public Subject getSubjectById(Integer subjectId) throws Exception {
        existsById(subjectId);
        return subjectRepository.findById(subjectId).get();
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject updateSubject(Integer subjectId, SubjectRequest subjectRequest) throws Exception {
        existsById(subjectId);
        Subject subject = subjectRepository.findById(subjectId).get();
        subject.setName(subjectRequest.getName());
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Integer subjectId) throws Exception {
        existsById(subjectId);
        subjectRepository.deleteById(subjectId);
    }
}
