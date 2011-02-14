package com.kiouri.sliderbar.client.demo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.kiouri.sliderbar.client.event.BarValueChangedEvent;
import com.kiouri.sliderbar.client.event.BarValueChangedHandler;
import com.kiouri.sliderbar.client.solution.simplehorizontal.SliderBarSimpleHorizontal;

public class SliderBarSimpleHorizontalTest {

	SliderBarSimpleHorizontal sliderBarSimpleHorizontal;

	public SliderBarSimpleHorizontalTest(int maxValue, String width,  int left, int top, boolean showRows) {

		sliderBarSimpleHorizontal = new SliderBarSimpleHorizontal(maxValue, width, showRows);

		sliderBarSimpleHorizontal
				.addBarValueChangedHandler(new BarValueChangedHandler() {
					public void onBarValueChanged(BarValueChangedEvent event) {
						GWT.log("value = " + event.getValue());
					}
				});

		RootPanel.get().add(sliderBarSimpleHorizontal.asWidget(), left, top);
	
	}	
	
}
