package com.cg.onlineexamportal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamportal.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long>{
	
	List<Test> findByTestAdminAdminId(Long adminId);
	Optional<Test> findByTestIdAndTestAdminAdminId(Long testId, Long adminId);
}
