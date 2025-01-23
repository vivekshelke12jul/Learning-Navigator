package com.crio.learnigNavigator.repository;

import com.crio.learnigNavigator.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
