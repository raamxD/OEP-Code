package com.cg.onlineexamportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamportal.model.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long>{

}
