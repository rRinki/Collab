package com.niit.collaborationbackend.DAO;

import java.util.ArrayList;

import com.niit.collaborationbackend.Modal.Forum;
import com.niit.collaborationbackend.Modal.Forumanswer;

public interface IForumanswerDAO {

		boolean addAnswer(Forumanswer fanswer);
		boolean deleteAnswer(Forumanswer fanswer);
		boolean updateAnswer(Forumanswer fanswer);
		ArrayList<Forumanswer> selectAllanswer(Forum forum);
		Forumanswer selectOneanswer(int forumanswers_Id);
		ArrayList<Forumanswer> selectAllapprovedanswers();
		ArrayList<Forumanswer> selectUnapprovedanswer();
}

