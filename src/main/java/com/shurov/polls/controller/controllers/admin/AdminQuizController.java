package com.shurov.polls.controller.controllers.admin;

import com.shurov.polls.model.entity.Quiz;
import com.shurov.polls.model.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin/quiz")
@AllArgsConstructor
public class AdminQuizController {
    private final QuizRepository quizRepository;
    @GetMapping(value = "/{quizId}", produces = "application/json")
    public Quiz getQuiz(@PathVariable Long quizId) {
        return quizRepository.getById(quizId);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> createQuiz(@RequestBody Quiz quiz) {
        try {
            quiz.setDateStart(new Date(System.currentTimeMillis()));
            quizRepository.save(quiz);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        try {
            Quiz quiz1 = quizRepository.getById(quiz.getId());
            quiz1.setDateEnd(quiz.getDateEnd());
            quiz1.setName(quiz.getName());
            quizRepository.save(quiz1);
            return ResponseEntity.ok().body(quiz1);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(consumes = "application/json")
    public ResponseEntity<Void> deleteQuiz(@RequestBody Quiz quiz) {

        try {
            quizRepository.delete(quiz);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
