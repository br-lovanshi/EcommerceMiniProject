package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Comment;
//import com.masai.model.Post;

public interface CommentRepo  extends JpaRepository<Comment, Integer>{

//	Comment save(Optional<Comment> opt);

}
