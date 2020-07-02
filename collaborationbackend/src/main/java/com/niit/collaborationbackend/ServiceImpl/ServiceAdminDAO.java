package com.niit.collaborationbackend.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.collaborationbackend.DAO.BlogCommentDAO;
import com.niit.collaborationbackend.DAO.IBlogDAO;
import com.niit.collaborationbackend.DAO.IForumDAO;
import com.niit.collaborationbackend.DAO.IForumanswerDAO;
import com.niit.collaborationbackend.DAO.IJobsDAO;
import com.niit.collaborationbackend.Modal.BLogComment;
import com.niit.collaborationbackend.Modal.Blog;
import com.niit.collaborationbackend.Modal.Forum;
import com.niit.collaborationbackend.Modal.Forumanswer;
import com.niit.collaborationbackend.Modal.Jobs;
import com.niit.collaborationbackend.service.IAdminService;

@Service
public class ServiceAdminDAO implements IAdminService {
	
	@Autowired
	
	IBlogDAO blogdao;
	
	BlogCommentDAO blogcommentdao;
	
	IForumDAO forumdao;
	
	IForumanswerDAO forumanswerdao;
	
	IJobsDAO jobsdao;
	
	

	@Override
	public ArrayList<Blog> selectallApprovedBlogs() {
		
		 return  blogdao.selectallApprovedBlogs();
	}

	@Override
	public ArrayList<Blog> selectUnApprovedBlogs() {
		
		return  blogdao.selectUnApprovedBlogs();
	}
	

	@Override
	public BLogComment selectOneComment(int comment_Id) {
		
		return blogcommentdao.selectOneComment(comment_Id);
	}

	@Override
	public boolean addForum(Forum forum) {
	
		return forumdao.addForum(forum);
	}

	@Override
	public boolean updateForum(Forum forum) {
		
		return forumdao.updateForum(forum);
	}

	@Override
	public boolean deleteForum(Forum forum) {
		
		return forumdao.deleteForum(forum);
	}

	@Override
	public ArrayList<Forum> selectallForum() {
	
		return forumdao.selectallForum();
	}

	@Override
	public ArrayList<Forumanswer> selectAllanswer(Forum forum) {
		
		return forumanswerdao.selectAllanswer(forum);
	}

	@Override
	public ArrayList<Jobs> selectallJobs() {
		
		return jobsdao.selectallJobs();
	}

	@Override
	public ArrayList<Jobs> selectUnApprovedJobs() {
		
		return jobsdao.selectUnApprovedJobs();
	}

	@Override
	public ArrayList<Forumanswer> selectAllapprovedanswers() {
		return forumanswerdao.selectAllapprovedanswers();
		
	}

	@Override
	public ArrayList<Forumanswer> selectUnapprovedanswer() {
		
	return forumanswerdao.selectUnapprovedanswer();
	}

}
