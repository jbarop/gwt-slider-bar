package com.kiouri.sliderbar.client.solution.kde;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.view.SliderBarVertical;

public class KDEVerticalBottomBW extends SliderBarVertical {
	
	ImagesKDEVerticalBottomBW images = GWT.create(ImagesKDEVerticalBottomBW.class);
	
	public KDEVerticalBottomBW(int maxValue, String height){
	    setLessWidget(new Image(images.less()));
		setScaleWidget(new Image(images.scale().getUrl()), 16);
	    setMoreWidget(new Image(images.less()));
		setMoreWidget(new Image(images.more()));
		setDragWidget(new Image(images.drag()));
		this.setHeight(height);
		this.setMaxValue(maxValue);		
	}
	
	interface ImagesKDEVerticalBottomBW extends ClientBundle {
		
		@Source("kdevdrag.png")
		ImageResource drag();

		@Source("kdevless.png")
		ImageResource less();

		@Source("kdevmore.png")
		ImageResource more();

		@Source("kdevscale.png")
		DataResource scale();
		
	}	

}