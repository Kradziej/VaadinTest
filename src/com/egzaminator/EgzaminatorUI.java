package com.egzaminator;

import javax.servlet.annotation.WebServlet;

import org.hibernate.Session;

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

@SuppressWarnings("serial")
@Theme("egzaminator")
public class EgzaminatorUI extends UI {

	@WebServlet(value = "/*")
	@VaadinServletConfiguration(productionMode = false, ui = EgzaminatorUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	     session.beginTransaction();
	     User user = new User();
	     user.setInfo("costam");
	     session.save(user);
	     
	     session.getTransaction().commit();
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

}