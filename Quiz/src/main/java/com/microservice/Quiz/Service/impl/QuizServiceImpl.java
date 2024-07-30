package com.microservice.Quiz.Service.impl;

import com.microservice.Quiz.Entity.Quiz;

import com.microservice.Quiz.Repo.QuizRepo;
import com.microservice.Quiz.Service.QuestionClient;
import com.microservice.Quiz.Service.QuizService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {


    private final QuizRepo quizRepo;

    private final QuestionClient questionClient;

    public QuizServiceImpl(final QuizRepo quizRepo, QuestionClient questionClient) {
        this.quizRepo = quizRepo;
        this.questionClient = questionClient;
    }


    @Override
    public Quiz add(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz> quizzesWithoutQuestion = quizRepo.findAll();
        List<Quiz> quizzesWithQuestions = quizzesWithoutQuestion.stream().map(quiz ->
        {
            quiz.setQuestions(questionClient.listOfQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).toList();

        return quizzesWithQuestions;

    }

    @Override
    public Quiz getById(int id) {
        Quiz quiz = quizRepo.findById(id).orElseThrow(() -> new RuntimeException("No Quiz found"));
         quiz.setQuestions(questionClient.listOfQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
