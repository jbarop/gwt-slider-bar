package com.kiouri.sliderbar.client.view;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.MouseEvent;
import com.google.gwt.user.client.ui.Widget;
import com.kiouri.sliderbar.client.presenter.Presenter;
import com.kiouri.sliderbar.client.presenter.Presenter.Orientation;

/**
 * 
 * @author kiouri
 *
 */
public class SliderBarVertical extends SliderBar{
	
	protected int barWidth, barHeight, dragLeftPosition, scaleHeight;
	
	public SliderBarVertical(Presenter presenter){
		super(presenter);
	}

	public SliderBarVertical(){
		super();
	}
	
	public int getBarWidth(){
		barWidth = drag.getOffsetWidth();		
		for (int i = 0; i < orderedWidgets.size(); i++){
			if (orderedWidgets.get(i) == scale){
				barWidth = Math.max(barWidth, scaleSize);
			} else {
				barWidth = Math.max(barWidth, orderedWidgets.get(i).getOffsetWidth());
			}			
		}		
		barWidth = Math.max(barWidth, scaleSize);
		return barWidth;				
	}	
	
	public void ajustScaleSize(int widgetHeight){	
		scaleHeight = widgetHeight;
		if (less != null) {
			for (int i = 0; i < less.size(); i++) {
				scaleHeight -= less.get(i).getOffsetHeight();
			}
		}		
		if (more != null) {
			for (int i = 0; i < more.size(); i++) {
				scaleHeight -= more.get(i).getOffsetHeight();
			}
		}
		scale.setPixelSize(scaleSize, scaleHeight);		
	}
	
	public int getAbsMaxLength() {
		return scaleHeight - drag.getOffsetHeight();
	}
	
	public void drawScrollBar(int barHeight) {		
		absPanel.clear();
		putWidgetsToAbsPanel();		
		initVariables(barHeight);
		ajustScaleSize(barHeight);		
		this.setWidth(getBarWidth() + "px");		
		absPanel.setPixelSize(getBarWidth(), barHeight);
		placeWidgets(orderedWidgets);
		absPanel.setWidgetPosition(drag, dragLeftPosition, getScaleTop(orderedWidgets));		
	}	

	protected void initVariables(int barHeight){		
		this.barHeight = barHeight;
		startPosition = getScaleTop(orderedWidgets);
		dragLeftPosition = (getBarWidth() - drag.getOffsetWidth())/2;
	}
	
    protected int getScaleTop(ArrayList<Widget> widgets){    	
    	int sPosition = 0; 
    	for (int i = 0; i < widgets.size(); i++){
    		if (widgets.get(i) != scale){
    			sPosition += widgets.get(i).getOffsetHeight(); 
    		} else {
    			return sPosition;
    		}
    	}
    	return sPosition;    	
    }
	    
	protected void placeWidgets(ArrayList<Widget> widgets){
		int tmpPosition = 0;
		int barWidth = getBarWidth();
		for (int i = 0; i < widgets.size(); i++){
			if (widgets.get(i) == scale){
				absPanel.setWidgetPosition(widgets.get(i), (barWidth - scaleSize)/2, tmpPosition);				
			} else {
				absPanel.setWidgetPosition(widgets.get(i), (barWidth - widgets.get(i).getOffsetWidth())/2, tmpPosition);
		    }	
			tmpPosition += widgets.get(i).getOffsetHeight();	
		}
	}

	public void setDragPosition(int position){
		position = startPosition + position;
		absPanel.setWidgetPosition(drag, dragLeftPosition, position);
	}

	public int getScaleTouchPosition(MouseEvent event) {
		return event.getRelativeY(this.getElement()) - startPosition - drag.getOffsetHeight()/2;
	}

	public int getDragPosition() {
		return absPanel.getWidgetTop(drag) - startPosition;
	}
		
	public void putMark(Mark mark, int markPosition) {
	       int markX = (this.barWidth - mark.getMarkWidth()) / 2;
	       this.absPanel.add(mark, markX, startPosition + markPosition + drag.getOffsetHeight()/2);		
	}
			
	public Orientation getOrientation(){
		return Orientation.VERTICAL;
	}
	
	@Override
	public void setHeight(String height) {
		super.setHeight(height);
		if ( this.isAttached()) {
			presenter.setBarPixelSize(this.getOffsetHeight());
			presenter.processParams();
			reDrawMarks();
			setValue(getValue());
		} 
	}

	/**
	 * It is not possible to adjust width of vertical sliderbar with help of this method. 
	 * Width of horizontal sliderbar is automatically calculated on base of height of components which are included in widget   
	 */
	@Override
	public void setWidth(String width) {
		super.setWidth(getBarWidth() + "px");
	}	
	
	public void setScaleWidget(Widget scaleWidget, int scaleWidth){
		super.setScaleWidget(scaleWidget, scaleWidth);
	}
	
}
