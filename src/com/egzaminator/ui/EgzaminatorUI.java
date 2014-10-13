package com.egzaminator.ui;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.egzaminator.entities.Info;
import com.egzaminator.presenters.AuthPresenter;
import com.egzaminator.utils.MVPDiscoveryNavigator;
import com.egzaminator.views.AppViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
@SuppressWarnings("serial")
@Theme("egzaminator")
public class EgzaminatorUI extends UI {
	
	
	public enum Views {
		
		MAINVIEW("MAIN"), TESTVIEW("TEST");

		String name;
		
		Views(String name) {
			
			this.name = name;
		}
		
		public String getName() {
			
			return name;
		}
	}

	public static class Servlet extends VaadinServlet {	
	}
	
	//@Autowired
	//private AppViewImpl appview;

	@Override
	protected void init(VaadinRequest request) {
		
		MVPDiscoveryNavigator navigator = new MVPDiscoveryNavigator(this, this);
		
		//Set me to UI so that I can be used even from other views.
		this.setNavigator(navigator);
		
		// Add the views and presenters to the MVPDiscoveryNavigator
		navigator.addBeanViewPresenter(Views.MAINVIEW.getName(), AppViewImpl.class, AuthPresenter.class, false);
		
		//Navigate to the desired View. The presenter also will be tied up with the view
		navigator.navigateTo(Views.MAINVIEW.getName());
	}
	
	// GETTERS / SETTERS


}