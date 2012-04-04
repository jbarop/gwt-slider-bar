package com.kiouri.sliderbar.client.presenter;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.HasKeyDownHandlers;
import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.event.dom.client.HasMouseMoveHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.HasMouseUpHandlers;
import com.google.gwt.event.dom.client.HasMouseWheelHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
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
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.kiouri.sliderbar.client.event.BarValueChangedEvent;
import com.kiouri.sliderbar.client.event.BarValueChangedHandler;
import com.kiouri.sliderbar.client.view.Mark;

public class Presenter {

  public static enum Orientation {
    VERTICAL, HORIZONTAL
  }

  protected String POINTER = "Pointer";
  protected String DEFAULT = "Default";

  protected HandlerManager handlerManager = new HandlerManager(this);
  protected SliderBarCalculator sliderBarCalulator = new SliderBarCalculator();
  protected Display display;
  protected int maxValue;
  protected int touchPosition;
  protected boolean inDrag;
  protected int currentValue = 0, lastFiredValue = -1;
  protected Orientation orientation;
  protected int minMarkStep = 10;

  public Presenter(final Display display, final Orientation orientation) {
    this.display = display;
    this.orientation = orientation;
  }

  public Presenter(final Orientation orientation) {
    this(null, orientation);
  }

  public void setDislay(final Display display) {
    this.display = display;
  }

  public HandlerRegistration addBarValueChangedHandler(
      final BarValueChangedHandler barValueChangedHandler) {
    return handlerManager.addHandler(BarValueChangedEvent.TYPE, barValueChangedHandler);
  }

  public void setMaxValue(int maxValue) {
    maxValue = (maxValue >= 0) ? maxValue : 0;
    if (maxValue == 0) {
      display.setDragVisible(false);
    } else {
      display.setDragVisible(true);
    }
    this.maxValue = maxValue;
    sliderBarCalulator.setMaxValue(maxValue);
  }

  public void setAbsMaxLength(final int absMaxLength) {
    sliderBarCalulator.setAbsMaxLength(absMaxLength);
  }

  public void setBarPixelSize(final int barPixelSize) {
    display.drawScrollBar(barPixelSize);
    sliderBarCalulator.setAbsMaxLength(display.getAbsMaxLength());
  }

  public void setValue(int value) {
    value = checkValue(value);
    currentValue = value;
    if (!display.isAttached()) {
      return;
    }
    int absPosition = sliderBarCalulator.clcAbsPositionByValue(value);
    setDragPosition(absPosition, true);
  }

  public void processParams() {
    if (this.maxValue == 0) {
      return;
    }
    sliderBarCalulator.processParams();
  }

  public int getValue() {
    return currentValue;
  }

  protected void onRootMouseWheel(final MouseWheelEvent event) {
    increaseValue(event.getDeltaY());
  }

  protected void onRootKeyUpLeft() {
    increaseValue(-1);
  }

  protected void onRootKeyDownRight() {
    increaseValue(1);
  }

  protected void onDragMouseDown(final MouseDownEvent event) {
    if (this.maxValue == 0) {
      return;
    }
    stopDefaultAndPropagationForEvent(event);
    DOM.setCapture(display.getDragWidget().getElement());
    inDrag = true;
    touchPosition = display.getScaleTouchPosition(event);
  }

  protected void onDragMouseUp(final MouseUpEvent event) {
    if (this.maxValue == 0) {
      return;
    }
    inDrag = false;
    stopDefaultAndPropagationForEvent(event);
    DOM.releaseCapture(display.getDragWidget().getElement());
    currentValue = sliderBarCalulator.clcValueByAbsPosition(display.getDragPosition());
    setDragPosition(sliderBarCalulator.clcAbsPositionByValue(currentValue), true);
  }

  protected void onDragMouseMove(final MouseMoveEvent event) {
    if (this.maxValue == 0) {
      return;
    }
    event.preventDefault();
    if (!inDrag) {
      return;
    }
    int newTochPosition = display.getScaleTouchPosition(event);
    setDragPosition(
        sliderBarCalulator.checkAbsPosition(display.getDragPosition() + newTochPosition
            - touchPosition), false);
    touchPosition = newTochPosition;
  }

