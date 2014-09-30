package com.egzaminator;

import javax.servlet.annotation.WebServlet;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.egzaminator.dao.UserDAOImpl;
import com.egzaminator.entities.User;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Component
@SuppressWarnings("serial")
@Theme("egzaminator")
public class EgzaminatorUI extends UI {

	//@WebServlet(value = "/*")
	//@VaadinServletConfiguration(productionMode = false, ui = EgzaminatorUI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	@Autowired
	private UserDAOImpl userdao;

	@Override
	protected void init(VaadinRequest request) {
		
		userdao.test();
		 // VerticalLayout has v-verticallayout style
        VerticalLayout content = new VerticalLayout();
        setContent(content);

        // Label has v-label style
        content.addComponent(new Label("Hello World!"));
        
        // Button has v-button style
        content.addComponent(new Button("Push Me!",
            new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                Notification.show("Pushed!");
            }
        }));
	}
	
	
	// GETTERS / SETTERS

	public UserDAOImpl getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAOImpl userdao) {
		this.userdao = userdao;
	}

}