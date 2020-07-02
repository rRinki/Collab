package com.niit.CollaborationMiddle.Config.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.DAO.IJobsDAO;
import com.niit.collaborationbackend.Modal.Customer;
import com.niit.collaborationbackend.Modal.Jobs;

@RestController
@RequestMapping("/jobs")
public class JobsController {
	
	@Autowired
	IJobsDAO jobsdao;
	
	@GetMapping("/adminapproval")
	ResponseEntity<List<Jobs>> selectallUnApprovedjobs(HttpSession session) 
	{
		ArrayList<Jobs> joblist = jobsdao.selectUnApprovedJobs();
		if (joblist.isEmpty()) {
			return new ResponseEntity<List<Jobs>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Jobs>>(joblist, HttpStatus.FOUND);
		}

	}
	@PostMapping("/addjobs")
	ResponseEntity<Void> addJob(@RequestBody Jobs jobs,HttpSession session)
	{
		Customer cust=(Customer)session.getAttribute("custdetails");
		jobs.setCustomer(cust);
		jobs.setPosted_Date(new Date());
		
		
		if(jobsdao.addJobs(jobs))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@GetMapping("/alljobs")
    ResponseEntity<List<Jobs>> selectallApprovedJobs()
	{
  	  ArrayList<Jobs> joblist = jobsdao.selectallJobs();
  	  
		if(joblist.isEmpty())
		{
			
			return new ResponseEntity<List<Jobs>>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<List<Jobs>>(joblist,HttpStatus.FOUND);
		}	
	}
	@GetMapping("/updatestatus")
	ResponseEntity<Void> addMyJob(@RequestParam("job_Id")int id)
	{
		
		Jobs jobs = jobsdao.selectOneJob(id);
		jobs.setJob_Status(true);
		if(jobsdao.updateJobs(jobs))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@GetMapping("/myjobs")
	ResponseEntity<List<Jobs>> selectMyjobs(HttpSession session)
	{
	
	Customer cust = (Customer)session.getAttribute("custdetails");
	ArrayList<Jobs> joblist= jobsdao.selectJobsofOneuser(cust);
	
	if(joblist.isEmpty())
	{
		return new ResponseEntity<List<Jobs>>(HttpStatus.NOT_FOUND);
	}
	else
	{
		return new ResponseEntity<List<Jobs>>(joblist,HttpStatus.FOUND);
	}	
}
	@GetMapping("/selectonejob")
	ResponseEntity<Jobs> selectOneBlogs(@RequestParam("job_Id")int id)
	{
		
		Jobs jobs = jobsdao.selectOneJob(id);
		if(jobs==null)
		{
			return new ResponseEntity<Jobs>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<Jobs>(jobs,HttpStatus.FOUND);
		}	
	}
	@PutMapping("/updatejobs")
	ResponseEntity<Void> updateMyjob(@RequestParam("job_Id")int id,@RequestBody Jobs jobs)
	{
		Jobs newjob = jobsdao.selectOneJob(id);
		newjob.setJob_Description(jobs.getJob_Description());
		newjob.setJob_Salary(jobs.getJob_Salary());
		newjob.setJob_Status(false);
		newjob.setJob_Titile(jobs.getJob_Titile());
		newjob.setSkill_Set(jobs.getSkill_Set());
		newjob.setPosted_Date(new Date());
		newjob.setLast_Date(jobs.getLast_Date());
		newjob.setNo_vaccany(jobs.getNo_vaccany());
		
		if(jobsdao.updateJobs(newjob))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@DeleteMapping("/deletejob")
	ResponseEntity<Void> deleteMyjob(@RequestParam("job_Id")int id)
	{
		Jobs newjob = jobsdao.selectOneJob(id);
		if(jobsdao.deleteJobs(newjob))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