  protected void onScaleMouseDown(final MouseDownEvent event) {
    if (this.maxValue == 0) {
      return;
    }
    stopDefaultAndPropagationForEvent(event);
    currentValue = sliderBarCalulator.clcValueByAbsPosition(display.getScaleTouchPosition(event));
    setDragPosition(sliderBarCalulator.clcAbsPositionByValue(currentValue), true);
  }

  protected void onRootMouseDown(final MouseDownEvent event) {
    if (this.maxValue == 0) {
      return;
    }
    currentValue = sliderBarCalulator.clcValueByAbsPosition(display.getScaleTouchPosition(event));
    setDragPosition(sliderBarCalulator.clcAbsPositionByValue(currentValue), true);
  }

  protected void onRootMouseOver(final MouseOverEvent event) {
    if (this.maxValue == 0) {
      return;
    }
    setCursorType(POINTER);
    display.getRootWidget().getElement().focus();
  }

  protected void onRootMouseOut(final MouseOutEvent event) {
    if (this.maxValue == 0) {
      return;
    }
    setCursorType(DEFAULT);
  }

  protected void onLessMouseDown(final MouseDownEvent event) {
    if (this.maxValue == 0) {
      return;
    }
    stopDefaultAndPropagationForEvent(event);
    increaseValue(-1);
  }

  protected void onMoreMouseDown(final MouseDownEvent event) {
    if (this.maxValue == 0) {
      return;
    }
    stopDefaultAndPropagationForEvent(event);
    increaseValue(1);
  }

  public void bind() {

    ((HasMouseWheelHandlers) display.getRootWidget()).addMouseWheelHandler(new MouseWheelHandler() {
      @Override
      public void onMouseWheel(final MouseWheelEvent event) {
        event.preventDefault();
        onRootMouseWheel(event);
      }
    });

    ((HasKeyDownHandlers) display.getRootWidget()).addKeyDownHandler(new KeyDownHandler() {
      @Override
      public void onKeyDown(final KeyDownEvent event) {
        int nativeKeyCode = event.getNativeKeyCode();
        if (orientation == Orientation.VERTICAL) {
          if (nativeKeyCode == KeyCodes.KEY_UP) {
            onRootKeyUpLeft();
          }
          if (nativeKeyCode == KeyCodes.KEY_DOWN) {
            onRootKeyDownRight();
          }
        } else {
          if (nativeKeyCode == KeyCodes.KEY_LEFT) {
            onRootKeyUpLeft();
          }
          if (nativeKeyCode == KeyCodes.KEY_RIGHT) {
            onRootKeyDownRight();
          }
        }
      };
    });

    ((HasMouseDownHandlers) display.getDragWidget()).addMouseDownHandler(new MouseDownHandler() {
      @Override
      public void onMouseDown(final MouseDownEvent event) {
        onDragMouseDown(event);
      }
    });

    ((HasMouseMoveHandlers) display.getDragWidget()).addMouseMoveHandler(new MouseMoveHandler() {
      @Override
      public void onMouseMove(final MouseMoveEvent event) {
        onDragMouseMove(event);
      }
    });

    ((HasMouseUpHandlers) display.getDragWidget()).addMouseUpHandler(new MouseUpHandler() {
      @Override
      public void onMouseUp(final MouseUpEvent event) {
        onDragMouseUp(event);
      }
    });

    ((HasMouseDownHandlers) display.getScaleWidget()).addMouseDownHandler(new MouseDownHandler() {
      @Override
      public void onMouseDown(final MouseDownEvent event) {
        onScaleMouseDown(event);
      }
    });

    ((HasMouseDownHandlers) display.getRootWidget()).addMouseDownHandler(new MouseDownHandler() {
      @Override
      public void onMouseDown(final MouseDownEvent event) {
        onRootMouseDown(event);
      }
    });

    ((HasMouseOverHandlers) display.getRootWidget()).addMouseOverHandler(new MouseOverHandler() {
      @Override
      public void onMouseOver(final MouseOverEvent event) {
        onRootMouseOver(event);
      }
    });

    ((HasMouseOutHandlers) display.getRootWidget()).addMouseOutHandler(new MouseOutHandler() {
      @Override
      public void onMouseOut(final MouseOutEvent event) {
        onRootMouseOut(event);
      }
    });

    ArrayList<Widget> lessWidgets = display.getLessWidgets();
    if (lessWidgets != null) {
      for (int i = 0; i < lessWidgets.size(); i++) {
        ((HasMouseDownHandlers) lessWidgets.get(i)).addMouseDownHandler(new MouseDownHandler() {
          @Override
          public void onMouseDown(final MouseDownEvent event) {
            onLessMouseDown(event);
          }
        });
      }
    }

    ArrayList<Widget> moreWidgets = display.getMoreWidgets();
    if (moreWidgets != null) {
      for (int i = 0; i < moreWidgets.size(); i++) {
        ((HasMouseDownHandlers) moreWidgets.get(i)).addMouseDownHandler(new MouseDownHandler() {
          @Override
          public void onMouseDown(final MouseDownEvent event) {
            onMoreMouseDown(event);
          }
        });
      }
    }
  }

