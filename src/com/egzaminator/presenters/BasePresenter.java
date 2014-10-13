package com.egzaminator.presenters;

import com.egzaminator.views.BaseView;
import com.egzaminator.views.BaseViewListener;

public class BasePresenter implements BaseViewListener {

	protected BaseView view;

	
	public void setView(BaseView view) {
		this.view = view;
		view.addListener(this);
	}
	
}
