package com.kiouri.sliderbar.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.kiouri.sliderbar.client.demo.MainPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SliderBarMVP implements EntryPoint, ResizeHandler{

	MainPanel mainPanel = new MainPanel();

	/**
	 * This is the entry point method.
	 */ 
	public void onModuleLoad() {
		RootPanel.get().add(mainPanel, (Window.getClientWidth() - 985) / 2 ,0);
		Window.addResizeHandler(this);
	}

	public void onResize(ResizeEvent event) {
		RootPanel.get().setWidgetPosition(mainPanel, (Window.getClientWidth() - 985) / 2 ,0);		
	}
}


//Presenter presenter = new Presenter(Orientation.VERTICAL);
//YBar ybar = new YBar(10, "180px", false, presenter);
//presenter.setDislay(ybar);
//RootPanel.get().add(ybar, 50, 50);

