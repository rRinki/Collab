package com.niit.collaborationbackend.DAO;

import java.util.ArrayList;

import com.niit.collaborationbackend.Modal.BLogComment;
import com.niit.collaborationbackend.Modal.Blog;


public interface BlogCommentDAO {
	
	boolean addBlogComment(BLogComment bc);
	boolean updateBlogComment(BLogComment  bc);
	boolean deleteBlogComment(BLogComment  bc);
	ArrayList<BLogComment> selectallcomments(Blog  blog);
	public BLogComment selectOneComment(int comment_Id);
	
}
