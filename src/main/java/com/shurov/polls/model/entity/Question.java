package com.shurov.polls.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JoinColumn(name = "quizId", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    Quiz quiz;

    @Column(name = "text", nullable = false)
    @Size(max = 500)
    String text;

    @Column(name = "type", nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    Type type;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TextAnswer> textAnswers;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AnswerInQuestion> answerInQuestions;
}