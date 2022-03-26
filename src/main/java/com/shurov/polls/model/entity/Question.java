package com.shurov.polls.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JoinColumn(name = "quizId")
    @ManyToOne(fetch = FetchType.LAZY)
    Quiz quiz;

    @Column(name = "text")
    @Size(max = 500)
    String text;

    @Column(name = "type")
    Type type;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<TextAnswer> textAnswers;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<AnswerInQuestion> answerInQuestions;
}