package com.microservice.Questions.Service;

import com.microservice.Questions.Entity.Question;

import java.util.List;

public interface QuestionService {

    Question createQuestion(Question question);


    List<Question> getAllQuestion();

    Question getQuestionById(int id);

}
