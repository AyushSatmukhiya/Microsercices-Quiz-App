package com.microdemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@GetMapping("allquestions")
	public String getAllQuestion() {
		return "HI, these are your question";
	}
}
