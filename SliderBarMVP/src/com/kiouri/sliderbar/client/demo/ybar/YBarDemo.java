package com.kiouri.sliderbar.client.demo.ybar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.solution.ybar.YBar;

public class YBarDemo extends AbsolutePanel {

	ImagesYBar images = GWT.create(ImagesYBar.class);
	YBar yBar ;	
	
	public YBarDemo(boolean selected, int value){
		yBar = new YBar(17,"187px",selected);
		this.setPixelSize(108, 260);
		Image mapImage = new Image(images.map());
		mapImage.addMouseDownHandler(new MouseDownHandler(){
			public void onMouseDown(MouseDownEvent event) {
				event.preventDefault();
			}			
		});
		this.add(mapImage, 0, 0);
		this.add(yBar, 35, 36);
		yBar.setValue(value);				
		
	}
	
	interface ImagesYBar extends ClientBundle{
		@Source("map.png")
		ImageResource map();
	}	
}
