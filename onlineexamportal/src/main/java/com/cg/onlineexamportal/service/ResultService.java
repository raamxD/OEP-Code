package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineexamportal.exception.ResultNotFoundException;
import com.cg.onlineexamportal.model.Result;

public interface ResultService {
	
	public ResponseEntity<List<Result>> getResults();
	
	public ResponseEntity<Result> getResultById(Long resultId) throws ResultNotFoundException;
	
	public Result addResult(Result result);
	
	public ResponseEntity<Result> updateResultById(Long resultId, Result result) throws ResultNotFoundException;
	
	public ResponseEntity<Result> deleteResultById(Long resultId) throws ResultNotFoundException;
}
