package com.shurov.polls.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JoinColumn(name = "userId",nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private User user;

    @JoinColumn(name = "questionId", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Question question;

    @Column(name = "textAnswer")
    private String textAnswer;
}
