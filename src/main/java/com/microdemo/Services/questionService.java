package com.microdemo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microdemo.Modal.QuestionDB;
import com.microdemo.Repository.questionRepository;

@Service
public class questionService {

	@Autowired
	questionRepository repo;

	public List<QuestionDB> getAllQuestions() {
		return repo.findAll();
	}

	public List<QuestionDB> searchByCatgeory(String type) {
		return repo.findByCategory(type);
	}	
}
