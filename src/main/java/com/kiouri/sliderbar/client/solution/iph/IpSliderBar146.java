package com.kiouri.sliderbar.client.solution.iph;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.view.SliderBarHorizontal;

public class IpSliderBar146 extends SliderBarHorizontal {

  private final Resources resources;

  public IpSliderBar146(final String leftTxt, final String rightTxt) {
    resources = GWT.create(Resources.class);
    resources.css().ensureInjected();

    IScale iScale = new IScale(leftTxt, rightTxt, 146, 27);
    iScale.addLeftStyleName(resources.css().ip146WhiteLabel());
    iScale.addLeftStyleName(resources.css().ip146DgreyLabel());
    iScale.setBackGroundImage(new Image(resources.scale().getSafeUri()));
    this.setLessWidget(new Image(resources.moreLess()));
    setScaleWidget(iScale, 27);
    this.setLessWidget(new Image(resources.moreLess()));
    this.setDragWidget(new Image(resources.drag()));
    this.setWidth("148px");
    this.setMaxValue(1);
  }

  interface Resources extends ClientBundle {
    @Source("ifml.png")
    ImageResource moreLess();

    @Source("ifmdrag.png")
    ImageResource drag();

    @Source("ifmscl.png")
    DataResource scale();

    @Source("IpSliderBarCss.css")
    IpSliderBarCss css();
  }

}
