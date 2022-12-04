package com.masai.service;

import java.lang.StackWalker.Option;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CommentException;
import com.masai.exception.PostException;
import com.masai.model.Comment;
import com.masai.model.Post;
import com.masai.repository.CommentRepo;

@Service
public class CommentInterImpl implements CommentInter{

	
	@Autowired
	PostInter pInt;
	@Autowired
	CommentRepo cRepo;
	
	@Override
	public Comment addCommnet(Comment comment) {
	

		Comment opt = cRepo.save(comment);
		return opt;
		
		
		
	}

	@Override
	public Comment delete(Integer id) throws CommentException {
		// TODO Auto-generated method stub
		
		Optional<Comment> opt = cRepo.findById(id);
		if(opt.isPresent()) {
			Comment deleted = opt.get();
			 cRepo.delete(deleted);
			 return deleted;
		}else
		 throw new CommentException("Comment is Not present");
	}

	@Override
	public Comment serchComment(Integer id) throws CommentException {
		// TODO Auto-generated method stub
		Optional<Comment> opt = cRepo.findById(id);
		if(opt.isPresent()) {
			Comment comm = opt.get();
		return comm;
		}else
			 throw new CommentException("Comment is Not present");
	}

	@Override
	public Set<Comment> allComment() throws CommentException {
		// TODO Auto-generated method stub
		Set<Comment> set = (Set<Comment>) cRepo.findAll();
		if(set.size() == 0) {
		
			 throw new CommentException("Comment is Not present");
		}
		return set;
	}

}
