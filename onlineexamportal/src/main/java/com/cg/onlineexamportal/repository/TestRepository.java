package com.cg.onlineexamportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamportal.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long>{

}
