package com.niit.collaborationbackend.Modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Appliedjobs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int appliedjob_Id;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Jobs jobs;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Customer customer;
	
	@Column(nullable=false,columnDefinition ="date default sysdate()" )
	@Temporal(TemporalType.DATE)
	Date applied_Date;

	public Date getApplied_Date() {
		return applied_Date;
	}

	public void setApplied_Date(Date applied_Date) {
		this.applied_Date = applied_Date;
	}

	public int getAppliedjob_Id() {
		return appliedjob_Id;
	}

	public void setAppliedjob_Id(int appliedjob_Id) {
		this.appliedjob_Id = appliedjob_Id;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
