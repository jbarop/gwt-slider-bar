package com.kiouri.sliderbar.client.demo;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;

public class BottomPanel extends AbsolutePanel{
	
	Label bottomLabel = new Label("SliderBar demo application");
	
	public BottomPanel(){
		this.setWidth("100%");
		this.setHeight("50px");
		this.add(new HDelimeter(), 0,0);
		this.add(bottomLabel, 400, 10);
		bottomLabel.addStyleName("demobottompanel");
	}

	
}
