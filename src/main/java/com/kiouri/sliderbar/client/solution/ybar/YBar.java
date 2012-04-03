package com.kiouri.sliderbar.client.solution.ybar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.presenter.Presenter;
import com.kiouri.sliderbar.client.view.SliderBarVertical;

public class YBar extends SliderBarVertical {
	
	ImagesYBar images = GWT.create(ImagesYBar.class);
	
	public YBar(int maxValue, String height, boolean selectInFocus, Presenter presenter) {
		super(presenter);
		setLessWidget(new Image(images.less()));
		Image scale = new Image(images.scale().getUrl());
		scale.addStyleName("ybarscale");
		setScaleWidget(scale, 25);
		setMoreWidget(new Image(images.more()));
		setDragWidget(new Image(images.drag()));
		this.setHeight(height);
		this.setMaxValue(maxValue);
		if (!selectInFocus) {
			this.setNotSelectedInFocus();
		}
		this.setMinMarkStep(0);
		this.drawMarks("white", 17);
	}
	
	public YBar(int maxValue, String height, boolean selectInFocus){
		this(maxValue, height, selectInFocus, null);
	}
	
	interface ImagesYBar extends ClientBundle {

		@Source("drag.png")
		ImageResource drag();

		@Source("less.png")
		ImageResource less();

		@Source("more.png")
		ImageResource more();

		@Source("scale.png")
		DataResource scale();
	}
		
}
