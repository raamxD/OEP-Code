package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamportal.exception.ResultNotFoundException;
import com.cg.onlineexamportal.model.Result;
import com.cg.onlineexamportal.repository.ResultRepository;

@Service
public class ResultServiceImpl implements ResultService{

	@Autowired
	private ResultRepository resultRepository;
	
	@Override
	public ResponseEntity<List<Result>> getResults(){
		List<Result> results = resultRepository.findAll();
		return ResponseEntity.ok().body(results);
	}

	@Override
	public ResponseEntity<Result> getResultById(Long resultId) throws ResultNotFoundException {
		Result result = resultRepository.findById(resultId).orElseThrow(() -> new ResultNotFoundException("ID : " + resultId + " Not Found"));
		return ResponseEntity.ok().body(result);
	}

	@Override
	public Result addResult(Result result) {
		return resultRepository.save(result);
	}

	@Override
	public ResponseEntity<Result> updateResultById(Long resultId, Result result) throws ResultNotFoundException {
		Result newResult = resultRepository.findById(resultId).orElseThrow(() -> new ResultNotFoundException("ID : " + resultId + " Not Found"));
		// update data here
		newResult.setUserId(result.getUserId());
		newResult.setTestId(result.getTestId());
		newResult.setQuestionId(result.getQuestionId());
		newResult.setChoiceMarked(result.getChoiceMarked());
		final Result updatedResult = resultRepository.save(newResult);
		return ResponseEntity.ok().body(updatedResult);
	}

	@Override
	public ResponseEntity<Result> deleteResultById(Long resultId) throws ResultNotFoundException {
		Result result = resultRepository.findById(resultId).orElseThrow(() -> new ResultNotFoundException("ID : " + resultId + " Not Found"));
		resultRepository.deleteById(resultId);
		return ResponseEntity.ok().body(result);
	}
}
