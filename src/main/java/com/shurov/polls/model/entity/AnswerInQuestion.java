package com.shurov.polls.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "answerinquestions")
@Entity
@Getter
@Setter
public class AnswerInQuestion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JoinColumn(name = "questionid",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Question question;

    @Column(name = "textAnswer",nullable = false)
    String textAnswer;

    @OneToMany(mappedBy = "answerInQuestion", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ChooseAnswers> chooseAnswers;
}
