package com.shurov.polls.controller.controllers.user;

import com.shurov.polls.model.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping(value = "/allQuiz", produces = "application/json")
    public List<Quiz> getAllActiveQuiz() {
        //TODO
        return new ArrayList<>();
    }


    @PostMapping(value = "/vote", produces = "application/json")
    public ResponseEntity<Void> createVote() {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}/quiz", produces = "application/json")
    public List<Quiz> getUsersQuiz(@PathVariable String id) {
        //TODO
        System.out.println("HELLLO");
        return new ArrayList<>();
    }

}
