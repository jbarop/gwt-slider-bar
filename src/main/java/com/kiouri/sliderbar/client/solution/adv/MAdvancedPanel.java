package com.kiouri.sliderbar.client.solution.adv;

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.kiouri.sliderbar.client.view.TouchableAbsolutePanelPK;

public class MAdvancedPanel extends TouchableAbsolutePanelPK {

	String notSelectedStyleName = "madvnotselected";
	String selectedStyleName = "madvselected";
	boolean isSelected = false;
	
	public MAdvancedPanel(){
		this.addStyleName(notSelectedStyleName);
		bind();
	}
	
	public void setNotSelectedStyleName(String styleName){
		notSelectedStyleName = styleName;
		if (!isSelected){
			setNotSelectedStyle();
		}
	}

	public void setSelectedStyleName(String styleName){
		selectedStyleName = styleName;
		if (isSelected){
			setSelectedStyle();
		}
	}
	
	public void setNotSelectedStyle(){
		removeStyleName(selectedStyleName);
		addStyleName(notSelectedStyleName);				
	}

	public void setSelectedStyle(){
		removeStyleName(notSelectedStyleName);
		addStyleName(selectedStyleName);
	}
	
	public void bind(){
		this.addMouseOverEventHandler(new MouseOverHandler(){
			public void onMouseOver(MouseOverEvent event) {
				setSelectedStyle();
			}
		});
		
		this.addMouseOutEventHandler(new MouseOutHandler(){
			public void onMouseOut(MouseOutEvent event) {
				setNotSelectedStyle();			
			}
		});
	}
	
}
