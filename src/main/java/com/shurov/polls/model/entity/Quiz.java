package com.shurov.polls.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "name", nullable = false)
    @Max(150)
    String name;

    @Column(name = "dateStart", nullable = false)
    Date dateStart;

    @Column(name = "dateEnd", nullable = true)
    Date dateEnd;

    @Column(name = "description", nullable = false)
    @Max(500)
    String description;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Question> questions;

}
