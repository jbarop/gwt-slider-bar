package com.kiouri.sliderbar.client.presenter;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.MouseEvent;
import com.google.gwt.user.client.ui.Widget;
import com.kiouri.sliderbar.client.presenter.Presenter.Orientation;
import com.kiouri.sliderbar.client.view.Mark;

/**
 * 
 * @author kiouri
 *
 */
public interface Display {
	
	Widget getRootWidget();
	ArrayList<Widget> getMoreWidgets();
	ArrayList<Widget> getLessWidgets();
	Widget getDragWidget();
	Widget getScaleWidget();
	int getAbsMaxLength();
	Orientation getOrientation();
	int getScaleTouchPosition(MouseEvent event);
	
	int getDragPosition();
	void setDragPosition(int position);
	
	void drawScrollBar(int barPixelSize);
	Widget asWidget();
	
	void putMark(Mark mark, int markPosition);
	
	public boolean isAttached();
	
	void setDragVisible(boolean isVisible);
	
}
