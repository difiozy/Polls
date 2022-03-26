package com.shurov.polls.model.repository;

import com.shurov.polls.model.entity.ChooseAnswers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChooseAnswersRepository extends JpaRepository<ChooseAnswers, Long> {
}
