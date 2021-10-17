package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamportal.exception.QuestionBankNotFoundException;
import com.cg.onlineexamportal.model.QuestionBank;
import com.cg.onlineexamportal.repository.QuestionBankRepository;

@Service
public class QuestionBankServiceImpl implements QuestionBankService{

	@Autowired
	private QuestionBankRepository questionBankRepository;
	
	@Override
	public ResponseEntity<List<QuestionBank>> getQuestionBanks(){
		List<QuestionBank> questionBanks = questionBankRepository.findAll();
		return ResponseEntity.ok().body(questionBanks);
	}

	@Override
	public ResponseEntity<QuestionBank> getQuestionBankById(Long questionBankId) throws QuestionBankNotFoundException {
		QuestionBank questionBank = questionBankRepository.findById(questionBankId).orElseThrow(() -> new QuestionBankNotFoundException("ID : " + questionBankId + " Not Found"));
		return ResponseEntity.ok().body(questionBank);
	}

	@Override
	public QuestionBank addQuestionBank(QuestionBank questionBank) {
		return questionBankRepository.save(questionBank);
	}

	@Override
	public ResponseEntity<QuestionBank> updateQuestionBankById(Long questionBankId, QuestionBank questionBank) throws QuestionBankNotFoundException {
		QuestionBank newQuestionBank = questionBankRepository.findById(questionBankId).orElseThrow(() -> new QuestionBankNotFoundException("ID : " + questionBankId + " Not Found"));
		// update data here
		final QuestionBank updatedQuestionBank = questionBankRepository.save(newQuestionBank);
		return ResponseEntity.ok().body(updatedQuestionBank);
	}

	@Override
	public ResponseEntity<QuestionBank> deleteQuestionBankById(Long questionBankId) throws QuestionBankNotFoundException {
		QuestionBank questionBank = questionBankRepository.findById(questionBankId).orElseThrow(() -> new QuestionBankNotFoundException("ID : " + questionBankId + " Not Found"));
		questionBankRepository.deleteById(questionBankId);
		return ResponseEntity.ok().body(questionBank);
	}
}
