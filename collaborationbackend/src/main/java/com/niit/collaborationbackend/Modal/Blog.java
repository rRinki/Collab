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
public class Blog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int blog_Id;
	
	@Column(nullable=false,unique=true)
	String blog_Name;
	
	@Column(nullable=false,columnDefinition="text")
	String blog_Content;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false,columnDefinition= "date default sysdate()")
	Date posted_Date;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Customer customer;
	
	@Column(nullable=false,columnDefinition="boolean default false")
	boolean blog_Status;

	public int getBlog_Id() {
		return blog_Id;
	}

	public void setBlog_Id(int blog_Id) {
		this.blog_Id = blog_Id;
	}

	public String getBlog_Name() {
		return blog_Name;
	}

	public void setBlog_Name(String blog_Name) {
		this.blog_Name = blog_Name;
	}

	public String getBlog_Content() {
		return blog_Content;
	}

	public void setBlog_Content(String blog_Content) {
		this.blog_Content = blog_Content;
	}

	public Date getPosted_Date() {
		return posted_Date;
	}

	public void setPosted_Date(Date posted_Date) {
		this.posted_Date = posted_Date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isBlog_Status() {
		return blog_Status;
	}

	public void setBlog_Status(boolean blog_Status) {
		this.blog_Status = blog_Status;
	}

}