package com.kiouri.sliderbar.client.solution.ybar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.presenter.Presenter;
import com.kiouri.sliderbar.client.view.SliderBarVertical;

public class YBar extends SliderBarVertical {

  private final Resources resources;

  public YBar(
      final int maxValue,
      final String height,
      final boolean selectInFocus,
      final Presenter presenter) {
    super(presenter);

    resources = GWT.create(Resources.class);
    resources.css().ensureInjected();

    setLessWidget(new Image(resources.less()));
    Image scale = new Image(resources.scale().getSafeUri());
    scale.addStyleName(resources.css().yBarScale());
    setScaleWidget(scale, 25);
    setMoreWidget(new Image(resources.more()));
    setDragWidget(new Image(resources.drag()));
    this.setHeight(height);
    this.setMaxValue(maxValue);
    if (!selectInFocus) {
      this.setNotSelectedInFocus();
    }
    this.setMinMarkStep(0);
    this.drawMarks("white", 17);
  }

  public YBar(final int maxValue, final String height, final boolean selectInFocus) {
    this(maxValue, height, selectInFocus, null);
  }

  interface Resources extends ClientBundle {

    @Source("drag.png")
    ImageResource drag();

    @Source("less.png")
    ImageResource less();

    @Source("more.png")
    ImageResource more();

    @Source("scale.png")
    DataResource scale();

    @Source("YBarCss.css")
    YBarCss css();
  }

}
