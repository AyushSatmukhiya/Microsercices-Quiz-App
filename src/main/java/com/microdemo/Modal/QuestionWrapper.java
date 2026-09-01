package com.microdemo.Modal;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class QuestionWrapper {

	
	@Column(name = "id")
    private Integer id;

	 @Column(name = "question_title")
	 private String questionTitle;
	 
    @Column(name = "option1")
    private String option1;

    @Column(name = "option2")
    private String option2;

    @Column(name = "option3")
    private String option3;

    @Column(name = "option4")
    private String option4;

}
