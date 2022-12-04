package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.PostException;
import com.masai.model.Post;
import com.masai.repository.PostRepository;

@Service
public class PostInterImpl implements PostInter {

	@Autowired
	PostRepository pRepo;
	
	@Override
	public Post addPost(Post post) throws PostException {
		// TODO Auto-generated method stub
		
		Post savePost =  pRepo.save(post);
		return savePost;
	}

	@Override
	public Post updatePost(Post post) throws PostException {
		// TODO Auto-generated method stub
		Optional<Post> opt = pRepo.findById(post.getId());
		if(opt.isPresent()) {
			
			Post updated =  pRepo.save(post);
			return updated;
		}
		else    throw new PostException("This post is not present");
	}

	@Override
	public Post DeletePost(Integer postId) throws PostException {
		// TODO Auto-generated method stub
		Optional<Post> opt = pRepo.findById(postId);
		if(opt.isPresent()) {
			Post deleted = opt.get();
			 pRepo.delete(deleted);
			 return deleted;
		}else
		 throw new PostException("Post is Not present");
	}

	@Override
	public Post getPostById(Integer postId) throws PostException {
		// TODO Auto-generated method stub
		Optional<Post> opt = pRepo.findById(postId);
		if(opt.isPresent()) {
			
			Post found = opt.get();
			return found;
		}
		
		throw new PostException("This post is not present");
	}

	@Override
	public List<Post> allPost() throws PostException {
		// TODO Auto-generated method stub
		List<Post> allPosts = pRepo.findAll();
		if(allPosts.size() == 0) 
			throw new PostException("This post is not present");
		return allPosts;
	}

	
}
