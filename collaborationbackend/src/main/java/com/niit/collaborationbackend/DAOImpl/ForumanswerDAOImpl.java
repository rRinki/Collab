package com.niit.collaborationbackend.DAOImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.DAO.IForumanswerDAO;
import com.niit.collaborationbackend.Modal.Blog;
import com.niit.collaborationbackend.Modal.Forum;
import com.niit.collaborationbackend.Modal.Forumanswer;


@Repository("forumanswerdao")
@Transactional
public class ForumanswerDAOImpl implements IForumanswerDAO {
	
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addAnswer(Forumanswer fanswer) {
		try {
			sessionfactory.getCurrentSession().save(fanswer);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteAnswer(Forumanswer fanswer) {
		try {
			sessionfactory.getCurrentSession().delete(fanswer);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public boolean updateAnswer(Forumanswer fanswer) {
		try {
			sessionfactory.getCurrentSession().update(fanswer);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public ArrayList<Forumanswer> selectAllanswer(Forum forum) {
		try {
			return (ArrayList<Forumanswer>) sessionfactory.getCurrentSession().createCriteria(Forumanswer.class)
					.add(Restrictions.eq("forum_Status",true)).list();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
			
		}
	}

	@Override
	public Forumanswer selectOneanswer(int forumanswers_Id) {
		try {
			
		return (Forumanswer)sessionfactory.getCurrentSession().createCriteria(Forumanswer.class)
				.add(Restrictions.eq("forumanswers_Id",forumanswers_Id)).uniqueResult();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		return null;
	}
	}

	@Override
	public ArrayList<Forumanswer> selectAllapprovedanswers() {
		try
	     {
			
	     return (ArrayList<Forumanswer>) sessionfactory.getCurrentSession().createCriteria (Forumanswer.class).
	    		  add(Restrictions.eq("forum_Status",true)).list();
	     }
		catch(Exception e) {
			System.out.println(e.getMessage());
	      return null;
	     }
	}
@Override
	public ArrayList<Forumanswer> selectUnapprovedanswer() {
		try
	     {
	     return (ArrayList<Forumanswer>) sessionfactory.getCurrentSession().createCriteria (Forumanswer.class).
	    		  add(Restrictions.eq("forum_Status",false)).list();
	     }
		catch(Exception e) {
	      System.out.println(e.getMessage());
	      return null;
	     }
	}
	}


