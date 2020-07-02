package com.niit.collaborationbackend.DAO;

import java.util.ArrayList;


import com.niit.collaborationbackend.Modal.Forum;

public interface IForumDAO {
	
	boolean addForum(Forum forum);
	boolean updateForum(Forum forum);
	boolean deleteForum(Forum forum);
	ArrayList<Forum> selectallForum();
	Forum selectOneForum(int forum_Id);

}
