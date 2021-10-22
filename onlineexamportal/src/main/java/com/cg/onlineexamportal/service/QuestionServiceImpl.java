package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamportal.exception.QuestionNotFoundException;
import com.cg.onlineexamportal.model.Question;
import com.cg.onlineexamportal.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	/**
	 *	Method Description : Get list of all questions
	 *	@param 
	 *  @return ResponseEntity<List<Question>>
	 */
	@Override
	public ResponseEntity<List<Question>> getQuestions(){
		List<Question> questions = questionRepository.findAll();
		return ResponseEntity.ok().body(questions);
	}

	/**
	 *	Method Description : Get a question by id
	 *	@param Long questionId
	 *  @return ResponseEntity<Question>
	 */
	@Override
	public ResponseEntity<Question> getQuestionById(Long questionId) throws QuestionNotFoundException {
		Question question = questionRepository.findById(questionId).orElseThrow(() -> new QuestionNotFoundException("Question ID :: " + questionId + " Not Found"));
		return ResponseEntity.ok().body(question);
	}

	/**
	 *	Method Description : Get a question by id
	 *	@param Question question
	 *  @return Question
	 */
	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	/**
	 *	Method Description : Update a question by id
	 *	@param Long questionId, Question question
	 *  @return ResponseEntity<Question>
	 */
	@Override
	public ResponseEntity<Question> updateQuestionById(Long questionId, Question question) throws QuestionNotFoundException {
		Question newQuestion = questionRepository.findById(questionId).orElseThrow(() -> new QuestionNotFoundException("Question ID :: " + questionId + " Not Found"));
		newQuestion.setQuestionSentence(question.getQuestionSentence());
		newQuestion.setQuestionChoice1(question.getQuestionChoice1());
		newQuestion.setQuestionChoice2(question.getQuestionChoice2());
		newQuestion.setQuestionChoice3(question.getQuestionChoice3());
		newQuestion.setQuestionChoice4(question.getQuestionChoice4());
		newQuestion.setQuestionCorrectChoice(question.getQuestionCorrectChoice());
		final Question updatedQuestion = questionRepository.save(newQuestion);
		return ResponseEntity.ok().body(updatedQuestion);
	}

	/**
	 *	Method Description : Delete a question by id
	 *	@param Long questionId
	 *  @return ResponseEntity<Question>
	 */
	@Override
	public ResponseEntity<Question> deleteQuestionById(Long questionId) throws QuestionNotFoundException {
		Question question = questionRepository.findById(questionId).orElseThrow(() -> new QuestionNotFoundException("Question ID :: " + questionId + " Not Found"));
		questionRepository.deleteById(questionId);
		return ResponseEntity.ok().body(question);
	}
}
