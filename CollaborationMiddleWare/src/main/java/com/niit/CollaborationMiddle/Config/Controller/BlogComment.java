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

import com.niit.collaborationbackend.DAO.BlogCommentDAO;
import com.niit.collaborationbackend.DAO.IBlogDAO;
import com.niit.collaborationbackend.Modal.BLogComment;
import com.niit.collaborationbackend.Modal.Blog;
import com.niit.collaborationbackend.Modal.Customer;

@RestController
@RequestMapping("/blogcomment")
public class BlogComment {
	@Autowired
	BlogCommentDAO blogcommentdao;

	@Autowired
	IBlogDAO blogdao;

	@PostMapping("/addblogcomment")
	ResponseEntity<Void> addMyBlogcomment(@RequestParam("blogid") int blogid, @RequestBody BLogComment blogcomment,
			HttpSession session) {
		Blog blog = blogdao.selectOneBlog(blogid);
		Customer cust = (Customer) session.getAttribute("custdetails");
		blogcomment.setCustomer(cust);
		blogcomment.setDate(new Date());
		blogcomment.setBlog(blog);
		if (blogcommentdao.addBlogComment(blogcomment)) {
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PutMapping("/updateblogcomment")
	ResponseEntity<Void> updateBlogcomment(@RequestParam("comment_Id") int comment_Id,
			@RequestBody BLogComment blogcomment) {
		BLogComment newblogcomment = blogcommentdao.selectOneComment(comment_Id);
		System.out.println(newblogcomment.getBlog());
		newblogcomment.setComment(blogcomment.getComment());
		newblogcomment.setDate(new Date());
		if (blogcommentdao.updateBlogComment(newblogcomment)) {
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/allblogcomments")
	ResponseEntity<List<BLogComment>> selectallcomments(@RequestParam("blogid")int blogid) {
		
	Blog blog = blogdao.selectOneBlog(blogid);
		ArrayList<BLogComment> blogcommentlist = blogcommentdao.selectallcomments(blog);

		if (blogcommentlist.isEmpty()) {
			System.out.println("if block");
			return new ResponseEntity<List<BLogComment>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<BLogComment>>(blogcommentlist, HttpStatus.FOUND);
		}
	}

	@GetMapping("/selectoneblogcomment")
	ResponseEntity<BLogComment> selectOneBlogcomment(@RequestParam("comment_Id") int comment_Id) {
		BLogComment blogcomment = blogcommentdao.selectOneComment(comment_Id);
		if (blogcomment == null) {
		return new ResponseEntity<BLogComment>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<BLogComment>(blogcomment, HttpStatus.FOUND);
	}
	}
	@DeleteMapping("/deleteblogcomment")
	ResponseEntity<Void> deleteBlogcomment(@RequestParam("comment_Id")int comment_Id)
	{
		BLogComment blogcomment = blogcommentdao.selectOneComment(comment_Id);
		if(blogcommentdao.deleteBlogComment(blogcomment))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	}
	


