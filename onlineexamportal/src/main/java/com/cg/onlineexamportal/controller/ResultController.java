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

import com.cg.onlineexamportal.exception.ResultNotFoundException;
import com.cg.onlineexamportal.model.Result;
import com.cg.onlineexamportal.service.ResultService;

@RestController
@RequestMapping("/api")
public class ResultController {
	
	@Autowired
	private ResultService resultService;
	
	@GetMapping("/result")
	public ResponseEntity<List<Result>> getResults(){
		return resultService.getResults();
	}
	
	@GetMapping("/result/{id}")
	public ResponseEntity<Result> getResultById(@PathVariable(value = "id") Long resultId) throws ResultNotFoundException{
		return resultService.getResultById(resultId);
	}
	
	@PostMapping("/result")
	public Result addResult(@RequestBody Result result) {
		return resultService.addResult(result);
	}
	
	@PutMapping("/result/{id}")
	public ResponseEntity<Result> updateResultById(@PathVariable(value = "id") Long resultId, @RequestBody Result result) throws ResultNotFoundException{
		return resultService.updateResultById(resultId, result);
	}
	
	@DeleteMapping("/result/{id}")
	public ResponseEntity<Result> deleteResultById(@PathVariable(value = "id") Long resultId) throws ResultNotFoundException{
		return resultService.deleteResultById(resultId);
	}
}
