package com.cg.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.jobportal.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	List<Admin> getByEmail(@Param("email") String email);

	 List<Admin> getByPassword(@Param("password") String password);

	 Admin findByUserName(String userName);

	 boolean existsByUserName(String userName);

}
