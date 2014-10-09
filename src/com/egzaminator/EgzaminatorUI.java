package com.egzaminator;

import javax.servlet.annotation.WebServlet;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.egzaminator.components.HeadComp;
import com.egzaminator.components.NavComp;
import com.egzaminator.dao.InfoDAOImpl;
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

	//@WebServlet(value = "/*")
	//@VaadinServletConfiguration(productionMode = false, ui = EgzaminatorUI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	@Autowired
	private InfoDAOImpl infoDao;
	private NavComp nav;
	
	@Autowired
	private HeadComp head;

	@Override
	protected void init(VaadinRequest request) {
		
		infoDao.test();
		// VerticalLayout has v-verticallayout style
		//AbsoluteLayout content = new AbsoluteLayout();
		setContent(head);
		
		/*
		 * GridLayout content = new GridLayout(2, 4);
        setContent(content);
        content.setSizeFull();
        
        NavComp navComp = new NavComp();
        content.addComponent(navComp, 1, 1);
        //navPanel.setSizeFull();
        //navPanel.setWidth("900px");
        //navPanel.setHeight("300px");
        
        VerticalLayout leftPanel = new VerticalLayout();
        content.addComponent(leftPanel, 0, 1, 0, 2);
        leftPanel.setWidth("100px");
        //leftPanel.setHeight("100%");
        Button b = new Button("TESTESTE");
        leftPanel.addComponent(b);
        
        content.setColumnExpandRatio(0, 1.0f);
        content.setColumnExpandRatio(1, 10.0f);
        
        // Add more
        //content.addComponent(new NavComp());
        //NavComp navComp = new NavComp();
        //navPanel.addComponent(navComp);
        
        */
	}
	
	
	// GETTERS / SETTERS

	public InfoDAOImpl getUserdao() {
		return infoDao;
	}

	public void setUserdao(InfoDAOImpl userdao) {
		this.infoDao = userdao;
	}


	public HeadComp getHead() {
		return head;
	}


	public void setHead(HeadComp head) {
		this.head = head;
	}

}