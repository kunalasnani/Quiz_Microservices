package com.microservice.Quiz.Controller;

import com.microservice.Quiz.Entity.Quiz;
import com.microservice.Quiz.Service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {


    private final QuizService quizService;


    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @PostMapping("/createQuiz")
    public Quiz createQuiz(@RequestBody Quiz quiz){

        return quizService.add(quiz);



    }

    @GetMapping("/getAll")
    public List<Quiz> getAllQuizes(){

        return  quizService.getAll();

    }
    @GetMapping("/getById/{id}")
    public Quiz getQuizById(@PathVariable int id){
        return quizService.getById(id);
    }

}
