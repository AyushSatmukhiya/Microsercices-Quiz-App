package com.microdemo.Services;

import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microdemo.Modal.QuestionDB;
import com.microdemo.Modal.Quiz;
import com.microdemo.Repository.QuizDao;
import com.microdemo.Repository.questionRepository;

@Service
public class QuizService {

	@Autowired
	QuizDao quizdao;
	
	@Autowired
   	questionRepository repo;

	public ResponseEntity<String>  createQuiz(String category, int numQ, String title) {
		List<QuestionDB> questions= repo.findRandomQuestionByCategory(category,numQ);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizdao.save(quiz);
		 return new ResponseEntity<String>("success",HttpStatus.CREATED);
	}

	
	
	
	 
	
}
