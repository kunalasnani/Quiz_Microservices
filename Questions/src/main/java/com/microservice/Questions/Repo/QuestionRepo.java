package com.microservice.Questions.Repo;

import com.microservice.Questions.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Integer> {

    List<Question> findByQuizId(int quizId);
}
