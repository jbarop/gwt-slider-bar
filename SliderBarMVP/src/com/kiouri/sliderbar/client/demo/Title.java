package com.kiouri.sliderbar.client.demo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class Title extends AbsolutePanel {
	
	ImagesTitle images = GWT.create(ImagesTitle.class);
	HDelimeter line1 = new HDelimeter();
	HDelimeter line2 = new HDelimeter();
	HDelimeter line3 = new HDelimeter();
	Label gwtSliderbarLabel = new Label("GWT SliderBar");
	Anchor wikiMainPageRef  = new Anchor("Getting started", false, "http://code.google.com/p/img-slider-bar/");
	Anchor downloadPageRef  = new Anchor("Download", false, "http://code.google.com/p/img-slider-bar/downloads/list");
	Anchor sourcePageRef    = new Anchor("Source", false, "http://code.google.com/p/gwt-slider-bar/source/checkout");
	
	
	
	public Title(){
		this.setWidth("100%");
		this.setHeight("210px");
		this.add(new Image(images.emailmirror()), 0, 20);
		gwtSliderbarLabel.addStyleName("gwtsliderbarlabel");
		this.add(line1, 0, 73);
		this.add(wikiMainPageRef, 0, 78);
		this.add(downloadPageRef, 125, 78);
		this.add(sourcePageRef, 220, 78);
		this.add(line2, 0, 103);
		this.add(line3, 120, 180);
		this.add(gwtSliderbarLabel, 120,120);
		
	}
	
	interface ImagesTitle extends ClientBundle {
		@Source("kiourititle.png")
		ImageResource emailmirror();
	}	

}
