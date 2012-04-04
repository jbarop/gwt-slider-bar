package com.kiouri.sliderbar.client.demo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.kiouri.sliderbar.client.event.BarValueChangedEvent;
import com.kiouri.sliderbar.client.event.BarValueChangedHandler;
import com.kiouri.sliderbar.client.solution.simplehorizontal.SliderBarSimpleHorizontal;

public class SliderBarSimpleHorizontalTest {

  SliderBarSimpleHorizontal sliderBarSimpleHorizontal;

  public SliderBarSimpleHorizontalTest(
      final int maxValue,
      final String width,
      final int left,
      final int top,
      final boolean showRows) {

    sliderBarSimpleHorizontal = new SliderBarSimpleHorizontal(maxValue, width, showRows);

    sliderBarSimpleHorizontal.addBarValueChangedHandler(new BarValueChangedHandler() {
      @Override
      public void onBarValueChanged(final BarValueChangedEvent event) {
        GWT.log("value = " + event.getValue());
      }
    });

    RootPanel.get().add(sliderBarSimpleHorizontal.asWidget(), left, top);

  }

}
