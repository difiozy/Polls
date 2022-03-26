package com.shurov.polls.controller.controllers.user;

import com.shurov.polls.model.entity.*;
import com.shurov.polls.model.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final QuizRepository quizRepository;
    private final TextAnswerRepository textAnswerRepository;
    private final AnswerInQuestionRepository answerInQuestionRepository;
    private final QuestionRepository questionRepository;
    private final ChooseAnswersRepository chooseAnswersRepository;

    @GetMapping(value = "/allQuiz", produces = "application/json")
    public List<Quiz> getAllActiveQuiz() {
        return quizRepository
                .findQuizzesByDateEndIsNullOrDateEndGreaterThan(new Date(System.currentTimeMillis()));
    }

    @GetMapping(value = "/vote/{quizId}", produces = "application/json")
    public Quiz getQuiz(@PathVariable Long quizId) {
        Quiz quiz = quizRepository.getById(quizId);
        quiz.getQuestions();
        return quiz;
    }

    @GetMapping(value = "/vote/question/{questionId}")
    public Question getQuestion(@PathVariable Long questionId) {

        return questionRepository.getById(questionId);

    }

    @GetMapping(value = "/vote/question/{questionId}/answers")
    public List<AnswerInQuestion> getAnswers(@PathVariable Long questionId) {
        Question question = questionRepository.getById(questionId);
        if (question.getType().equals(Type.TEXT)) {
            return null;
        }

        return answerInQuestionRepository.findAnswerInQuestionsByQuestionEquals(question);
    }

    @PostMapping(value = "/vote/question/{questionId}/type=text", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Void> createVoteText( @PathVariable Long questionId,
                                               @RequestBody String text, @RequestParam Long userId) {

        try {
            TextAnswer textAnswer = new TextAnswer();
            textAnswer.setTextAnswer(text);
            textAnswer.setQuestion(questionRepository.getById(questionId));
            if (userId != null) {
                textAnswer.setUser(userRepository.getById(userId));
            }
            textAnswerRepository.save(textAnswer);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/vote/question/type=enumeration", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Void> createVoteNum(@RequestBody List<AnswerInQuestion> answerInQuestions, @RequestParam Long userId) {
        try {
            for (AnswerInQuestion answer : answerInQuestions) {
                ChooseAnswers choose = new ChooseAnswers();
                if (userId != null) {
                    choose.setUser(userRepository.getById(userId));
                }
                choose.setAnswerInQuestion(answer);
                chooseAnswersRepository.save(choose);
            }
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }


    @GetMapping(value = "/{userId}/textAns", produces = "application/json")
    public List<TextAnswer> getUsersTextAnswer(@PathVariable Long userId) {
        return userRepository.getById(userId).getTextAnswers();

    }
    @GetMapping(value = "/{userId}/chooseAns", produces = "application/json")
    public List<ChooseAnswers> getUsersChooseAnswer(@PathVariable Long userId) {
        return userRepository.getById(userId).getChooseAnswers();
    }

}
