package com.cg.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.jobportal.entity.BookmarkedFreelancer;

@Repository
public interface BookmarkedFreelancerRepository extends JpaRepository<BookmarkedFreelancer, Long> {

}
