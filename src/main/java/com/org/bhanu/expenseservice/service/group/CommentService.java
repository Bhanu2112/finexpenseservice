package com.org.bhanu.expenseservice.service.group;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bhanu.expenseservice.entity.split.Comment;
import com.org.bhanu.expenseservice.entity.split.Group;
import com.org.bhanu.expenseservice.repository.group.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	
	public Comment createComment(String msg,Long groupId) {
		Comment comment = new Comment();
		Group group = new Group();
		group.setId(groupId);
		comment.setMessage(msg);
		comment.setGroupId(groupId);
		return commentRepository.save(comment);
	}
	
	public List<Comment> getComments(Long groupId){
		return commentRepository.findByGroupId(groupId);
	}
	
}
