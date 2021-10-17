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
	
	@Override
	public ResponseEntity<List<Question>> getQuestions(){
		List<Question> questions = questionRepository.findAll();
		return ResponseEntity.ok().body(questions);
	}

	@Override
	public ResponseEntity<Question> getQuestionById(Long questionId) throws QuestionNotFoundException {
		Question question = questionRepository.findById(questionId).orElseThrow(() -> new QuestionNotFoundException("ID : " + questionId + " Not Found"));
		return ResponseEntity.ok().body(question);
	}

	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public ResponseEntity<Question> updateQuestionById(Long questionId, Question question) throws QuestionNotFoundException {
		Question newQuestion = questionRepository.findById(questionId).orElseThrow(() -> new QuestionNotFoundException("ID : " + questionId + " Not Found"));
		// update data here
		newQuestion.setQuestionChoice1(question.getQuestionChoice1());
		newQuestion.setQuestionChoice2(question.getQuestionChoice2());
		newQuestion.setQuestionChoice3(question.getQuestionChoice3());
		newQuestion.setQuestionChoice4(question.getQuestionChoice4());
		newQuestion.setQuestionCorrectChoice(question.getQuestionCorrectChoice());
		final Question updatedQuestion = questionRepository.save(newQuestion);
		return ResponseEntity.ok().body(updatedQuestion);
	}

	@Override
	public ResponseEntity<Question> deleteQuestionById(Long questionId) throws QuestionNotFoundException {
		Question question = questionRepository.findById(questionId).orElseThrow(() -> new QuestionNotFoundException("ID : " + questionId + " Not Found"));
		questionRepository.deleteById(questionId);
		return ResponseEntity.ok().body(question);
	}
}
