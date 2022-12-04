package com.masai.model;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity

@Table(name="comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
private String content;

@ManyToOne
private Post post;

public Comment() {
	// TODO Auto-generated constructor stub
}

public Comment(Integer id, String content, Post post) {
	super();
	this.id = id;
	this.content = content;
	this.post = post;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public Post getPost() {
	return post;
}

public void setPost(Post post) {
	this.post = post;
}

@Override
public int hashCode() {
	return Objects.hash(content, id, post);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Comment other = (Comment) obj;
	return Objects.equals(content, other.content) && Objects.equals(id, other.id) && Objects.equals(post, other.post);
}

@Override
public String toString() {
	return "Comment [id=" + id + ", content=" + content + ", post=" + post + "]";
}


}
