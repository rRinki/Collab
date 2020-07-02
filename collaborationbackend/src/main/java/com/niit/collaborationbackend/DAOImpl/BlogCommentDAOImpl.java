package com.niit.collaborationbackend.DAOImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.DAO.BlogCommentDAO;
import com.niit.collaborationbackend.Modal.BLogComment;
import com.niit.collaborationbackend.Modal.Blog;


@Repository("blogcommentdao")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO {
	
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addBlogComment(BLogComment bc) {
		try {
			sessionfactory.getCurrentSession().save(bc);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean updateBlogComment(BLogComment bc) {
		
			try {
				sessionfactory.getCurrentSession().update(bc);
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		}

	@Override
	public boolean deleteBlogComment(BLogComment bc) {
		
			try {
				sessionfactory.getCurrentSession().delete(bc);
				return true;
			} catch (Exception e) {
				return false;
			}
		}

	@Override
	public ArrayList<BLogComment> selectallcomments(Blog  blog) {
		try
	     {
	     return (ArrayList<BLogComment>) sessionfactory.getCurrentSession().createCriteria (BLogComment.class).
	    		  add(Restrictions.eq("blog",blog)).list();
	     }
		catch(Exception e) {
	      
	      return null;
	     }
	}

	@Override
	public BLogComment selectOneComment(int comment_Id) {
		try
	     {
	     return (BLogComment)sessionfactory.getCurrentSession().createCriteria (BLogComment.class).
	    		  add(Restrictions.eq("comment_Id",comment_Id)).uniqueResult();
	     }
		catch(Exception e) {
			 System.out.println(e.getMessage());
	      return null;
	     }
	}
}


