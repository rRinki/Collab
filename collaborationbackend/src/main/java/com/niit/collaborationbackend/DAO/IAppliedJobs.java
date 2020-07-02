package com.niit.collaborationbackend.DAO;

import java.util.ArrayList;

import com.niit.collaborationbackend.Modal.Appliedjobs;
import com.niit.collaborationbackend.Modal.Customer;
import com.niit.collaborationbackend.Modal.Jobs;

public interface IAppliedJobs {

	boolean addAppliedJobs(Appliedjobs Ajobs);
	ArrayList<Appliedjobs> allAppliedjobs(Jobs jobs);
	ArrayList<Appliedjobs> myAppliedjobs(Customer customer);
	ArrayList<Appliedjobs> selectOneAppliedjobs(int appliedjob_Id);
	
	
}
