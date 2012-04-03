package com.kiouri.sliderbar.client.solution.simplehorizontal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.view.SliderBarHorizontal;

public class SliderBarSimpleHorizontal extends SliderBarHorizontal{
	
	ImagesSliderBarSimpleHorizontal images = GWT.create(ImagesSliderBarSimpleHorizontal.class);

	public SliderBarSimpleHorizontal(int maxValue, String width, boolean showRows) {
		if (showRows){
			setLessWidget(new Image(images.less()) );
			setScaleWidget(new Image(images.scaleh().getUrl()), 10);
			setMoreWidget(new Image(images.more()));
		} else {
		    setScaleWidget(new Image(images.scaleh().getUrl()), 10);
		}
		setDragWidget(new Image(images.drag()));
		this.setWidth(width);
		this.setMaxValue(maxValue);
	}

	interface ImagesSliderBarSimpleHorizontal extends ClientBundle{
		
		@Source("draghthin.png")
		ImageResource drag();

		@Source("minush.png")
		ImageResource less();

		@Source("plush.png")
		ImageResource more();

		@Source("scalehthinblack.png")
		DataResource scaleh();		
	}	
		
}

