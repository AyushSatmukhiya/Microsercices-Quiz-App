package com.microdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microdemo.Modal.QuestionDB;

@Repository
public interface questionRepository  extends JpaRepository<QuestionDB, Integer>{

}
