package com.niit.collaborationbackend.DAOImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.DAO.IJobsDAO;
import com.niit.collaborationbackend.Modal.Customer;
import com.niit.collaborationbackend.Modal.Jobs;


@Repository("jobsdao")
@Transactional 
public class JobsDAOImpl implements IJobsDAO {
	
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addJobs(Jobs jobs) {
		try {
			sessionfactory.getCurrentSession().save(jobs);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		}

	@Override
	public boolean updateJobs(Jobs jobs) {
		try {
			sessionfactory.getCurrentSession().update(jobs);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		}
	@Override
	public boolean deleteJobs(Jobs jobs) {
		try {
			sessionfactory.getCurrentSession().delete(jobs);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		}
	@Override
	public ArrayList<Jobs> selectUnApprovedJobs() {
		try
	     {
	     return (ArrayList<Jobs>) sessionfactory.getCurrentSession().createCriteria (Jobs.class).
	    		  add(Restrictions.eq("job_Status",false)).list();
	     }
		catch(Exception e) {
	      System.out.println(e.getMessage());
	      return null;
	     }
	}
	@Override
	public ArrayList<Jobs> selectJobsofOneuser(Customer customer) {
		try
	     {
	     return (ArrayList<Jobs>) sessionfactory.getCurrentSession().createCriteria (Jobs.class).
	    		  add(Restrictions.eq("customer",customer)).list();
	     }
		catch(Exception e) {
	      System.out.println(e.getMessage());
	      return null;
	     }
	}
	@Override
	public ArrayList<Jobs> selectallJobs() {
		try {
			return (ArrayList<Jobs>) sessionfactory.getCurrentSession().createCriteria(Jobs.class).
					add(Restrictions.eq("job_Status", true)).list();
		}
		catch(Exception e) {
			return null;
		}
					
		}
	@Override
	public Jobs selectOneJob(int job_Id) {
		try {
			return (Jobs) sessionfactory.getCurrentSession().createCriteria(Jobs.class).
					add(Restrictions.eq("job_Id", job_Id)).uniqueResult();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}

}
}
