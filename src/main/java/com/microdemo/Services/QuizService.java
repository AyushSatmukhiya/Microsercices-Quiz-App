package com.microdemo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microdemo.Modal.QuestionDB;
import com.microdemo.Modal.QuestionWrapper;
import com.microdemo.Modal.Quiz;
import com.microdemo.Modal.Response;
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

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Optional<Quiz> quiz=quizdao.findById(id);
		List<QuestionDB> questionFromDB=quiz.get().getQuestions();
		List<QuestionWrapper> questionForUser=new ArrayList<QuestionWrapper>();
		for(QuestionDB q:questionFromDB) {
			QuestionWrapper qw=new QuestionWrapper(q.getId(), q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionForUser.add(qw);
		}
		return new ResponseEntity<List<QuestionWrapper>>(questionForUser,HttpStatus.FOUND);
		
	}

	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
	    Optional<Quiz> quiz=quizdao.findById(id);
	    List<QuestionDB> questionFromQuiz=quiz.get().getQuestions();
	    int right=0;
	    int i=0;
	    for(Response rs:responses) {
	    	if(rs.getResponse().equals(questionFromQuiz.get(i).getRightAnswer())) {
	    		right++;
	    	}
	    	i++;
	    }
		return new  ResponseEntity<Integer>(right,HttpStatus.OK);
	}	
}