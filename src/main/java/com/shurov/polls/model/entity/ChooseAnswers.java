package com.shurov.polls.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "chooseanswers")
public class ChooseAnswers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "variantId")
    @ManyToOne(fetch = FetchType.LAZY)
    private AnswerInQuestion answerInQuestion;
}
