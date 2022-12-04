package com.masai.service;

import java.util.List;

import com.masai.exception.PostException;
import com.masai.model.Post;

public interface PostInter {
	
	public Post addPost(Post post)throws PostException;
	public Post updatePost(Post post) throws PostException;
	public Post DeletePost(Integer postId) throws PostException;
	public Post getPostById(Integer postId) throws PostException;
	public List<Post> allPost() throws PostException;
	

}
