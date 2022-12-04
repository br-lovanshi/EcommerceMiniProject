package com.masai.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CommentException;
import com.masai.exception.PostException;
import com.masai.model.Comment;
import com.masai.model.Post;
import com.masai.service.CommentInter;

@RestController
public class CommentController {
	
	
	@Autowired
	CommentInter pInt;
	
	


	@GetMapping("/Comments")
	public ResponseEntity<Set<Comment>> getallPosts() throws CommentException {
		
		Set<Comment> post = pInt.allComment();
		
		return new ResponseEntity<Set<Comment>>(post,HttpStatus.OK);
		
	}
	
	@GetMapping("/Comments/{id}")
	public ResponseEntity<Comment> getById(@RequestParam Integer id) throws CommentException{
		
		Comment post = pInt.serchComment(id);
		return new ResponseEntity<Comment>(post,HttpStatus.OK);
		
	}
	
	@PostMapping("/Comments")
	public ResponseEntity<Comment> newPost(@RequestBody Comment post ) throws CommentException, PostException{
		
		Comment newPost = pInt.addCommnet(post);
		
		return new ResponseEntity<Comment>(newPost,HttpStatus.CREATED);
		
	}
	
//	@PutMapping("/Comments/{id}")
//	public ResponseEntity<Comment> updatedPost(@RequestBody Comment post) throws CommentException, PostException{
//		
//		Comment updated = pInt.addCommnet(post);
//		
//		return new ResponseEntity<Comment>(updated,HttpStatus.ACCEPTED);
//	}
	
	@DeleteMapping("Comments/{id}")
	public ResponseEntity<Comment> delete(@RequestParam Integer id) throws CommentException{
		
		Comment delete = pInt.delete(id);
		return new ResponseEntity<Comment>(delete,HttpStatus.ACCEPTED);
		
	}
	

}
