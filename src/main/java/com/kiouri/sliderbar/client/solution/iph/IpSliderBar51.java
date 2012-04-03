package com.kiouri.sliderbar.client.solution.iph;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.view.SliderBarHorizontal;

public class IpSliderBar51 extends SliderBarHorizontal {
	
	ImagesIpSliderBar51 images = GWT.create(ImagesIpSliderBar51.class);
	
	public IpSliderBar51(String leftTxt, String rightTxt){
		IScale iScale = new IScale(leftTxt, rightTxt, 51, 27);
		iScale.setBackGroundImage(new Image(images.scale().getUrl()));
		this.setLessWidget(new Image(images.moreLess()));
		setScaleWidget(iScale, 27);
		this.setLessWidget(new Image(images.moreLess()));
		this.setDragWidget(new Image(images.drag()));
		iScale.addLeftStyleName("ip51darlabelsmall");
		iScale.addRightStyleName("ip51darlabelsmall");		
		this.setWidth("53px");
		this.setMaxValue(1);		
	}
	
	interface ImagesIpSliderBar51 extends ClientBundle {
		@Source("ifml.png")
		ImageResource moreLess();
		@Source("ionoffdrag.png")
		ImageResource drag();
		@Source("ionoffscl.png")
		DataResource scale();
	}	

}
