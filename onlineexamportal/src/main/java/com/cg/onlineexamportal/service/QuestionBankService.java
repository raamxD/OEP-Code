package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineexamportal.exception.QuestionBankNotFoundException;
import com.cg.onlineexamportal.model.QuestionBank;

public interface QuestionBankService {
	
	public ResponseEntity<List<QuestionBank>> getQuestionBanks();
	
	public ResponseEntity<QuestionBank> getQuestionBankById(Long questionBankId) throws QuestionBankNotFoundException;
	
	public QuestionBank addQuestionBank(QuestionBank questionBank);
	
	public ResponseEntity<QuestionBank> updateQuestionBankById(Long questionBankId, QuestionBank questionBank) throws QuestionBankNotFoundException;
	
	public ResponseEntity<QuestionBank> deleteQuestionBankById(Long questionBankId) throws QuestionBankNotFoundException;
}
