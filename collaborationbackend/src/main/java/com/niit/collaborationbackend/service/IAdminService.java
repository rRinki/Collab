package com.niit.collaborationbackend.service;

import java.util.ArrayList;

import com.niit.collaborationbackend.Modal.BLogComment;
import com.niit.collaborationbackend.Modal.Blog;
import com.niit.collaborationbackend.Modal.Forum;
import com.niit.collaborationbackend.Modal.Forumanswer;
import com.niit.collaborationbackend.Modal.Jobs;

public interface IAdminService {
	
	ArrayList<Blog> selectallApprovedBlogs();
	ArrayList<Blog> selectUnApprovedBlogs();
	
	
	
	public BLogComment selectOneComment(int comment_Id);
	
	boolean addForum(Forum forum);
	boolean updateForum(Forum forum);
	boolean deleteForum(Forum forum);
	ArrayList<Forum> selectallForum();
	ArrayList<Forumanswer> selectAllapprovedanswers();
	ArrayList<Forumanswer> selectUnapprovedanswer();
	ArrayList<Forumanswer> selectAllanswer(Forum forum);
	
	ArrayList<Jobs> selectallJobs();
	ArrayList<Jobs> selectUnApprovedJobs();
	
	

}
