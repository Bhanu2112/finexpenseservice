package com.org.bhanu.expenseservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.bhanu.expenseservice.entity.Investment;
import com.org.bhanu.expenseservice.service.InvestmentService;

@RestController
@CrossOrigin
public class InvestmentController {

	@Autowired
	InvestmentService investmentService;
	
	@PostMapping("/createinvestment")
	public Investment createInvestment(@RequestBody  Investment investment) {
		return investmentService.createInvestemnt(investment);
	}
	
	@GetMapping("/allinvestments/{userId}")
	public List<Investment> allInvestmentsOfUser(@PathVariable Long userId){
		return investmentService.getAllInvestmentsOfUser(userId);
	}
	
	@GetMapping("/invest/{id}")
	public Investment getInvestment(@PathVariable Long id) {
		return investmentService.getInvestment(id);
	}
	
	@DeleteMapping("/invest/delete/{id}")
	public void deleteInvestment(@PathVariable Long id) {
		investmentService.deleteInvestment(id);
	}
}
