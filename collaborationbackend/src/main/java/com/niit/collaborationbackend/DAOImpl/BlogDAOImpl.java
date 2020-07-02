package com.niit.collaborationbackend.DAOImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.DAO.IBlogDAO;
import com.niit.collaborationbackend.Modal.Blog;
import com.niit.collaborationbackend.Modal.Customer;


@Repository("blogdao")
@Transactional
public class BlogDAOImpl implements IBlogDAO {
	
	
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addBlog(Blog b) {
		try {
			sessionfactory.getCurrentSession().save(b);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBlog(Blog b) {
		try {
			sessionfactory.getCurrentSession().update(b);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	@Override
	public boolean deleteBlog(Blog b) {
		try {
			sessionfactory.getCurrentSession().delete(b);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public ArrayList<Blog> selectallApprovedBlogs() {
		
		try
	     {
			
	     return (ArrayList<Blog>) sessionfactory.getCurrentSession().createCriteria (Blog.class).
	    		  add(Restrictions.eq("blog_Status",true)).list();
	     }
		catch(Exception e) {
			System.out.println(e.getMessage());
	      return null;
	     }
		
	
	}

	@Override
	public ArrayList<Blog> selectallBlogsOfOneUser(Customer customer) {
		try
	     {
	     return (ArrayList<Blog>) sessionfactory.getCurrentSession().createCriteria (Blog.class).
	    		  add(Restrictions.eq("customer",customer)).list();
	     }
		catch(Exception e) {
	      System.out.println(e.getMessage());
	      return null;
	     }
	}

	@Override
	public ArrayList<Blog> selectUnApprovedBlogs() {
		try
	     {
	     return (ArrayList<Blog>) sessionfactory.getCurrentSession().createCriteria (Blog.class).
	    		  add(Restrictions.eq("blog_Status",false)).list();
	     }
		catch(Exception e) {
	      System.out.println(e.getMessage());
	      return null;
	     }
	}
	
	@Override
	public Blog selectOneBlog(int blog_Id) {
		try {
				return (Blog) sessionfactory.getCurrentSession().createCriteria(Blog.class).
						add(Restrictions.eq("blog_Id", blog_Id)).uniqueResult();
		}
		catch (Exception e)
		{
			return null;
		}
}
}
