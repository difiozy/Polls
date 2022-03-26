package com.shurov.polls.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    @Max(150)
    String name;

    @Column(name = "dateStart")
    Date dateStart;

    @Column(name = "dateEnd")
    Date dateEnd;

    @Column(name = "description")
    @Max(500)
    String description;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY)
    private List<Question> questions;

}
