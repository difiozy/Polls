package com.shurov.polls.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "textanswers")
@Getter
@Setter
@Entity
public class TextAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "questionId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @Column(name = "textAnswer")
    private String textAnswer;
}
