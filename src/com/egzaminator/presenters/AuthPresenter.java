package com.egzaminator.presenters;

import org.springframework.beans.factory.annotation.Autowired;

import com.egzaminator.EgzaminatorUI;
import com.egzaminator.components.AppView;
import com.egzaminator.components.HeaderView;
import com.egzaminator.dao.UserDAO;

public class AuthPresenter {

	
	@Autowired
	HeaderView view;
	
	@Autowired
	UserDAO userdao;
	
	
	
}
