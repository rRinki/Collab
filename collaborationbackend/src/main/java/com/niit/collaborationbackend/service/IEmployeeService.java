package com.niit.collaborationbackend.service;

import java.util.ArrayList;

import com.niit.collaborationbackend.Modal.Appliedjobs;
import com.niit.collaborationbackend.Modal.BLogComment;
import com.niit.collaborationbackend.Modal.Blog;
import com.niit.collaborationbackend.Modal.Customer;
import com.niit.collaborationbackend.Modal.Forum;
import com.niit.collaborationbackend.Modal.Forumanswer;
import com.niit.collaborationbackend.Modal.Jobs;

public interface IEmployeeService {
				
	
	Blog selectOneBlog(int blog_Id);
	ArrayList<Blog> selectallApprovedBlogs();
	
	
	boolean addBlogComment(BLogComment bc);
	boolean deleteBlogComment(BLogComment bc);
	boolean updateBlogComment(BLogComment bc);
	ArrayList<BLogComment> selectallcomments(Blog  blog);
	public BLogComment selectOneComment(int comment_Id);

	Forum selectOneForum(int forum_Id);
	
	boolean addAnswer(Forumanswer fanswer);
	boolean deleteAnswer(Forumanswer fanswer);
	boolean updateAnswer(Forumanswer fanswer);
	ArrayList<Forumanswer> selectAllanswer(Forum forum);
	Forumanswer selectOneanswer(int forumanswers_Id);
	
	Jobs selectOneJob(int job_Id);
	ArrayList<Jobs> selectallJobs();
	
	boolean addAppliedJobs(Appliedjobs Ajobs);
	ArrayList<Appliedjobs> myAppliedjobs(Customer customer);
	ArrayList<Appliedjobs> selectOneAppliedjobs(int appliedjob_Id);
	
	boolean addCustomer(Customer customer);
	
	boolean updateCustomer(Customer customer);
	
	Customer selectCustomer(String cust_email);
	
	}
