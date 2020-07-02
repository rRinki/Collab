package com.niit.collaborationbackend.Modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class BLogComment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int comment_Id;
	
	@ManyToOne
	@OnDelete(action= OnDeleteAction.CASCADE)
	Blog blog;
	
	@ManyToOne
	@OnDelete(action =OnDeleteAction.CASCADE)
	Customer customer;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, columnDefinition = "date default sysdate()")
	Date date;
	
	@Column(nullable = false, columnDefinition="text")
	String comment;

	public int getComment_Id() {
		return comment_Id;
	}

	public void setComment_Id(int comment_Id) {
		this.comment_Id = comment_Id;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
