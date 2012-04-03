package com.kiouri.sliderbar.client.demo.interractive;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.kiouri.sliderbar.client.event.BarValueChangedEvent;
import com.kiouri.sliderbar.client.event.BarValueChangedHandler;
import com.kiouri.sliderbar.client.solution.simplehorizontal.SliderBarSimpleHorizontal;
import com.kiouri.sliderbar.client.view.SliderBar;

public class InrerractiveSample<T extends SliderBar> extends AbsolutePanel {
   T sliderBar;
   
    Label titleLabel = new Label("Vertical sliderbar interractive test");
	Label scaleColorLabel = new Label("Scale color");
	Button scaleDelimiterSize = new Button("Set scale delim. size");
	TextBox scaleDelimiterSizeBox = new TextBox();
	Label scaleDelimiterLabel = new Label("px");
	Label scaleSizeInfo =  new Label("(0 - 10 for this scrollbar)");
 	
	Button setValueButton = new Button("Set Current Value");
	TextBox valueBox = new TextBox();
	Label valueInfoLabel = new Label("This value coresponds to current knob positin.");
	CheckBox showScale = new CheckBox("Show scale");
	Button setMaxValueButton = new Button("Set Max Value");
	TextBox maxValueBox = new TextBox();
	Label maxValueInfoLabel = new Label();
	
	Button setPixelSizeButton = new Button();
	TextBox pixelSizeBox = new TextBox();
	
	ListBox unit = new ListBox();
	ListBox scaleColor = new ListBox();
	
	Button detachButton = new Button("Detach Sliderbar");

	String width;
	int delimSize = 6;
	
    AbsolutePanel valuePanel = new AbsolutePanel();
    AbsolutePanel scalePanel = new AbsolutePanel();
  
   public InrerractiveSample(T sBar, String width){
	   this.sliderBar = sBar;
	   this.width = width;

	   this.width = width;

	   initUI();
	   bind();				
   }
   
	public void initUI(){	
		this.addStyleName("interractivepanel");
		titleLabel.addStyleName("interractivetittle");
		this.initValuePanel();
		this.initScalePanel();
		if (sliderBar instanceof SliderBarSimpleHorizontal){
			this.titleLabel.setText("Horizontal sliderbar interractive test");
			this.maxValueInfoLabel.setText("This value corresponds to knob bottommost position");
			this.setPixelSizeButton.setText("Set width");
			this.add(titleLabel, 5,5);
			this.setPixelSize(962,200);		
			this.add((FocusPanel)sliderBar, 0, 40);		
			this.add(valuePanel, 0,60);		
			this.add(scalePanel,370, 65);
	    } else {
	    	this.titleLabel.setText("Vertical SliderBar interractive test");
	    	this.maxValueInfoLabel.setText("This value corresponds to knob rightmost position");
	    	this.setPixelSizeButton.setText("Set height");
	    	this.add(titleLabel, 50,5);
			this.setPixelSize(450,600);		
			this.add((FocusPanel)sliderBar, 5, 0);		
			this.add(valuePanel, 50, 35);		
			this.add(scalePanel, 50, 220);
	    }		
	}
    
