package com.kiouri.sliderbar.client.demo;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class Description extends AbsolutePanel {

	HTML html = new HTML();

	public Description() {
		this.addStyleName("descriptionpanel");
		this.setSize("500px", "150px");
		html
				.setHTML("With help of <b>SliderBar</b> framework You can utilize set of ready to use sliderbars or <u><i>easy create</i></u> your own sliderbars.<br><br>"
						+ "It is possible to interracr with scrollbars by all availabble means:<br>"
						+ "I.   drag knob <br>"
						+ "II.  clic mouse on scale or on scale arrows<br> "
						+ "III. use arrow keys on clipboard<br>"
						+ "IV.  use mouse wheel");
		this.add(html, 5, 5);
	}

}
 