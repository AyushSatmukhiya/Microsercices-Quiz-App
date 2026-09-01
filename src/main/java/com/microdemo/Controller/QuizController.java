package com.microdemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microdemo.Modal.QuestionWrapper;
import com.microdemo.Modal.Response;
import com.microdemo.Services.QuizService;

@RestController
@RequestMapping("Quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz
	(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
		return quizService.createQuiz(category,numQ,title);
	}
	
	@GetMapping("getQuiz/{id}")
	 public ResponseEntity<List<QuestionWrapper>>  getQuiz(@PathVariable int id){
		return quizService.getQuizQuestions(id);
	}
	
	@PostMapping("submit/{id}")
	public  ResponseEntity<Integer> submitQuiz
	(@PathVariable int id,@RequestBody List<Response> responses){
		 return quizService.calculateResult(id,responses);
	}
	
}
