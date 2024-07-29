package com.microservice.Quiz.Service.impl;

import com.microservice.Quiz.Entity.Quiz;

import com.microservice.Quiz.Repo.QuizRepo;
import com.microservice.Quiz.Service.QuizService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {


    private final QuizRepo quizRepo;


    public QuizServiceImpl(final QuizRepo quizRepo) {
        this.quizRepo = quizRepo;
    }


    @Override
    public Quiz add(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        return quizRepo.findAll();
    }

    @Override
    public Quiz getById(int id) {
        return quizRepo.findById(id).orElseThrow(() -> new RuntimeException("No Quiz found"));
    }
}
