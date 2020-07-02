package com.niit.collaborationbackend.DAOImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.DAO.IAppliedJobs;
import com.niit.collaborationbackend.Modal.Appliedjobs;
import com.niit.collaborationbackend.Modal.Customer;
import com.niit.collaborationbackend.Modal.Jobs;

@Repository("appliedjobsdao")
public class AppliedJobsDAOImpl implements IAppliedJobs {
	
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addAppliedJobs(Appliedjobs Ajobs) {
		try {
			sessionfactory.getCurrentSession().save(Ajobs);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<Appliedjobs> allAppliedjobs(Jobs jobs) {
		try {
			return (ArrayList<Appliedjobs>) sessionfactory.getCurrentSession().createCriteria(Appliedjobs.class).
					add(Restrictions.eq("jobs", jobs)).list();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public ArrayList<Appliedjobs> myAppliedjobs(Customer customer) {
		try {
			return (ArrayList<Appliedjobs>) sessionfactory.getCurrentSession().createCriteria(Appliedjobs.class).
					add(Restrictions.eq("customer",customer)).list();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public ArrayList<Appliedjobs> selectOneAppliedjobs(int appliedjob_Id) {
		try {
			return (ArrayList<Appliedjobs>) sessionfactory.getCurrentSession().createCriteria(Appliedjobs.class).
					add(Restrictions.eq("appliedjob_Id", appliedjob_Id)).list();
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
