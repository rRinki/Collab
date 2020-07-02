package com.niit.collaborationbackend.Modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustCred {
	
	@Id
	String cus_Email;
	
	@Column(nullable= false)
	String cust_Password;
	
	@Column(nullable= false)
	String cust_Role;
	
	
	public String getCus_Email() {
		return cus_Email;
	}
	public void setCus_Email(String cus_Email) {
		this.cus_Email = cus_Email;
	}
	public String getCust_Password() {
		return cust_Password;
	}
	public void setCust_Password(String cust_Password) {
		this.cust_Password = cust_Password;
	}
	public String getCust_Role() {
		return cust_Role;
	}
	public void setCust_Role(String cust_Role) {
		this.cust_Role = cust_Role;
	}

}
