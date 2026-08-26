package com.microdemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microdemo.Modal.QuestionDB;
import com.microdemo.Services.questionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	questionService service;
	
	@GetMapping("allquestions")
	public List<QuestionDB> getAllQuestion() {
		return service.getAllQuestions();
	}
	
	@GetMapping("category/{Type}")
	public List<QuestionDB> getQuestionByCategory(@PathVariable String Type){
		return service.searchByCatgeory(Type);
	}
}
