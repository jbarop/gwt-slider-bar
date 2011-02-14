package com.kiouri.sliderbar.client.solution.sizeajuster;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.view.SliderBarHorizontal;

public class SizeAjuster extends SliderBarHorizontal{
	
	ImagesSizeAjuster images = GWT.create(ImagesSizeAjuster.class);

	public SizeAjuster(){
		this.setLessWidget(new Image(images.less()));
		this.setScaleWidget(new Image(images.scale().getUrl()), 4);
		this.setMoreWidget(new Image(images.more()));		
		this.setDragWidget(new Image(images.drag()));
		this.setMaxValue(4);
		this.setWidth("148px");
	}

	interface ImagesSizeAjuster extends ClientBundle {
		
		@Source("portraitless.png")
		ImageResource less();
		
		@Source("portraitmore.png")
		ImageResource more();
		
		@Source("drag.png")
		ImageResource drag();
		
		@Source("scale.png")
		DataResource scale();
		
	}	

	
}
