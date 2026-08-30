package com.microdemo.Aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LogAspectonconsole {

    private  static final Logger LOOGER = LoggerFactory.getLogger(LogAspectonconsole.class);
    
    
    @Pointcut("execution(public * com.microdemo.Controller.QuestionController.addQuestion(..))")
    public void addQuestionPointcut() {}

    @Before("addQuestionPointcut()")
    public void logBefore() {
        LOOGER.info("question is getting saved in the database: PROCESSING");
    }

    @AfterThrowing("addQuestionPointcut()")
    public void logException() {
        LOOGER.info("issue found: NOT SAVED INTO THE DATABASE");
    }

    @AfterReturning("addQuestionPointcut()")
    public void logAfter() {
        LOOGER.info("Question saved successfully into the database: SUCCESS");
    }
	
	
	
	
}
