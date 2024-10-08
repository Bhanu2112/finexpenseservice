package com.org.bhanu.expenseservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bhanu.expenseservice.entity.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {

	List<Investment> findAllByUserId(Long userId);
}
