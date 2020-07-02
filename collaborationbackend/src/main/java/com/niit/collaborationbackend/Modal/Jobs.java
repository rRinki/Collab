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
public class Jobs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int job_Id;
	
	@Column(nullable=false,unique=true)
	String job_Titile;
	
	@Column(nullable=false,columnDefinition="text")
	String job_Description;
	
	@Column(nullable=false,columnDefinition="text")
	String skill_Set;
	
	@Column(nullable=false)
	int job_Salary;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(nullable=false)
	int no_vaccany;
	
	@Column(nullable=false,columnDefinition="date default sysdate()")
	@Temporal(TemporalType.DATE)
	Date posted_Date;
	
	@Column(nullable=false,columnDefinition="date default sysdate()+10") 
	@Temporal(TemporalType.DATE)
	Date last_Date;
	
	@Column(nullable=false)
	boolean job_Status;

	public int getJob_Id() {
		return job_Id;
	}

	public void setJob_Id(int job_Id) {
		this.job_Id = job_Id;
	}

	public String getJob_Titile() {
		return job_Titile;
	}

	public void setJob_Titile(String job_Titile) {
		this.job_Titile = job_Titile;
	}

	public String getJob_Description() {
		return job_Description;
	}

	public void setJob_Description(String job_Description) {
		this.job_Description = job_Description;
	}

	public String getSkill_Set() {
		return skill_Set;
	}

	public void setSkill_Set(String skill_Set) {
		this.skill_Set = skill_Set;
	}

	public int getJob_Salary() {
		return job_Salary;
	}

	public void setJob_Salary(int job_Salary) {
		this.job_Salary = job_Salary;
	}

	public int getNo_vaccany() {
		return no_vaccany;
	}

	public void setNo_vaccany(int no_vaccany) {
		this.no_vaccany = no_vaccany;
	}

	public Date getPosted_Date() {
		return posted_Date;
	}

	public void setPosted_Date(Date posted_Date) {
		this.posted_Date = posted_Date;
	}

	public Date getLast_Date() {
		return last_Date;
	}

	public void setLast_Date(Date last_Date) {
		this.last_Date = last_Date;
	}

	public boolean isJob_Status() {
		return job_Status;
	}

	public void setJob_Status(boolean job_Status) {
		this.job_Status = job_Status;
	}

	
	
}
