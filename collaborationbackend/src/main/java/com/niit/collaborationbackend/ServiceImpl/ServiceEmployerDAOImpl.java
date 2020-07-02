package com.niit.collaborationbackend.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.collaborationbackend.DAO.BlogCommentDAO;
import com.niit.collaborationbackend.DAO.IAppliedJobs;
import com.niit.collaborationbackend.DAO.IBlogDAO;
import com.niit.collaborationbackend.DAO.ICustomerDAO;
import com.niit.collaborationbackend.DAO.IForumanswerDAO;
import com.niit.collaborationbackend.DAO.IJobsDAO;
import com.niit.collaborationbackend.Modal.Appliedjobs;
import com.niit.collaborationbackend.Modal.BLogComment;
import com.niit.collaborationbackend.Modal.Blog;
import com.niit.collaborationbackend.Modal.Customer;
import com.niit.collaborationbackend.Modal.Forum;
import com.niit.collaborationbackend.Modal.Forumanswer;
import com.niit.collaborationbackend.Modal.Jobs;
import com.niit.collaborationbackend.service.IEmployerService;

@Service
public class ServiceEmployerDAOImpl implements IEmployerService {
	
@Autowired
	
	IBlogDAO blogdao;
	
	BlogCommentDAO blogcommentdao;
	
	
	IForumanswerDAO forumanswerdao;
	
	IJobsDAO jobsdao;
	
	IAppliedJobs appliedjobsdao;
	
	ICustomerDAO customerdao;

	@Override
	public boolean addBlog(Blog b) {
		
		return blogdao.addBlog(b);
	}

	@Override
	public boolean deleteBlog(Blog b) {
		
		return blogdao.deleteBlog(b);
	}

	@Override
	public boolean updateBlog(Blog b) {
		
		return blogdao.updateBlog(b);
	}

	@Override
	public ArrayList<Blog> selectallApprovedBlogs() {
		
		return blogdao.selectallApprovedBlogs();
	}

	@Override
	public ArrayList<Blog> selectallBlogsOfOneUser(Customer customer) {
		
		return blogdao.selectallBlogsOfOneUser(customer);
	}

	@Override
	public boolean addBlogComment(BLogComment bc) {
		
		return blogcommentdao.addBlogComment(bc);
	}

	@Override
	public boolean deleteBlogComment(BLogComment bc) {
	
		return blogcommentdao.deleteBlogComment(bc);
	}

	@Override
	public boolean updateBlogComment(BLogComment bc) {
	
		return blogcommentdao.updateBlogComment(bc);
	}

	@Override
	public ArrayList<BLogComment> selectallcomments(Blog blog) {
	
		return blogcommentdao.selectallcomments(blog);
	}

	@Override
	public BLogComment selectOneComment(int comment_Id) {
	
		return blogcommentdao.selectOneComment(comment_Id);
	}

	@Override
	public boolean addAnswer(Forumanswer fanswer) {
		
		return forumanswerdao.addAnswer(fanswer);
	}

	@Override
	public boolean deleteAnswer(Forumanswer fanswer) {
		
		return forumanswerdao.deleteAnswer(fanswer);
	}

	@Override
	public boolean updateAnswer(Forumanswer fanswer) {
		
		return forumanswerdao.updateAnswer(fanswer);
	}

	@Override
	public ArrayList<Forumanswer> selectAllanswer(Forum forum) {

		return forumanswerdao.selectAllanswer(forum);
	}

	@Override
	public Forumanswer selectOneanswer(int forumanswers_Id) {
		
		return forumanswerdao.selectOneanswer(forumanswers_Id);
	}

	@Override
	public boolean addJobs(Jobs jobs) {
		
		return jobsdao.addJobs(jobs);
	}

	@Override
	public boolean updateJobs(Jobs jobs) {
		
		return jobsdao.updateJobs(jobs);
	}

	@Override
	public boolean deleteJobs(Jobs jobs) {
		
		return jobsdao.deleteJobs(jobs);
	}

	@Override
	public ArrayList<Jobs> selectallJobs() {
		
		return jobsdao.selectallJobs();
	}

	@Override
	public ArrayList<Jobs> selectJobsofOneuser(Customer customer) {
		
		return jobsdao.selectJobsofOneuser(customer);
	}

	@Override
	public ArrayList<Appliedjobs> myAppliedjobs(Customer customer) {
	
		return appliedjobsdao.myAppliedjobs(customer);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		
		return customerdao.addCustomer(customer);
	}


	
	@Override
	public boolean updateCustomer(Customer customer) {
		
		return customerdao.updateCustomer(customer);
	}

	@Override
	public Customer selectCustomer(String cust_email) {
		
		return customerdao.selectCustomer(cust_email);
	}

}
