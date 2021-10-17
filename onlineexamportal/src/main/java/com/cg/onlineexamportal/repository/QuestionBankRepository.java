package com.cg.onlineexamportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamportal.model.QuestionBank;

@Repository
public interface QuestionBankRepository extends JpaRepository<QuestionBank, Long>{

}
