package com.kiouri.sliderbar.client.solution.adv;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.kiouri.sliderbar.client.view.SliderBarHorizontal;

public class AdvancedSliderBar extends SliderBarHorizontal {
	
	ImagesAdvancedSliderBar images = GWT.create(ImagesAdvancedSliderBar.class);
	
	public AdvancedSliderBar(){
		Widget drag = new MAdvancedPanel();
		drag.setPixelSize(10, 10);
		
		Widget less = new MAdvancedTextPanel(new Image(images.lessNotSelected()), new Image(images.lessSelected()));
		
		Widget more = new MAdvancedTextPanel(new Image(images.moreNotSelected()), new Image(images.moreSelected()));
		
		this.setLessWidget(less);
		this.setScaleWidget(new Image(images.scale().getUrl()), 4);
		this.setMoreWidget(more);		
		this.setDragWidget(drag);
		this.setMaxValue(4);
		this.setWidth("148px");		
	}
	
	interface ImagesAdvancedSliderBar extends ClientBundle {
		@Source("scale.png")
		DataResource scale();
		@Source("plusblack.png")
		ImageResource moreNotSelected();
		@Source("plusblue.png")
		ImageResource moreSelected();
		
		@Source("minusblack.png")
		ImageResource lessNotSelected();
		@Source("minusblue.png")
		ImageResource lessSelected();

		
	}	


}