  public int getMaxValue() {
    return maxValue;
  }

  protected int checkValue(int value) {
    value = (value >= maxValue) ? maxValue : value;
    value = (value < 0) ? 0 : value;
    // if (value >= maxValue){
    // value = maxValue;
    // }
    // if (value < 0){
    // value = 0;
    // }
    return value;
  }

  protected void increaseValue(final int stepCount) {
    currentValue += stepCount;
    currentValue = checkValue(currentValue);
    int cDragPosition = display.getDragPosition();
    int nPosition = sliderBarCalulator.clcAbsPositionByValue(currentValue);
    if (cDragPosition == nPosition) {
      nPosition += stepCount / Math.abs(stepCount);
      currentValue = sliderBarCalulator.clcValueByAbsPosition(nPosition);
    }
    setDragPosition(sliderBarCalulator.clcAbsPositionByValue(currentValue), true);
  }

  public void setDragPosition(final int position, final boolean fireEvent) {
    currentValue = sliderBarCalulator.clcValueByAbsPosition(position);
    display.setDragPosition(position);
    if (fireEvent && currentValue != lastFiredValue) {
      handlerManager.fireEvent(new BarValueChangedEvent(currentValue));
    }
  }

  protected void stopDefaultAndPropagationForEvent(final DomEvent<?> event) {
    event.preventDefault();
    event.stopPropagation();
  }

  public void setCursorType(final String cursorType) {
    DOM.setStyleAttribute(display.getRootWidget().getElement(), "cursor", cursorType);
  }

  public void drawMarks(final String color, final int delimSize) {
    if (!isMarkAvailable()) {
      return;
    }
    int markWidth, markHeight;
    if (this.orientation == Orientation.VERTICAL) {
      markWidth = delimSize;
      markHeight = 1;
    } else {
      markWidth = 1;
      markHeight = delimSize;
    }

    for (int i = 0; i <= this.maxValue; i++) {
      Mark mark = new Mark(color, markWidth, markHeight);
      int markPosition = sliderBarCalulator.clcAbsPositionByValue(i);
      display.putMark(mark, markPosition);
    }
  }

  protected int getMarkStep() {
    return sliderBarCalulator.clcAbsPositionByValue(1)
        - sliderBarCalulator.clcAbsPositionByValue(0);
  }

  protected boolean isMarkAvailable() {
    int currentMarkStep = getMarkStep();
    if (currentMarkStep < this.minMarkStep || this.getMaxValue() == 0) {
      return false;
    } else {
      return true;
    }
  }

  public void setMinMarkStep(final int minMarkStep) {
    this.minMarkStep = minMarkStep;
  }

}
