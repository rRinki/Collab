package com.niit.collaborationbackend.DAO;


import java.util.List;

import com.niit.collaborationbackend.Modal.Customer;

public interface ICustomerDAO {
	
	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	public Customer selectCustomer(String cust_email);
	public List<Customer> selectAllCustomer();
	public Customer checkUser(Customer customer);
	
}
