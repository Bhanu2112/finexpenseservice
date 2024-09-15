package com.org.bhanu.expenseservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bhanu.expenseservice.entity.ExpRecord;
import com.org.bhanu.expenseservice.repository.ExpRecordRepository;

@Service

public class ExpRecordService {
	
	@Autowired
	private ExpRecordRepository recordRepository;
	
	
	public ExpRecord createRecord(ExpRecord record) {
		return recordRepository.save(record);
	}
	
	
	
	public List<ExpRecord> saveAll(List<ExpRecord> records){
		return recordRepository.saveAll(records);
	}
	
	
	
	public List<ExpRecord> findAllRecordsByUserId(Long userId){
		return recordRepository.findAllByUserId(userId);
	}
	
	public SortedMap<LocalDate, List<ExpRecord>> getRecordsByMonthAndYear(int month, int year,Long memberId) {
		List<ExpRecord> monthlyRecords = recordRepository.findByMonthAndYear(month, year,memberId);
		
		SortedMap<LocalDate, List<ExpRecord>> sortedMap = new TreeMap<>();
		//List<ExpRecord> expRecords = ;
		
		monthlyRecords.stream().collect(Collectors.groupingBy(ExpRecord::getDate)).entrySet()
		.forEach(e -> {
			
			sortedMap.put(e.getKey(),new ArrayList<ExpRecord>(e.getValue()) );
		});
        
        
      //  return recordRepository.findByMonthAndYear(month, year,memberId);
       // return monthlyRecords;
//		return sortedMap;
		 return monthlyRecords.stream()
		            .collect(Collectors.groupingBy(
		                    ExpRecord::getDate, // Group by date
		                    TreeMap::new,       // Use TreeMap for sorted keys
		                    Collectors.toList() // Collect records into a list
		            ));
    }

}
