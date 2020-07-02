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

import com.niit.collaborationbackend.DAO.IForumDAO;
import com.niit.collaborationbackend.DAO.IForumanswerDAO;
import com.niit.collaborationbackend.Modal.Blog;
import com.niit.collaborationbackend.Modal.Customer;
import com.niit.collaborationbackend.Modal.Forum;
import com.niit.collaborationbackend.Modal.Forumanswer;

@RestController
@RequestMapping("/forumanswers")
public class ForumAnswersController {
	
	@Autowired
	IForumanswerDAO forumanswerdao;
	
	@Autowired
	IForumDAO forumdao;
	
	@GetMapping("/adminapproval")
	ResponseEntity<List<Forumanswer>> selectallUnApprovedanswers(HttpSession session) 
	{
		ArrayList<Forumanswer> fanswerlist = forumanswerdao.selectUnapprovedanswer();
		if (fanswerlist.isEmpty()) {
			System.out.println("Error in if line");
			return new ResponseEntity<List<Forumanswer>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Forumanswer>>(fanswerlist, HttpStatus.FOUND);
		}

	}
	@GetMapping("/updatestatus")
	ResponseEntity<Void> addMyForumanswer(@RequestParam("forumanswers_Id")int id)
	{
		Forumanswer forumanswer =forumanswerdao.selectOneanswer(id);
		forumanswer.setForum_Status(true);
		
		if(forumanswerdao.updateAnswer(forumanswer))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PostMapping("/addforumanswer")
	ResponseEntity<Void> addforumAnswer(@RequestParam("forum_Id") int id, @RequestBody Forumanswer forumanswer,
			HttpSession session) {
		Forum forum = forumdao.selectOneForum(id);
		Customer cust = (Customer) session.getAttribute("custdetails");
		forumanswer.setCustomer(cust);
		forumanswer.setPosted_date(new Date());
		if (forumanswerdao.addAnswer(forumanswer)) {
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@PutMapping("/updateforumanswer")
	ResponseEntity<Void> updateforumanswer(@RequestParam("forum_Id") int id,
			@RequestBody Forumanswer forumanswer,HttpSession session) {
		Customer cust = (Customer) session.getAttribute("custdetails");
		Forum forum = forumdao.selectOneForum(id);
		Forumanswer newforumanswer = forumanswerdao.selectOneanswer(id);
		newforumanswer.setForum(forum);
		newforumanswer.setForum_Status(false);
		newforumanswer.setCustomer(cust);
		newforumanswer.setForum_Answer(newforumanswer.getForum_Answer());
		newforumanswer.setPosted_date(new Date());
		
		
		if (forumanswerdao.updateAnswer(newforumanswer)) {
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/allforumanswers")
	ResponseEntity<List<Forumanswer>> selectallanswers(@RequestParam("forum_Id")int id) {
		Forum forumanswer= forumdao.selectOneForum(id);
	
		ArrayList<Forumanswer> forumanswertlist = forumanswerdao.selectAllapprovedanswers();

		if (forumanswertlist.isEmpty()) {
			
			return new ResponseEntity<List<Forumanswer>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Forumanswer>>(forumanswertlist, HttpStatus.FOUND);
		}
	}

	@GetMapping("/selectoneanswer")
	ResponseEntity<Forumanswer> selectOneanswer(@RequestParam("forumanswers_Id") int id) {
		
		Forumanswer forumanswer =forumanswerdao.selectOneanswer(id);
		if (forumanswer == null) {
		return new ResponseEntity<Forumanswer>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Forumanswer>(forumanswer, HttpStatus.FOUND);
	}
	}
	@DeleteMapping("/deleteforumanswer")
	ResponseEntity<Void> deleteanswer(@RequestParam("forumanswers_Id")int id)
	{
		
		Forumanswer forumanswer =forumanswerdao.selectOneanswer(id);
		if(forumanswerdao.deleteAnswer(forumanswer))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	

}
