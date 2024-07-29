package com.microservice.Questions.Repo;

import com.microservice.Questions.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question,Integer> {


}
