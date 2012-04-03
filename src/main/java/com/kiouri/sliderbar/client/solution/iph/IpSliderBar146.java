package com.kiouri.sliderbar.client.solution.iph;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.view.SliderBarHorizontal;

public class IpSliderBar146 extends SliderBarHorizontal {

	ImagesIpSliderBar146 images = GWT.create(ImagesIpSliderBar146.class);
	
	public IpSliderBar146(String leftTxt, String rightTxt){
		IScale iScale = new IScale(leftTxt, rightTxt, 146, 27);		
		iScale.addLeftStyleName("ip146whitelabel");
		iScale.addRightStyleName("ip146dgreylabel");		
		iScale.setBackGroundImage(new Image(images.scale().getUrl()));
		this.setLessWidget(new Image(images.moreLess()));
		setScaleWidget(iScale, 27);
		this.setLessWidget(new Image(images.moreLess()));
		this.setDragWidget(new Image(images.drag()));
		this.setWidth("148px");
		this.setMaxValue(1);
	}
		
	interface ImagesIpSliderBar146 extends ClientBundle {
		@Source("ifml.png")
		ImageResource moreLess();
		@Source("ifmdrag.png")
		ImageResource drag();
		@Source("ifmscl.png")
		DataResource scale();
	}	

}
