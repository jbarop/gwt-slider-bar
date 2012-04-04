package com.kiouri.sliderbar.client.view;

import com.google.gwt.user.client.DOM;

public class Mark extends TouchableAbsolutePanelPK { // AbsolutePanelPK {

  int markWidth, markHeight;

  public Mark(final String color, final int width, final int height) {

    this.markWidth = width;
    this.markHeight = height;
    setPixelSize(width, height);
    DOM.setStyleAttribute(this.getElement(), "backgroundColor", color);

  }

  public int getMarkWidth() {
    return markWidth;
  }

  public int getMarkHeight() {
    return markHeight;
  }
}
