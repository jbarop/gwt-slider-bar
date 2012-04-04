package com.kiouri.sliderbar.client.solution.iph;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.kiouri.sliderbar.client.view.TouchableAbsolutePanelPK;

public class IScale extends TouchableAbsolutePanelPK {

  Label leftLabel = new Label(), rightLabel = new Label();
  Image image;
  int imgHeight;
  int imgWidth;

  public IScale(final String leftTxt, final String rightTxt, final int imgWidth, final int imgHeight) {
    this.imgWidth = imgWidth;
    this.imgHeight = imgHeight;
    leftLabel.setText(leftTxt);
    rightLabel.setText(rightTxt);
  }

  public void addLeftStyleName(final String styleName) {
    leftLabel.addStyleName(styleName);
  }

  public void addRightStyleName(final String styleName) {
    rightLabel.addStyleName(styleName);
  }

  public void setBackGroundImage(final Image image) {
    this.image = image;
    this.add(image, 0, 0);
    this.add(leftLabel, 0, 0);
    this.add(rightLabel, 0, 0);
  }

  protected void placeLabels() {
    this.setWidgetPosition(leftLabel, (imgWidth / 2 - leftLabel.getOffsetWidth()) / 2,
        (imgHeight - leftLabel.getOffsetHeight()) / 2);
    this.setWidgetPosition(rightLabel, imgWidth / 2 + (imgWidth / 2 - rightLabel.getOffsetWidth())
        / 2, (imgHeight - rightLabel.getOffsetHeight()) / 2);
  }

  @Override
  protected void onLoad() {
    super.onLoad();
    setPixelSize(image.getOffsetWidth(), image.getOffsetHeight());
    placeLabels();
  }

}
