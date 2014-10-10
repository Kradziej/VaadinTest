package com.egzaminator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.egzaminator.components.AppView;
import com.egzaminator.entities.Info;
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

	public static class Servlet extends VaadinServlet {	
	}
	
	@Autowired
	private AppView appview;

	@Override
	protected void init(VaadinRequest request) {
		
		setContent(appview);
	}
	
	// GETTERS / SETTERS

	public AppView getAppview() {
		return appview;
	}

	public void setAppview(AppView appview) {
		this.appview = appview;
	}


}