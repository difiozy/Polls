package com.shurov.polls.model.repository;

import com.shurov.polls.model.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findQuizzesByDateEndIsNullOrDateEndGreaterThan(Date date);
    Optional<Quiz> findQuizzesById(Long id);
}
