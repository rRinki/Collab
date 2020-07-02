package com.niit.collaborationbackend.Modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int cus_Id;
	
	@Column(nullable=false,unique=true)
	String cus_Name;
	
	@Column(nullable=false,unique=true)
	String cus_Email;
	

	@Column(nullable=false)
	String cus_Phone;
	
	@Transient
	@Column(nullable=false)
	String cust_Password;
	
	@Transient
	@Column(nullable= false)
	String cust_Role;


	public String getCust_Role() {
		return cust_Role;
	}


	public void setCust_Role(String cust_Role) {
		this.cust_Role = cust_Role;
	}


	public int getCus_Id() {
		return cus_Id;
	}


	public void setCus_Id(int cus_Id) {
		this.cus_Id = cus_Id;
	}


	public String getCus_Name() {
		return cus_Name;
	}


	public void setCus_Name(String cus_Name) {
		this.cus_Name = cus_Name;
	}


	public String getCus_Email() {
		return cus_Email;
	}


	public void setCus_Email(String cus_Email) {
		this.cus_Email = cus_Email;
	}


	public String getCus_Phone() {
		return cus_Phone;
	}


	public void setCus_Phone(String cus_Phone) {
		this.cus_Phone = cus_Phone;
	}


	public String getCust_Password() {
		return cust_Password;
	}


	public void setCust_Password(String cust_Password) {
		this.cust_Password = cust_Password;
	}

	
}

