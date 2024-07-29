package com.microservice.Quiz.Service;

import com.microservice.Quiz.Entity.Quiz;

import java.util.List;

public interface QuizService {



    Quiz add(Quiz quiz);

    List<Quiz> getAll();

    Quiz getById(int id);

}
