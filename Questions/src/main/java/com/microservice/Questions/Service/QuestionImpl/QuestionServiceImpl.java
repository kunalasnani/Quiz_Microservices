package com.microservice.Questions.Service.QuestionImpl;

import com.microservice.Questions.Entity.Question;
import com.microservice.Questions.Repo.QuestionRepo;
import com.microservice.Questions.Service.QuestionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private  QuestionRepo questionRepo;


    public QuestionServiceImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }


    @Override
    public Question createQuestion(Question question) {
        return questionRepo.save(question) ;
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepo.findAll();
    }

    @Override
    public Question getQuestionById(int id) {
        return questionRepo.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public String deleteById(int id) {

        if(questionRepo.getReferenceById(id) != null){
            questionRepo.deleteById(id);
            return "Question has been deleted";
        }
        else{
            return "Question not found";
        }




    }
}
