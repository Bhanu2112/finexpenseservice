package com.org.bhanu.expenseservice.repository.group;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bhanu.expenseservice.entity.split.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	
	List<Comment> findByGroupId(Long groupId);

}
