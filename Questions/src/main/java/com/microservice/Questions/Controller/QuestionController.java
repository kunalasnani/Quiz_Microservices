package com.microservice.Questions.Controller;

import com.microservice.Questions.Entity.Question;
import com.microservice.Questions.Service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    private  QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @PostMapping("/create")
    public Question createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @GetMapping("/getall")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestion();
    }

    @GetMapping("/getbyid/{id}")
    public Question getQuestionById(@PathVariable int id){
        return questionService.getQuestionById(id);
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deleteById(@PathVariable int id){

        return questionService.deleteById(id);
    }

}
