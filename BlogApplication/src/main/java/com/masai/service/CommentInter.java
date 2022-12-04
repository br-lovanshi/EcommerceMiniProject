package com.masai.service;

import java.util.Set;

import com.masai.exception.CommentException;
import com.masai.exception.PostException;
import com.masai.model.Comment;

public interface CommentInter {

	
	public Comment addCommnet(Comment comment);
	public Comment delete(Integer id) throws CommentException;
	public Comment serchComment(Integer id) throws CommentException;
	public Set<Comment> allComment() throws CommentException;
	
}
