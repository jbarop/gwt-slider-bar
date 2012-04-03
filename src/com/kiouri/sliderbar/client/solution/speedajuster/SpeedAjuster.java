package com.kiouri.sliderbar.client.solution.speedajuster;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.view.SliderBarHorizontal;

public class SpeedAjuster extends SliderBarHorizontal {

	ImagesSpeedAjuster images = GWT.create(ImagesSpeedAjuster.class);
	
	public SpeedAjuster(){
		this.setLessWidget(new Image(images.less()));
		this.setScaleWidget(new Image(images.scale().getUrl()), 20);
		this.setMoreWidget(new Image(images.more()));		
		this.setDragWidget(new Image(images.drag()));
		this.setMaxValue(6);
		this.setWidth("148px");
	}

	interface ImagesSpeedAjuster extends ClientBundle {
		
		@Source("snail.png")
		ImageResource less();
		
		@Source("runner.png")
		ImageResource more();
		
		@Source("drag.png")
		ImageResource drag();
		
		@Source("scale.png")
		DataResource scale();
		
	}	
	

}
