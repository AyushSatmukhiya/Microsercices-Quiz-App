package com.microdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microdemo.Modal.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
