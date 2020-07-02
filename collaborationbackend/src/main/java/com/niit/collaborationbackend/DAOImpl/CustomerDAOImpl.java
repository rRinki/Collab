package com.niit.collaborationbackend.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.DAO.ICustomerDAO;
import com.niit.collaborationbackend.Modal.CustCred;
import com.niit.collaborationbackend.Modal.Customer;



@Repository("customerdao")
@Transactional
public class CustomerDAOImpl implements ICustomerDAO {
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addCustomer(Customer customer) {

		try {
			sessionfactory.getCurrentSession().save(customer);
			CustCred cred = new CustCred();
			cred.setCus_Email(customer.getCus_Email());
			cred.setCust_Password(customer.getCust_Password());
			cred.setCust_Role(customer.getCust_Role());
			sessionfactory.getCurrentSession().save(cred);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {

			sessionfactory.getCurrentSession().update(customer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Customer selectCustomer(String cust_email) {
		try {
			Customer customer = (Customer) sessionfactory.getCurrentSession().createCriteria(Customer.class)
					.add(Restrictions.eq("cus_Email", cust_email)).uniqueResult();
			System.out.println("Select one customer");
			return customer;
		} catch (Exception e) {
			
			return null;
		}
	}
	@Override
	public List<Customer> selectAllCustomer() {
		try {
			ArrayList<Customer> customer = (ArrayList<Customer>) sessionfactory.getCurrentSession().createCriteria(Customer.class)
					.list();
			//System.out.println("Select all Customer");
			return customer;
		} catch (Exception e) {
			return null;
		}
	}

	
	@Override
	public Customer checkUser(Customer customer) {
		CustCred cred = (CustCred) sessionfactory.getCurrentSession().createCriteria(CustCred.class)
				.add(Restrictions.eq("cus_Email", customer.getCus_Email())).uniqueResult();
		 if (cred.getCust_Password().equals(customer.getCust_Password())) {
		Customer cust=selectCustomer(customer.getCus_Email());
			 cust.setCust_Role(cred.getCust_Role());
			 return cust;
		 }
			else
				
			{
				return null;
			}
	}
}
