package com.microdemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microdemo.Modal.QuestionDB;

@Repository
public interface questionRepository  extends JpaRepository<QuestionDB, Integer>{

	List<QuestionDB> findByCategory(String type);

	
	@Query(value="select * from question_records q where q.category=:category order by random() limit :numQ",nativeQuery =true)
	List<QuestionDB> findRandomQuestionByCategory(String category, int numQ);
   
}
