package com.egzaminator.views;

import com.vaadin.navigator.View;

public interface BaseView extends View {

	
	void addListener(BaseViewListener listener);
}
