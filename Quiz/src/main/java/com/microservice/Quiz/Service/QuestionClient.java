package com.microservice.Quiz.Service;


import com.microservice.Quiz.Entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8082",value = "Question-Client")
@FeignClient(name = "Questions")
public interface QuestionClient {
    //Using feign client for microservice communication

    @GetMapping("question/quiz/{quizId}")
    List<Question> listOfQuestionOfQuiz(@PathVariable int quizId);

}
