package com.cg.onlineexamportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamportal.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}
