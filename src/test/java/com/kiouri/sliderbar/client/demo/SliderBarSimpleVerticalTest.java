package com.kiouri.sliderbar.client.demo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.kiouri.sliderbar.client.event.BarValueChangedEvent;
import com.kiouri.sliderbar.client.event.BarValueChangedHandler;
import com.kiouri.sliderbar.client.solution.simplevertical.SliderBarSimpleVertical;

public class SliderBarSimpleVerticalTest {

  SliderBarSimpleVertical sliderBarSimpleVertical;

  public SliderBarSimpleVerticalTest(
      final int maxValue,
      final String height,
      final int left,
      final int top,
      final boolean showRows) {

    sliderBarSimpleVertical = new SliderBarSimpleVertical(maxValue, height, showRows);

    sliderBarSimpleVertical.addBarValueChangedHandler(new BarValueChangedHandler() {
      @Override
      public void onBarValueChanged(final BarValueChangedEvent event) {
        GWT.log("value = " + event.getValue());
      }
    });

    RootPanel.get().add(sliderBarSimpleVertical.asWidget(), left, top);
  }

}
