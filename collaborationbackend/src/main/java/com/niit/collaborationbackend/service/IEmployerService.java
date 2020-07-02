package com.niit.collaborationbackend.service;

import java.util.ArrayList;

import com.niit.collaborationbackend.Modal.Appliedjobs;
import com.niit.collaborationbackend.Modal.BLogComment;
import com.niit.collaborationbackend.Modal.Blog;
import com.niit.collaborationbackend.Modal.Customer;
import com.niit.collaborationbackend.Modal.Forum;
import com.niit.collaborationbackend.Modal.Forumanswer;
import com.niit.collaborationbackend.Modal.Jobs;

public interface IEmployerService {
	boolean addBlog(Blog b);
	boolean deleteBlog(Blog b);
	boolean updateBlog(Blog b);
	ArrayList<Blog> selectallApprovedBlogs();
	ArrayList<Blog> selectallBlogsOfOneUser(Customer customer);
	
	boolean addBlogComment(BLogComment bc);
	boolean deleteBlogComment(BLogComment bc);
	boolean updateBlogComment(BLogComment bc);
	ArrayList<BLogComment> selectallcomments(Blog  blog);
	public BLogComment selectOneComment(int comment_Id);
	
	
	boolean addAnswer(Forumanswer fanswer);
	boolean deleteAnswer(Forumanswer fanswer);
	boolean updateAnswer(Forumanswer fanswer);
	ArrayList<Forumanswer> selectAllanswer(Forum forum);
	Forumanswer selectOneanswer(int forumanswers_Id);
	
	boolean addJobs(Jobs jobs);
	boolean updateJobs(Jobs jobs);
	boolean deleteJobs(Jobs jobs);
	ArrayList<Jobs> selectallJobs();
	ArrayList<Jobs> selectJobsofOneuser(Customer customer);
	
	
	ArrayList<Appliedjobs> myAppliedjobs(Customer customer);
	
	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	Customer selectCustomer(String cust_email);
	

}
