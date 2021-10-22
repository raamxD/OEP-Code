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
	
	/**
	 *	Method Description : Get list of all question banks
	 *	@param 
	 *  @return ResponseEntity<List<QuestionBank>>
	 */
	@Override
	public ResponseEntity<List<QuestionBank>> getQuestionBanks(){
		List<QuestionBank> questionBanks = questionBankRepository.findAll();
		return ResponseEntity.ok().body(questionBanks);
	}

	/**
	 *	Method Description : Get a question bank by id
	 *	@param Long questionBankId
	 *  @return ResponseEntity<QuestionBank>
	 */
	@Override
	public ResponseEntity<QuestionBank> getQuestionBankById(Long questionBankId) throws QuestionBankNotFoundException {
		QuestionBank questionBank = questionBankRepository.findById(questionBankId).orElseThrow(() -> new QuestionBankNotFoundException("Question Bank ID :: " + questionBankId + " Not Found"));
		return ResponseEntity.ok().body(questionBank);
	}

	/**
	 *	Method Description : Create a question bank
	 *	@param Long questionBankId
	 *  @return QuestionBank
	 */
	@Override
	public QuestionBank addQuestionBank(QuestionBank questionBank) {
		return questionBankRepository.save(questionBank);
	}

	/**
	 *	Method Description : Update a question bank by id
	 *	@param Long questionBankId, QuestionBank questionBank
	 *  @return ResponseEntity<QuestionBank>
	 */
	@Override
	public ResponseEntity<QuestionBank> updateQuestionBankById(Long questionBankId, QuestionBank questionBank) throws QuestionBankNotFoundException {
		QuestionBank newQuestionBank = questionBankRepository.findById(questionBankId).orElseThrow(() -> new QuestionBankNotFoundException("Question Bank ID :: " + questionBankId + " Not Found"));
		// update data here
		newQuestionBank.setQuestionbankCourseType(questionBank.getQuestionbankCourseType());
		newQuestionBank.setQuestionbankQuestions(questionBank.getQuestionbankQuestions());
		final QuestionBank updatedQuestionBank = questionBankRepository.save(newQuestionBank);
		return ResponseEntity.ok().body(updatedQuestionBank);
	}

	/**
	 *	Method Description : Delete a question bank by id
	 *	@param Long questionBankId
	 *  @return ResponseEntity<QuestionBank>
	 */
	@Override
	public ResponseEntity<QuestionBank> deleteQuestionBankById(Long questionBankId) throws QuestionBankNotFoundException {
		QuestionBank questionBank = questionBankRepository.findById(questionBankId).orElseThrow(() -> new QuestionBankNotFoundException("Question Bank ID :: " + questionBankId + " Not Found"));
		questionBankRepository.deleteById(questionBankId);
		return ResponseEntity.ok().body(questionBank);
	}
}
