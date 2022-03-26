package com.shurov.polls.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<TextAnswer> textAnswers;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ChooseAnswers> chooseAnswers;
}
