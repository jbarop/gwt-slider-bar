package com.kiouri.sliderbar.client.demo.interractive;

import com.google.gwt.user.client.ui.RootPanel;
import com.kiouri.sliderbar.client.solution.simplehorizontal.SliderBarSimpleHorizontal;

public class InterractiveHorizontal {
	
	public InterractiveHorizontal(int maxValue, String width,  int left, int top) {
		SliderBarSimpleHorizontal sliderBarSimpleHorizontal = 
			new SliderBarSimpleHorizontal(maxValue, width,  true);
		
		InrerractiveSample<SliderBarSimpleHorizontal> horizontalInrerractiveSample = 
			new InrerractiveSample<SliderBarSimpleHorizontal>(sliderBarSimpleHorizontal,width);
		RootPanel.get().add(horizontalInrerractiveSample, left, top);
	}
	
}
