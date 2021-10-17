package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineexamportal.exception.QuestionNotFoundException;
import com.cg.onlineexamportal.model.Question;

public interface QuestionService {
	
	// question crud
	
	public ResponseEntity<List<Question>> getQuestions();
	
	public ResponseEntity<Question> getQuestionById(Long questionId) throws QuestionNotFoundException;
	
	public Question addQuestion(Question question);
	
	public ResponseEntity<Question> updateQuestionById(Long questionId, Question question) throws QuestionNotFoundException;
	
	public ResponseEntity<Question> deleteQuestionById(Long questionId) throws QuestionNotFoundException;
	
	// question functionalities
	
}
