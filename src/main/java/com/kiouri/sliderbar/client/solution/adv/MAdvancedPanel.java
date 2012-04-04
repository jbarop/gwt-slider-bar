package com.kiouri.sliderbar.client.solution.adv;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.kiouri.sliderbar.client.view.TouchableAbsolutePanelPK;

public class MAdvancedPanel extends TouchableAbsolutePanelPK {

  interface Resources extends ClientBundle {
    @Source("MAdvancedCss.css")
    MAdvancedCss css();
  }

  private final Resources resources;
  String notSelectedStyleName = "madvnotselected";
  String selectedStyleName = "madvselected";
  boolean isSelected = false;

  public MAdvancedPanel() {
    resources = GWT.create(Resources.class);
    resources.css().ensureInjected();
    notSelectedStyleName = resources.css().madvNotSelected();
    selectedStyleName = resources.css().madvSelected();

    this.addStyleName(notSelectedStyleName);
    bind();
  }

  public void setNotSelectedStyleName(final String styleName) {
    notSelectedStyleName = styleName;
    if (!isSelected) {
      setNotSelectedStyle();
    }
  }

  public void setSelectedStyleName(final String styleName) {
    selectedStyleName = styleName;
    if (isSelected) {
      setSelectedStyle();
    }
  }

  public void setNotSelectedStyle() {
    removeStyleName(selectedStyleName);
    addStyleName(notSelectedStyleName);
  }

  public void setSelectedStyle() {
    removeStyleName(notSelectedStyleName);
    addStyleName(selectedStyleName);
  }

  public void bind() {
    this.addMouseOverEventHandler(new MouseOverHandler() {
      @Override
      public void onMouseOver(final MouseOverEvent event) {
        setSelectedStyle();
      }
    });

    this.addMouseOutEventHandler(new MouseOutHandler() {
      @Override
      public void onMouseOut(final MouseOutEvent event) {
        setNotSelectedStyle();
      }
    });
  }

}
