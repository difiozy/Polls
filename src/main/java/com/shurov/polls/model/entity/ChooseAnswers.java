package com.shurov.polls.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JoinColumn(name = "userId", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private User user;

    @JoinColumn(name = "variantId", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private AnswerInQuestion answerInQuestion;
}
