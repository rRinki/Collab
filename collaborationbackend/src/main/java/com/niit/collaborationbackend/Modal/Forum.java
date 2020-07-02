package com.niit.collaborationbackend.Modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forum {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int forum_Id;
	
	@Column(nullable=false)
	String forum_Title;

	public int getForum_Id() {
		return forum_Id;
	}

	public void setForum_Id(int forum_Id) {
		this.forum_Id = forum_Id;
	}

	public String getForum_Title() {
		return forum_Title;
	}

	public void setForum_Title(String forum_Title) {
		this.forum_Title = forum_Title;
	}
	
	
}
