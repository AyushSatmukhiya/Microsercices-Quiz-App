package com.microdemo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public String addQuestion(QuestionDB question) {
		repo.save(question);
		return "Success";
	}

	public String deleteQuestion(int id) {
		repo.deleteById(id);
		return "successfully deleted";
	}

	public String updateDetails(int id,QuestionDB question) {
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
			return "Updated Successfully";
		}
		else {
			return "Question not found with ID:" + id;
		}
	}

	

	
	
	
	
	
}
