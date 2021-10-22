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

import com.cg.onlineexamportal.exception.QuestionBankNotFoundException;
import com.cg.onlineexamportal.model.QuestionBank;
import com.cg.onlineexamportal.service.QuestionBankService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Online exam portal controller",description = "Operations of QuestionBankcontroller")
public class QuestionBankController {
	
	@Autowired
	private QuestionBankService questionBankService;
	
	@ApiOperation(value="View all Question banks",response = ResponseEntity.class)
	@GetMapping("/questionBank")
	public ResponseEntity<List<QuestionBank>> getQuestionBanks(){
		return questionBankService.getQuestionBanks();
	}
	
	@ApiOperation(value="View all Question banks by Id ",response = ResponseEntity.class)
	@GetMapping("/questionBank/{id}")
	public ResponseEntity<QuestionBank> getQuestionBankById(@PathVariable(value = "id") Long questionBankId) throws QuestionBankNotFoundException{
		return questionBankService.getQuestionBankById(questionBankId);
	}
	
	@ApiOperation(value="Add Question bank ",response = QuestionBank.class)
	@PostMapping("/questionBank")
	public QuestionBank addQuestionBank(@RequestBody QuestionBank questionBank) {
		return questionBankService.addQuestionBank(questionBank);
	}
	
	@ApiOperation(value="Update Question banks by Id ",response = ResponseEntity.class)
	@PutMapping("/questionBank/{id}")
	public ResponseEntity<QuestionBank> updateQuestionBankById(@PathVariable(value = "id") Long questionBankId, @RequestBody QuestionBank questionBank) throws QuestionBankNotFoundException{
		return questionBankService.updateQuestionBankById(questionBankId, questionBank);
	}
	
	@ApiOperation(value="Delete Question bank by Id ",response = ResponseEntity.class)
	@DeleteMapping("/questionBank/{id}")
	public ResponseEntity<QuestionBank> deleteQuestionBankById(@PathVariable(value = "id") Long questionBankId) throws QuestionBankNotFoundException{
		return questionBankService.deleteQuestionBankById(questionBankId);
	}
}
