package com.kiouri.sliderbar.client.demo;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.kiouri.sliderbar.client.demo.interractive.InterractiveVertical;

public class MainPanel extends AbsolutePanel{
	
	public MainPanel(){
		this.setPixelSize(985, 880);
		this.add(new Title(), 0, 0);
		this.add(new InterractiveVertical(10,400 + "px").asWidget(), 0, 210);
		this.add(new Description(), 480, 210);
		this.add(new DemoSet(), 480, 380);		
		this.add(new BottomPanel(), 0, 840);		
	}

}
