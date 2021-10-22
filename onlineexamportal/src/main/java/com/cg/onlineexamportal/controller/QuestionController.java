package com.cg.onlineexamportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineexamportal.exception.QuestionNotFoundException;
import com.cg.onlineexamportal.model.Question;
import com.cg.onlineexamportal.service.QuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Online exam portal controller",description = "Operations of Questioncontroller")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@ApiOperation(value="View all Questions",response = ResponseEntity.class)
	@GetMapping("/question")
	public ResponseEntity<List<Question>> getQuestions(){
		return questionService.getQuestions();
	}
	
	@ApiOperation(value="View Question by id",response = ResponseEntity.class)
	@GetMapping("/question/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable(value = "id") Long questionId) throws QuestionNotFoundException{
		return questionService.getQuestionById(questionId);
	}
	
	@ApiOperation(value="Add questions",response = Question.class)
	@PostMapping("/question")
	public Question addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	@ApiOperation(value="Update Question by id",response = ResponseEntity.class)
	@PutMapping("/question/{id}")
	public ResponseEntity<Question> updateQuestionById(@PathVariable(value = "id") Long questionId, @RequestBody Question question) throws QuestionNotFoundException{
		return questionService.updateQuestionById(questionId, question);
	}
	
	@ApiOperation(value="Delete Question by id",response = ResponseEntity.class)
	@DeleteMapping("/question/{id}")
	public ResponseEntity<Question> deleteQuestionById(@PathVariable(value = "id") Long questionId) throws QuestionNotFoundException{
		return questionService.deleteQuestionById(questionId);
	}
}
