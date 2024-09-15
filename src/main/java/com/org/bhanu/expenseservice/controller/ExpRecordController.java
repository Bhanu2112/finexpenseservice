package com.org.bhanu.expenseservice.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.bhanu.expenseservice.entity.ExpRecord;
import com.org.bhanu.expenseservice.repository.ExpRecordRepository;
import com.org.bhanu.expenseservice.service.ExpRecordService;


@RestController
@CrossOrigin
@RequestMapping("/records")
public class ExpRecordController {

	@Autowired
	private ExpRecordService recordService;

	@PostMapping("/create/record")
	public ExpRecord createRecord(@RequestBody ExpRecord record) {
		return recordService.createRecord(record);
	}
	
	
	@PostMapping("/saveall/rec")
	public List<ExpRecord> saveAll(@RequestBody List<ExpRecord> records){
		return recordService.saveAll(records);
	}

	@GetMapping("/record/{userId}")
	public List<ExpRecord> getAllReordsOfUser(@PathVariable Long userId) {
		return recordService.findAllRecordsByUserId(userId);
	}

	@GetMapping("/exp-records")
	public SortedMap<LocalDate, List<ExpRecord>> getExpRecordsByMonthAndYear(@RequestParam int month, @RequestParam int year,
			@RequestParam Long memberId) {
		return recordService.getRecordsByMonthAndYear(month, year, memberId);
	}

}
