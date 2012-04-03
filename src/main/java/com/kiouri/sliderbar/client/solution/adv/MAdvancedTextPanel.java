package com.kiouri.sliderbar.client.solution.adv;

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Image;
import com.kiouri.sliderbar.client.view.TouchableAbsolutePanelPK;

public class MAdvancedTextPanel extends TouchableAbsolutePanelPK {
	
	boolean isSelected = false;
	Image selectedImage, notSelectedImage;
	
	public MAdvancedTextPanel(Image notSelectedImage,Image selectedImage) {
		this.selectedImage = selectedImage;
		this.notSelectedImage = notSelectedImage;
		this.add(selectedImage,0,0);
		this.add(notSelectedImage,0,0);
		setNotSelectedStyle();
		bind();		
	}	

	public void setNotSelectedStyle(){
		selectedImage.setVisible(false);
		notSelectedImage.setVisible(true);				
	}

	public void setSelectedStyle(){
		selectedImage.setVisible(true);
		notSelectedImage.setVisible(false);				
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

	@Override
	protected void onLoad() {
		super.onLoad();
		this.setPixelSize(Math.max(selectedImage.getOffsetWidth(), notSelectedImage.getOffsetWidth()),Math.max(selectedImage.getOffsetHeight(), notSelectedImage.getOffsetHeight()));
	}
	
}
