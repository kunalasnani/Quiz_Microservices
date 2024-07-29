package com.microservice.Quiz.Repo;

import com.microservice.Quiz.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface QuizRepo extends JpaRepository<Quiz,Integer> {




}
