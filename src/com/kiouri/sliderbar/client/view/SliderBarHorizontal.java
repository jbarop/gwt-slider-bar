package com.kiouri.sliderbar.client.view;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.MouseEvent;
import com.google.gwt.user.client.ui.Widget;
import com.kiouri.sliderbar.client.presenter.Presenter.Orientation;

/**
 * 
 * @author kiouri
 *
 */
public class SliderBarHorizontal extends SliderBar {
	
	protected int barWidth, barHeight, dragTopPosition, scaleWidth;
	
	protected int getBarHeight(){
		barHeight = drag.getOffsetHeight();		
		for (int i = 0; i < orderedWidgets.size(); i++){
			if (orderedWidgets.get(i) == scale){
				barHeight = Math.max(barHeight, scaleSize);
			} else {
				barHeight = Math.max(barHeight, orderedWidgets.get(i).getOffsetHeight());
			}
		}		
		barHeight = Math.max(barHeight, scaleSize);
		return barHeight;		
	}
	
	protected void ajustScaleSize(int widgetWidth){
		scaleWidth = widgetWidth;
		if (less != null) {
			for (int i = 0; i < less.size(); i++) {
				scaleWidth -= less.get(i).getOffsetWidth();
			}
		}		
		if (more != null) {
			for (int i = 0; i < more.size(); i++) {
				scaleWidth -= more.get(i).getOffsetWidth();
			}
		}
		scale.setPixelSize(scaleWidth, scaleSize);
	}
	
	public int getAbsMaxLength() {
		return scaleWidth - drag.getOffsetWidth();
	}
	
	public void drawScrollBar(int barWidth) {
		absPanel.clear();
		putWidgetsToAbsPanel();		
		initVariables(barWidth);
		ajustScaleSize(barWidth);		
		this.setHeight(getBarHeight() + "px");		
		absPanel.setPixelSize(barWidth,getBarHeight());
		placeWidgets(orderedWidgets);
		absPanel.setWidgetPosition(drag, getScaleLeft(orderedWidgets), dragTopPosition);
	}	

	protected void initVariables(int barWidth){
		this.barWidth = barWidth;
		startPosition = getScaleLeft(orderedWidgets);
		dragTopPosition = (getBarHeight() - drag.getOffsetHeight())/2;
	}
	
    protected int getScaleLeft(ArrayList<Widget> widgets){
    	int sPosition = 0; 
    	for (int i = 0; i < widgets.size(); i++){
    		if (widgets.get(i) != scale){
    			sPosition += widgets.get(i).getOffsetWidth(); 
    		} else {
    			return sPosition;
    		}
    	}
    	return sPosition;
    }
	
	protected void placeWidgets(ArrayList<Widget> widgets){
		int tmpPosition = 0;
		int barHeight = getBarHeight();
		for (int i = 0; i < widgets.size(); i++){
			if (widgets.get(i) == scale){
				absPanel.setWidgetPosition(widgets.get(i), tmpPosition, (barHeight - scaleSize)/2);
			} else {
				absPanel.setWidgetPosition(widgets.get(i), tmpPosition, (barHeight - widgets.get(i).getOffsetHeight())/2);
		    }	
			tmpPosition += widgets.get(i).getOffsetWidth();	
		}
	}    
	
	public void setDragPosition(int position){
		position = startPosition + position;
		absPanel.setWidgetPosition(drag, position, dragTopPosition );
	}
	
	public int getScaleTouchPosition(MouseEvent event) { 
		return event.getRelativeX(this.getElement()) - startPosition - drag.getOffsetWidth()/2; 
	}
	
	public int getDragPosition() {
		return absPanel.getWidgetLeft(drag) - startPosition;
	}	
	
    /**
     * Sets scale mark to scale
     */
	public void putMark(Mark mark, int markPosition) {
	      int markY = (this.barHeight - mark.getMarkHeight()) / 2;
	      this.absPanel.add(mark, this.startPosition + markPosition + drag.getOffsetWidth()/2, markY);				
		}

	public Orientation getOrientation(){
		return Orientation.HORIZONTAL;
	}
	
	@Override
	/**
	 * It is not possible to adjust height of horizontal sliderbar with help of this method. 
	 * Height of horizontal sliderbar is automatically calculated on base of height of components which are included in widget   
	 */
	public void setHeight(String height) {
		super.setHeight(getBarHeight() + "px");
	}

	@Override
	public void setWidth(String width) {
		super.setWidth(width);
		if (isAttached()) {
			presenter.setBarPixelSize(this.getOffsetWidth());
			presenter.processParams();
			reDrawMarks();
			setValue(getValue());
		}
	}
		
	public void setScaleWidget(Widget scaleWidget, int scaleHeight){
		super.setScaleWidget(scaleWidget, scaleHeight);
	}
	 			
}
