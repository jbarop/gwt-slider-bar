package com.kiouri.sliderbar.client.solution.gmap;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.view.SliderBarVertical;

public class SliderBarGMap extends SliderBarVertical {

	ImagesSliderBarGMap images = GWT.create(ImagesSliderBarGMap.class);

	public SliderBarGMap(int maxValue, String height, boolean selectInFocus) {

		setLessWidget(new Image(images.less()));
		setScaleWidget(new Image(images.scale().getUrl()), 6);
		setMoreWidget(new Image(images.more()));
		setDragWidget(new Image(images.drag()));
		this.setHeight(height);
		this.setMaxValue(maxValue);
		if (!selectInFocus) {
			this.setNotSelectedInFocus();
		}		
		this.drawMarks("black", 4);
	}

	interface ImagesSliderBarGMap extends ClientBundle {

		@Source("draggmap.png")
		ImageResource drag();

		@Source("lessgmap.png")
		ImageResource less();

		@Source("moregmap.png")
		ImageResource more();

		@Source("scalegmap.png")
		DataResource scale();
	}

}
