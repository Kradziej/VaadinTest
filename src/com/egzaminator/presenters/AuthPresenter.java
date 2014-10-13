package com.egzaminator.presenters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.egzaminator.components.HeaderComp;
import com.egzaminator.dao.UserDAO;
import com.egzaminator.ui.EgzaminatorUI;
import com.egzaminator.views.AppView;
import com.egzaminator.views.AppViewImpl;
import com.vaadin.server.VaadinSession;

@Component
@Scope("prototype")
public class AuthPresenter extends BasePresenter implements AppView.AppViewListener {
	
	@Autowired
	UserDAO userdao;
	

	@Autowired
	@Qualifier("authManager")
	private AuthenticationManager authManager;

	// Presenter not only for auth should be 
	
	@Override
	public void buttonClick(String operation, Object obj) {
		
		if(operation.equals("login")) {
			
			Authentication authToken = (Authentication) obj;
			SecurityContextHolder.getContext().setAuthentication( authManager.authenticate(authToken) );
		}
	}


	// GETTERS / SETTERS
	
	public void setAuthManager(AuthenticationManager authManager) {
		this.authManager = authManager;
	}

}