	protected void bind(){		
		sliderBar
		.addBarValueChangedHandler(new BarValueChangedHandler() {
			public void onBarValueChanged(BarValueChangedEvent event) {
				valueBox.setValue("" + event.getValue());
			}
		});		
		
		scaleColor.addChangeHandler(new ChangeHandler(){
			public void onChange(ChangeEvent event) {
				sliderBar.removeMarks();
				String selectedColor = scaleColor.getItemText(scaleColor.getSelectedIndex()).trim();
				if (!(selectedColor.equalsIgnoreCase("white") ||selectedColor.equalsIgnoreCase("red"))){
					selectedColor = "light" + selectedColor;
				}
				sliderBar.drawMarks(selectedColor,delimSize);
				showScale.setValue(true);
			}
		});
		
		scaleDelimiterSize.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				try {
					delimSize = Integer.parseInt(scaleDelimiterSizeBox.getText().trim());
					delimSize = (delimSize > 0) ? delimSize : 0;
					delimSize = (delimSize < 10) ? delimSize : 10;
					sliderBar.removeMarks();
				} catch(Exception e){
					delimSize = 6;
				}
				scaleDelimiterSizeBox.setText(delimSize + "");
				sliderBar.drawMarks(scaleColor.getItemText(scaleColor.getSelectedIndex()),delimSize);
				showScale.setValue(true);
			}
		});
		
		setValueButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				try {
					int valueInt = Integer.parseInt(valueBox.getValue().trim());
					sliderBar.setValue(valueInt);
				} catch(Exception e){}	
				valueBox.setValue(sliderBar.getValue() + "");
			}			
		});
		
		showScale.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			   	if (((CheckBox)event.getSource()).getValue()){
			   		sliderBar.drawMarks(scaleColor.getItemText(scaleColor.getSelectedIndex()),6);
			   	} else {
			   		sliderBar.removeMarks();
			   	}
			}			
		});
		
		setMaxValueButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				try {
				int maxValueInt = Integer.parseInt(maxValueBox.getValue().trim());
				sliderBar.setMaxValue(maxValueInt);
				} catch (Exception e){}
				maxValueBox.setValue("" + sliderBar.getMaxValue());
			}
		});
		
		setPixelSizeButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				int barPixelSize;
				try {
				barPixelSize = Integer.parseInt(pixelSizeBox.getValue().trim());
				} catch (Exception e){
					if (sliderBar instanceof SliderBarSimpleHorizontal){
						pixelSizeBox.setValue(sliderBar.getOffsetWidth() + "");						
					} else {
						pixelSizeBox.setValue(sliderBar.getOffsetHeight() + "");
					}
					unit.setSelectedIndex(0);
					return;
				}
				unit.getItemText(unit.getSelectedIndex());
				if (sliderBar instanceof SliderBarSimpleHorizontal){
					sliderBar.setWidth(barPixelSize + unit.getItemText(unit.getSelectedIndex()));
					pixelSizeBox.setValue(sliderBar.getOffsetWidth() + "");
				} else { 
					sliderBar.setHeight(barPixelSize + unit.getItemText(unit.getSelectedIndex()));
					pixelSizeBox.setValue(sliderBar.getOffsetHeight() + "");
				}
				unit.setSelectedIndex(0);
			}
		});
		
		detachButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				if (sliderBar.isAttached()){
					InrerractiveSample.this.remove((FocusPanel)sliderBar);
					detachButton.setText("Attach Sliderbar");
				} else {
					InrerractiveSample.this.add((FocusPanel)sliderBar,5,5);
					detachButton.setText("Detach Sliderbar");
				}			
			}			
		});				
	}
	
	public String getIntSubstr(String str){		
		for (int i = str.length(); i > 0; i--){
			try {
				Integer.parseInt(str.substring(0,i));
				return str.substring(0,i);
			} catch(Exception e){

			}
		}
		return "0";
	}

	protected void initScalePanel(){
		scalePanel.setSize("210px", "120px");
//		DOM.setStyleAttribute(scalePanel.getElement(), "border", "1px solid darkgrey");
		scalePanel.addStyleName("interractivescalepanel");
		scalePanel.add(showScale,5,5);
		scaleColor.addItem("white");
		scaleColor.addItem("red");
		scaleColor.addItem("green");
		scaleColor.addItem("blue");
		scalePanel.add(scaleColorLabel, 5,35);
		scaleColor.setSelectedIndex(0);
		scalePanel.add(scaleColor, 72,35);
		
		scaleDelimiterSizeBox.setWidth("20px");
		scaleDelimiterSizeBox.setText("6");
		scalePanel.add(scaleDelimiterSize, 5, 70);
		scalePanel.add(scaleDelimiterSizeBox, 150, 70);
		scalePanel.add(scaleDelimiterLabel,180, 70);
		scalePanel.add(scaleSizeInfo, 20,100); 		
	}
	
	protected void initValuePanel(){
		
		valuePanel.setSize("390px", "175px");
		setValueButton.setWidth("130px");
		valuePanel.add(setValueButton, 5, 5);
		valueBox.setText("0");
		valueBox.setWidth("30px");
		valuePanel.add(valueBox,140,5);
		valuePanel.add(valueInfoLabel, 185, 5);
		
		setMaxValueButton.setWidth("130px");
		valuePanel.add(setMaxValueButton, 5, 50);	
		maxValueBox.setText("" +sliderBar.getMaxValue());
		maxValueBox.setWidth("30px");
		valuePanel.add(maxValueBox,140,50);
		valuePanel.add(maxValueInfoLabel, 185, 50);

		unit.addItem("px");
		unit.addItem("%");
		unit.setVisibleItemCount(1);
		setPixelSizeButton.setWidth("130px");
		valuePanel.add(setPixelSizeButton, 5, 95);	
		pixelSizeBox.setText( getIntSubstr(width) );
		pixelSizeBox.setWidth("30px");
		valuePanel.add(pixelSizeBox,140,95);
		valuePanel.add(unit,181,95);
		unit.setSelectedIndex(0);
		
		valuePanel.add(detachButton, 5, 140);
		detachButton.setWidth("130px");		
		
	}
   
}
