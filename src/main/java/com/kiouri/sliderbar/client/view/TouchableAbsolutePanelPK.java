package com.kiouri.sliderbar.client.view;

import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.AbsolutePanel;

public class TouchableAbsolutePanelPK extends AbsolutePanel implements HasAllMouseHandlers {

  @Override
  public HandlerRegistration addMouseDownHandler(final MouseDownHandler handler) {
    return addDomHandler(handler, MouseDownEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseUpHandler(final MouseUpHandler handler) {
    return addDomHandler(handler, MouseUpEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseOutHandler(final MouseOutHandler handler) {
    return addDomHandler(handler, MouseOutEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseOverHandler(final MouseOverHandler handler) {
    return addDomHandler(handler, MouseOverEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseMoveHandler(final MouseMoveHandler handler) {
    return addDomHandler(handler, MouseMoveEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseWheelHandler(final MouseWheelHandler handler) {
    return addDomHandler(handler, MouseWheelEvent.getType());
  }

  public HandlerRegistration addMouseOverEventHandler(final MouseOverHandler handler) {
    return addDomHandler(handler, MouseOverEvent.getType());
  }

  public HandlerRegistration addMouseOutEventHandler(final MouseOutHandler handler) {
    return addDomHandler(handler, MouseOutEvent.getType());
  }

}
