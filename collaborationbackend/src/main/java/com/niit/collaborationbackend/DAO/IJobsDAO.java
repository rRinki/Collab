package com.niit.collaborationbackend.DAO;

import java.util.ArrayList;

import com.niit.collaborationbackend.Modal.Customer;
import com.niit.collaborationbackend.Modal.Jobs;


public interface IJobsDAO {
	
	boolean addJobs(Jobs jobs);
	boolean updateJobs(Jobs jobs);
	boolean deleteJobs(Jobs jobs);
	ArrayList<Jobs> selectallJobs();
	ArrayList<Jobs> selectJobsofOneuser(Customer customer);
	ArrayList<Jobs> selectUnApprovedJobs();
	Jobs selectOneJob(int job_Id);
	
}
