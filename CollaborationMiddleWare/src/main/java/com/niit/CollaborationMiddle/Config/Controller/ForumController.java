package com.niit.CollaborationMiddle.Config.Controller;

import java.util.ArrayList;
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
import com.niit.collaborationbackend.Modal.Blog;
import com.niit.collaborationbackend.Modal.Forum;

@RestController
@RequestMapping("/forum")
public class ForumController {
	
	@Autowired
	IForumDAO forumdao;
	
	
	@PostMapping("/addforum")
	ResponseEntity<Void> addForum(@RequestBody Forum forum,HttpSession session)
	{
		
		if(forumdao.addForum(forum))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@GetMapping("/allforum")
    ResponseEntity<List<Forum>> selectallForum()
	{
  	  ArrayList<Forum> forumlist = forumdao.selectallForum();
  	  
		if(forumlist.isEmpty())
		{
			System.out.println("if block");	
			return new ResponseEntity<List<Forum>>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<List<Forum>>(forumlist,HttpStatus.FOUND);
		}	
	}

@GetMapping("/selectoneforum")
ResponseEntity<Forum> selectOneForum(@RequestParam("forum_Id")int forumid)
{
	Forum forum=forumdao.selectOneForum(forumid);
	if(forum==null)
	{
		return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
	}
	else
	{
		return new ResponseEntity<Forum>(forum,HttpStatus.FOUND);
	}	
}

	@PutMapping("/updateforum")
	ResponseEntity<Void> updateforum(@RequestParam("forum_Id")int id,@RequestBody Forum forum)
	{
		Forum newforum=forumdao.selectOneForum(id);
		newforum.setForum_Title(forum.getForum_Title());;
		
		if(forumdao.updateForum(newforum))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@DeleteMapping("/deleteforum")
	ResponseEntity<Void> deleteForum(@RequestParam("forum_Id")int id)
	{
		Forum newforum=forumdao.selectOneForum(id);
		if(forumdao.deleteForum(newforum))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
	