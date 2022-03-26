package com.shurov.polls.model.repository;

import com.shurov.polls.model.entity.AnswerInQuestion;
import com.shurov.polls.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerInQuestionRepository extends JpaRepository<AnswerInQuestion, Long> {
    List<AnswerInQuestion> findAnswerInQuestionsByQuestionEquals(Question question);
}
