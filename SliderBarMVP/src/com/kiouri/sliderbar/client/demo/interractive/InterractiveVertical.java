package com.kiouri.sliderbar.client.demo.interractive;

import com.google.gwt.user.client.ui.Widget;
import com.kiouri.sliderbar.client.solution.simplevertical.SliderBarSimpleVertical;

public class InterractiveVertical {

	InrerractiveSample<SliderBarSimpleVertical> verticalInrerractiveSample;
	
	public InterractiveVertical(int maxValue, String width) {
		SliderBarSimpleVertical sliderBarSimpleVertical = 
			new SliderBarSimpleVertical(maxValue, width,  true);
		
		verticalInrerractiveSample = 
			new InrerractiveSample<SliderBarSimpleVertical>(sliderBarSimpleVertical,width);
	}
	
	public Widget asWidget(){
		return this.verticalInrerractiveSample;
	}
			
}
