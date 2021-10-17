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

@RestController
@RequestMapping("/api")
public class QuestionBankController {
	
	@Autowired
	private QuestionBankService questionBankService;
	
	@GetMapping("/questionBank")
	public ResponseEntity<List<QuestionBank>> getQuestionBanks(){
		return questionBankService.getQuestionBanks();
	}
	
	@GetMapping("/questionBank/{id}")
	public ResponseEntity<QuestionBank> getQuestionBankById(@PathVariable(value = "id") Long questionBankId) throws QuestionBankNotFoundException{
		return questionBankService.getQuestionBankById(questionBankId);
	}
	
	@PostMapping("/questionBank")
	public QuestionBank addQuestionBank(@RequestBody QuestionBank questionBank) {
		return questionBankService.addQuestionBank(questionBank);
	}
	
	@PutMapping("/questionBank/{id}")
	public ResponseEntity<QuestionBank> updateQuestionBankById(@PathVariable(value = "id") Long questionBankId, @RequestBody QuestionBank questionBank) throws QuestionBankNotFoundException{
		return questionBankService.updateQuestionBankById(questionBankId, questionBank);
	}
	
	@DeleteMapping("/questionBank/{id}")
	public ResponseEntity<QuestionBank> deleteQuestionBankById(@PathVariable(value = "id") Long questionBankId) throws QuestionBankNotFoundException{
		return questionBankService.deleteQuestionBankById(questionBankId);
	}

}
