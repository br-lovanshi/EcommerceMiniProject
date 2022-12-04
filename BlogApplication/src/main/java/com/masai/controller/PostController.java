package com.masai.controller;

import java.util.List;

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

import com.masai.exception.PostException;
import com.masai.model.Post;
import com.masai.service.PostInter;

@RestController
public class PostController {

	@Autowired
	PostInter pInt;
	

	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getallPosts() throws PostException{
		
		List<Post> post = pInt.allPost();
		
		return new ResponseEntity<List<Post>>(post,HttpStatus.OK);
		
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getById(@RequestParam Integer id) throws PostException{
		
		Post post = pInt.getPostById(id);
		return new ResponseEntity<Post>(post,HttpStatus.OK);
		
	}
	
	@PostMapping("/posts")
	public ResponseEntity<Post> newPost(@RequestBody Post post ) throws PostException{
		
		Post newPost = pInt.addPost(post);
		
		return new ResponseEntity<Post>(newPost,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatedPost(@RequestBody Post post) throws PostException{
		
		Post updated = pInt.updatePost(post);
		
		return new ResponseEntity<Post>(updated,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("posts/{id}")
	public ResponseEntity<Post> delete(@RequestParam Integer id) throws PostException{
		
		Post delete = pInt.DeletePost(id);
		return new ResponseEntity<Post>(delete,HttpStatus.ACCEPTED);
		
	}
	
}
