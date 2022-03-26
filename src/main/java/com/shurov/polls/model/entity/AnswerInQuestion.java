package com.shurov.polls.model.entity;

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

    @JoinColumn(name = "questionid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @Column(name = "textAnswer")
    String textAnswer;

    @OneToMany(mappedBy = "answerInQuestion", fetch = FetchType.LAZY)
    private List<ChooseAnswers> chooseAnswers;
}
