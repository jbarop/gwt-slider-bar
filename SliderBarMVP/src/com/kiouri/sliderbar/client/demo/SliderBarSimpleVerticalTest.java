package com.kiouri.sliderbar.client.demo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.kiouri.sliderbar.client.event.BarValueChangedEvent;
import com.kiouri.sliderbar.client.event.BarValueChangedHandler;
import com.kiouri.sliderbar.client.solution.simplevertical.SliderBarSimpleVertical;

public class SliderBarSimpleVerticalTest {

	SliderBarSimpleVertical sliderBarSimpleVertical;

	public SliderBarSimpleVerticalTest(int maxValue, String height,  int left, int top, boolean showRows) {

		sliderBarSimpleVertical = new SliderBarSimpleVertical(maxValue, height, showRows);

		sliderBarSimpleVertical
				.addBarValueChangedHandler(new BarValueChangedHandler() {
					public void onBarValueChanged(BarValueChangedEvent event) {
						GWT.log("value = " + event.getValue());
					}
				});

		RootPanel.get().add(sliderBarSimpleVertical.asWidget(), left, top);
	}

}
