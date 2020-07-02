package com.niit.CollaborationMiddle.Config.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.DAO.ICustomerDAO;
import com.niit.collaborationbackend.Modal.Customer;

@RestController
@RequestMapping("/customer")
public class EmployerController {
	@Autowired
	ICustomerDAO customerdao;
	@GetMapping
	 ResponseEntity<List<Customer>> selectAllCustomer()
	{
		ArrayList<Customer> custlist=(ArrayList<Customer>)customerdao.selectAllCustomer();
		if(custlist.isEmpty())
		{
			return new ResponseEntity<List<Customer>>(custlist,HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<List<Customer>>(custlist,HttpStatus.FOUND);
		}
	}


	@PostMapping
	ResponseEntity<Void>addCustomer(@RequestBody Customer customer)
	{
		if(customerdao.addCustomer(customer))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/{fetchone}")
	ResponseEntity<Customer>selectOneCustomer(@RequestParam("emailid")String emailid)
	{
		
		System.out.println(emailid);
		Customer cust=customerdao.selectCustomer(emailid);
		if(cust==null)
		{
			System.out.println("Customer Not Found");
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
			
		}
		else
		{
			System.out.println("Customer Found");
			return new ResponseEntity<Customer>(cust,HttpStatus.FOUND);
		}
	}
	}