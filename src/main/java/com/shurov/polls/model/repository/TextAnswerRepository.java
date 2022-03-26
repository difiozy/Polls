package com.shurov.polls.model.repository;

import com.shurov.polls.model.entity.TextAnswer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TextAnswerRepository extends JpaRepository<TextAnswer, Long> {
}
