package com.shurov.polls.controller.controllers.admin;

import com.shurov.polls.model.entity.Question;
import com.shurov.polls.model.entity.Quiz;
import com.shurov.polls.model.repository.QuestionRepository;
import com.shurov.polls.model.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/{quizId}/question")
@AllArgsConstructor
public class AdminQuestionController {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    @GetMapping
    public List<Question> getQuestions(@PathVariable Long quizId) {
        try {
            return quizRepository.getById(quizId).getQuestions();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<Void> addQuestion(@PathVariable Long quizId, @RequestBody Question question) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            questionRepository.save(question);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Question> updateQuestion(@PathVariable Long quizId, @RequestBody Question question) {
        try {
            if (quizRepository.findById(quizId).isEmpty()){
                throw new IllegalArgumentException();
            }
            Question question1 = questionRepository.getById(question.getId());
            question1.setText(question.getText());
            questionRepository.save(question1);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteQuestion(@RequestBody Question question, @PathVariable Long quizId){
        try
        {
            if (quizRepository.findById(quizId).isEmpty()){
                throw new IllegalArgumentException();
            }
            questionRepository.delete(question);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
