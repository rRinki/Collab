package com.niit.collaborationbackend.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.collaborationbackend.DAO.BlogCommentDAO;
import com.niit.collaborationbackend.DAO.IAppliedJobs;
import com.niit.collaborationbackend.DAO.IBlogDAO;
import com.niit.collaborationbackend.DAO.ICustomerDAO;
import com.niit.collaborationbackend.DAO.IForumDAO;
import com.niit.collaborationbackend.DAO.IForumanswerDAO;
import com.niit.collaborationbackend.DAO.IJobsDAO;
import com.niit.collaborationbackend.Modal.Appliedjobs;
import com.niit.collaborationbackend.Modal.BLogComment;
import com.niit.collaborationbackend.Modal.Blog;
import com.niit.collaborationbackend.Modal.Customer;
import com.niit.collaborationbackend.Modal.Forum;
import com.niit.collaborationbackend.Modal.Forumanswer;
import com.niit.collaborationbackend.Modal.Jobs;
import com.niit.collaborationbackend.service.IEmployeeService;

@Service
public class ServiceEmployeeDAOImpl implements IEmployeeService {

	
@Autowired
	
	IBlogDAO blogdao;
	
	BlogCommentDAO blogcommentdao;
	
	IForumDAO forumdao;
	
	IForumanswerDAO forumanswerdao;
	
	IJobsDAO jobsdao;
	
	IAppliedJobs appliedjobsdao;
	
	ICustomerDAO customerdao;
	
	
	@Override
	public Blog selectOneBlog(int blog_Id) {
		
		return blogdao.selectOneBlog(blog_Id);
	}

	@Override
	public ArrayList<Blog> selectallApprovedBlogs() {
		
		return blogdao.selectallApprovedBlogs();
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
	public Forum selectOneForum(int forum_Id) {
		
		return forumdao.selectOneForum(forum_Id);
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
	public Jobs selectOneJob(int job_Id) {
		
		return jobsdao.selectOneJob(job_Id);
	}

	@Override
	public ArrayList<Jobs> selectallJobs() {
		
		return jobsdao.selectallJobs();
	}

	@Override
	public boolean addAppliedJobs(Appliedjobs Ajobs) {
		
		return appliedjobsdao.addAppliedJobs(Ajobs);
	}

	@Override
	public ArrayList<Appliedjobs> myAppliedjobs(Customer customer) {
		
		return appliedjobsdao.myAppliedjobs(customer);
	}

	@Override
	public ArrayList<Appliedjobs> selectOneAppliedjobs(int appliedjob_Id) {
		
		return appliedjobsdao.selectOneAppliedjobs(appliedjob_Id);
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
