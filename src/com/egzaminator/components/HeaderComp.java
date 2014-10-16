package com.egzaminator.components;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.egzaminator.views.AppView.AppViewListener;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.server.VaadinServletService;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;


public class HeaderComp extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private HorizontalLayout mainLayout;

	// login form
	@AutoGenerated
	private Button loginButton;
	private AbsoluteLayout loginFormWrapper;
	private FormLayout loginForm;
	private PropertysetItem data;
	private FieldGroup loginData;
	private Window loginWindow;
	
	private AppViewListener listener;

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public HeaderComp() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		buildLoginForm();
	}
	
	private void buildLoginForm() {

		// Build form
		data = new PropertysetItem();
		data.addItemProperty("name", new ObjectProperty<String>(""));
		data.addItemProperty("pass", new ObjectProperty<String>(""));
		
		loginForm = new FormLayout();
		
		TextField nameField = new TextField("Login");
		loginForm.addComponent(nameField);
		TextField subnameField = new TextField("Has�o");
		loginForm.addComponent(subnameField);
		Button loginSubmitButton = new Button("Zaloguj");
		loginForm.addComponent(loginSubmitButton);
		
		loginData = new FieldGroup(data);
		loginData.bind(nameField, "name");
		loginData.bind(subnameField, "pass");
		
		// Add form to wrapper
		loginFormWrapper = new AbsoluteLayout();
		loginFormWrapper.addComponent(loginForm);
		loginWindow = new Window();
		loginWindow.setWidth("300px");
		loginWindow.setHeight("200px");
		loginWindow.setContent(loginFormWrapper);

		
		// Listeners
		
		
		loginSubmitButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				String name = (String) loginData.getField("name").getValue();
				String password = (String) loginData.getField("pass").getValue();
				ArrayList<GrantedAuthority> granted = new ArrayList<GrantedAuthority>();
				granted.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(name, password, granted);
				auth.setDetails(new WebAuthenticationDetails( VaadinServletService.getCurrentServletRequest() ));
				listener.buttonClick("login", auth);
			}
		});
		
		
		loginButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
			
				if(!loginWindow.isAttached()) {
					
					loginWindow.setPositionY(event.getClientY() - event.getRelativeY() + 45 );
					loginWindow.setPositionX(event.getClientX() - event.getRelativeX() + 25 );
					UI.getCurrent().addWindow(loginWindow);
					loginWindow.focus();
				} else {
					
					loginWindow.close();
				}
			}
		});
		
	}
	

	@AutoGenerated
	private HorizontalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new HorizontalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
	
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// loginButton
		loginButton = new Button();
		loginButton.setCaption("Zaloguj si�");
		loginButton.setImmediate(false);
		loginButton.setWidth("-1px");
		loginButton.setHeight("-1px");
		mainLayout.addComponent(loginButton);
		mainLayout.setComponentAlignment(loginButton, new Alignment(6));
		
		return mainLayout;
	}
	
	public void setListener(AppViewListener listener) {
		
		this.listener = listener;
	}

}
