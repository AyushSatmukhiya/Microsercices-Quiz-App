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
    
     
    @Pointcut("execution(public * com.microdemo.Controller.QuestionController.updateQuestion(..))")
    public void updateQuestionPointcut() {}
    
    @Pointcut("execution(public * com.microdemo.Controller.QuestionController.addQuestion(..))")
    public void addQuestionPointcut() {}

    @Pointcut("execution(public * com.microdemo.Controller.QuestionController.deleteQuestion(..))")
    public void deleteQuestionPointcut() {}
    
   
    @Before("updateQuestionPointcut()")
    public void logBeforeupdate() {
        LOOGER.info("question is getting update in the database: PROCESSING");
    }

    @AfterThrowing("updateQuestionPointcut()")
    public void logExceptionupdate() {
        LOOGER.error("issue found: NOT UPDATED INTO THE DATABASE");
    }

    @AfterReturning("updateQuestionPointcut()")
    public void logAfterupdate() {
        LOOGER.info("Question not updated successfully into the database: SUCCESS");
    }
    
    
    
    
    @Before("addQuestionPointcut()")
    public void logBeforeadding() {
        LOOGER.info("question is getting saved in the database: PROCESSING");
    }

    @AfterThrowing("addQuestionPointcut()")
    public void logExceptionadding() {
        LOOGER.error("issue found: NOT SAVED INTO THE DATABASE");
    }

    @AfterReturning("addQuestionPointcut()")
    public void logAfteradding() {
        LOOGER.info("Question saved successfully into the database: SUCCESS");
    }
	
    @Before("deleteQuestionPointcut()")
    public void logBeforedeleting() {
        LOOGER.info("question is getting deleted from  the database: PROCESSING");
    }

    @AfterThrowing("deleteQuestionPointcut()")
    public void logExceptiondeleting() {
        LOOGER.error("issue found: NOT DELETED FROM THE DATABASE");
    }

    @AfterReturning("deleteQuestionPointcut()")
    public void logAfterdeleting() {
        LOOGER.info("Question Deleted successfully from the database: SUCCESS");
    }
	
	
}
