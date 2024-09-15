package com.org.bhanu.expenseservice.controller.group;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.bhanu.expenseservice.dao.RequestsAndSettlementDAO;
import com.org.bhanu.expenseservice.entity.split.Comment;
import com.org.bhanu.expenseservice.entity.split.Group;
import com.org.bhanu.expenseservice.entity.split.GroupMember;
import com.org.bhanu.expenseservice.request.GroupRequest;

import com.org.bhanu.expenseservice.service.group.GroupService;

@RestController
@CrossOrigin
public class GroupController {
	
	
	@Autowired
	private GroupService groupService;
	
	
	
	@GetMapping("/allgroups")
	public List<Group> getAllGroups(){
		return groupService.getAllGroups();
	}
	
	@PostMapping("/creategroup")
	public Group createGroup( @RequestBody GroupRequest groupRequest) {
		return groupService.createGroup(groupRequest);
	}
	
	@GetMapping("/groups/{userId}")
	public List<Group> findAllGroupsWithUserId(@PathVariable Long userId){
		return groupService.getAllGroupsOfUser(userId);
	}
	
	
	@GetMapping("/member/{memberId}")
	public List<Group> getGroupOfMember(@PathVariable Long memberId) {
		return groupService.getGroupsForMember(memberId);
	}
	
	
	@GetMapping("/mem/{memberid}")
	public GroupMember getGM(@PathVariable Long memberid) {
		return groupService.getGM(memberid);
	}
	
	@GetMapping("/group")
	public Group findGroup(@RequestParam(name="groupid") Long groupId) {
		return groupService.findGroup(groupId);
	}
	
	
	
	@GetMapping("/reqsettlel/{memberId}")
	public List<RequestsAndSettlementDAO> getAllRequestsAndSettlements(@PathVariable Long memberId){
		return groupService.getAllRequestsAndSettlements(memberId);
	}
	
	@GetMapping("/update/payment/status/{memberId}")
	public String updatePaymentStatus(@PathVariable Long memberId) {
		System.out.println(memberId);
		return groupService.updatePaymentStatus(memberId);
	}
	


}
