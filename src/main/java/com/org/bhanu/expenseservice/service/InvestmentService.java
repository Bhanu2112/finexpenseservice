package com.org.bhanu.expenseservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bhanu.expenseservice.entity.ExpRecord;
import com.org.bhanu.expenseservice.entity.Investment;
import com.org.bhanu.expenseservice.repository.InvestmentRepository;

@Service
public class InvestmentService {

	@Autowired
	InvestmentRepository investmentRepository;
	
	@Autowired
	ExpRecordService expRecordService;
	
	public Investment createInvestemnt(Investment investment) {
		
		return investmentRepository.save(investment);
	}
	
	
	public List<Investment> getAllInvestmentsOfUser(Long userId){
		return investmentRepository.findAllByUserId(userId);
	}
	
	public Investment getInvestment(Long id) {
		return investmentRepository.findById(id).get();
	}
	
	public void deleteInvestment(Long id) {
		investmentRepository.deleteById(id);
	}
}
