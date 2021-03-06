package com.cg.onlineexamportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamportal.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
