package com.microdemo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microdemo.Modal.QuestionDB;
import com.microdemo.Repository.questionRepository;

@Service
public class questionService {

	@Autowired
	questionRepository repo;

	public ResponseEntity<List<QuestionDB>> getAllQuestions() {
		try {
			return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<QuestionDB>> searchByCatgeory(String type) {
		try {
			return  new ResponseEntity<>(repo.findByCategory(type),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<QuestionDB>>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(QuestionDB question) {
		repo.save(question);
		try {
			return new ResponseEntity<>("Success",HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failure",HttpStatus.NOT_ACCEPTABLE);
		
	}

	public ResponseEntity<String> deleteQuestion(int id) {
		repo.deleteById(id);
		try {
			return new ResponseEntity<>("Successfully Deleted",HttpStatus.FOUND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failure",HttpStatus.NOT_ACCEPTABLE);
	
	}

	public ResponseEntity<String> updateDetails(int id,QuestionDB question) {
		Optional<QuestionDB> tag=repo.findById(id);
		if(tag.isPresent()) {
			QuestionDB existing=tag.get();
			existing.setCategory(question.getCategory());
			existing.setDifficultyLevel(question.getDifficultyLevel());
			existing.setOption1(question.getOption1());
			existing.setOption2(question.getOption2());
			existing.setOption3(question.getOption3());
			existing.setOption4(question.getOption4());
			existing.setQuestionTitle(question.getQuestionTitle());
			existing.setRightAnswer(question.getRightAnswer());
			repo.save(existing);
			try {
				return new  ResponseEntity<>("Updated Successfully",HttpStatus.ACCEPTED);
			} catch (Exception e) {
				e.printStackTrace();
			}
			  return new ResponseEntity<>("Error: ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>("Question not found with ID:",HttpStatus.BAD_REQUEST);
		}
	}

	

	
	
	
	
	
}
