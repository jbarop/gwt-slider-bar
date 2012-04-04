package com.kiouri.sliderbar.client.solution.iph;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.view.SliderBarHorizontal;

public class IpSliderBar51 extends SliderBarHorizontal {

  private final Resources resources;

  public IpSliderBar51(final String leftTxt, final String rightTxt) {
    resources = GWT.create(Resources.class);
    resources.css().ensureInjected();

    IScale iScale = new IScale(leftTxt, rightTxt, 51, 27);
    iScale.setBackGroundImage(new Image(resources.scale().getSafeUri()));
    this.setLessWidget(new Image(resources.moreLess()));
    setScaleWidget(iScale, 27);
    this.setLessWidget(new Image(resources.moreLess()));
    this.setDragWidget(new Image(resources.drag()));
    iScale.addLeftStyleName(resources.css().ip51darLabelSmall());
    iScale.addRightStyleName(resources.css().ip51darLabelSmall());
    this.setWidth("53px");
    this.setMaxValue(1);
  }

  interface Resources extends ClientBundle {
    @Source("ifml.png")
    ImageResource moreLess();

    @Source("ionoffdrag.png")
    ImageResource drag();

    @Source("ionoffscl.png")
    DataResource scale();

    @Source("IpSliderBarCss.css")
    IpSliderBarCss css();
  }

}
