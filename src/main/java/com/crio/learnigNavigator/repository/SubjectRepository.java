package com.crio.learnigNavigator.repository;

import com.crio.learnigNavigator.model.Exam;
import com.crio.learnigNavigator.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Subject findByExam(Exam exam);
}
