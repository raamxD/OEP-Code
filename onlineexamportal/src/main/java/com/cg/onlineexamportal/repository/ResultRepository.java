package com.cg.onlineexamportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamportal.model.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long>{
	List<Result> findByUserIdAndTestId(Long userId, Long testId);
}
