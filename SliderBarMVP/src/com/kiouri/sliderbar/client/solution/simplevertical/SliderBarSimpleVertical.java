package com.kiouri.sliderbar.client.solution.simplevertical;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.view.SliderBarVertical;

public class SliderBarSimpleVertical extends SliderBarVertical {
	
	ImagesSliderBarSimpleVertical images = GWT.create(ImagesSliderBarSimpleVertical.class);

	public SliderBarSimpleVertical(int maxValue, String height, boolean showRows) {		
		if (showRows){
			setLessWidget(new Image(images.less()) );
			setScaleWidget(new Image(images.scalev().getUrl()), 10);
			setMoreWidget(new Image(images.more()));
		} else {
		    setScaleWidget(new Image(images.scalev().getUrl()), 10);
		}
		setDragWidget(new Image(images.drag()));
		this.setHeight(height);
		this.setMaxValue(maxValue);		
	}

	interface ImagesSliderBarSimpleVertical extends ClientBundle{
		
		@Source("dragvthin.png")
		ImageResource drag();

		@Source("minus.png")
		ImageResource less();

		@Source("plus.png")
		ImageResource more();

		@Source("scalevthinblack.png")
		DataResource scalev();				
	}
	
}
