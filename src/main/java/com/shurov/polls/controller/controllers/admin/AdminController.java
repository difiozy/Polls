package com.shurov.polls.controller.controllers.admin;

import com.shurov.polls.model.entity.Quiz;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public List<Quiz> getAllQuiz(){
        List<Quiz> quizList = new ArrayList<>();
        quizList.add(new Quiz());
        return quizList;
    }
}
