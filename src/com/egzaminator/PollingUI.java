package com.egzaminator;

import javax.servlet.annotation.WebServlet;

import org.springframework.stereotype.Component;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;


@Component
public class PollingUI extends UI {
	
	//@WebServlet(value = "/poll")
    @VaadinServletConfiguration(productionMode = false, ui = PollingUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        setContent(new Label("Loading data, please wait..."));
        setPollInterval(1000);
        new Thread(new Loader()).start();
    }

    class Loader implements Runnable {

        @Override
        public void run() {
            // Simulate a heavy database operation
            try {
                Thread.sleep(4500);
            } catch (InterruptedException e) {
            }

            // Wrap UI updates in access to properly deal with locking
            access(new Runnable() {
                @Override
                public void run() {
                    setContent(new Label("This is the real content"));
                    
                    // Stop polling once the update is done
                    setPollInterval(-1);
                }
            });
        }
    }
}
