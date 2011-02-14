package com.kiouri.sliderbar.client.demo.gmap;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.solution.gmap.SliderBarGMap;

public class SliderBarGMapDemo extends AbsolutePanel{

	ImagesGMap images = GWT.create(ImagesGMap.class);
	SliderBarGMap sliderBarGMap;
	
	public SliderBarGMapDemo(boolean selected, int value) {
		sliderBarGMap = new SliderBarGMap(10,"240px",selected);
		this.setPixelSize(108, 260);
		Image mapImage = new Image(images.map());
		mapImage.addMouseDownHandler(new MouseDownHandler(){
			public void onMouseDown(MouseDownEvent event) {
				event.preventDefault();
			}			
		});		
		this.add(mapImage, 0, 0);
		this.add(sliderBarGMap, 40, 10);
		sliderBarGMap.setValue(value);				
	}
	
	interface ImagesGMap extends ClientBundle{
		@Source("map.png")
		ImageResource map();
	}
	
}
