package com.kiouri.sliderbar.client.demo;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.kiouri.sliderbar.client.demo.gmap.SliderBarGMapDemo;
import com.kiouri.sliderbar.client.demo.ybar.YBarDemo;
import com.kiouri.sliderbar.client.solution.adv.AdvancedSliderBar;
import com.kiouri.sliderbar.client.solution.iph.IpSliderBar146;
import com.kiouri.sliderbar.client.solution.iph.IpSliderBar51;
import com.kiouri.sliderbar.client.solution.kde.KDEHorizontalLeftBW;
import com.kiouri.sliderbar.client.solution.kde.KDEHorizontalRightBW;
import com.kiouri.sliderbar.client.solution.kde.KDEVerticalBottomBW;
import com.kiouri.sliderbar.client.solution.kde.KDEVerticalTopBW;
import com.kiouri.sliderbar.client.solution.sizeajuster.SizeAjuster;
import com.kiouri.sliderbar.client.solution.speedajuster.SpeedAjuster;

public class DemoSet extends AbsolutePanel {
	
	Label title = new Label("Various SliderBar samples");
	
	KDEVerticalTopBW kDEVerticalTopBW = new KDEVerticalTopBW(500,"320px");
	KDEVerticalBottomBW kDEVerticalBottomBW = new KDEVerticalBottomBW(10,"320px");
	KDEHorizontalRightBW kDEHorizontalRightBW = new KDEHorizontalRightBW(20, "400px");
	KDEHorizontalLeftBW kDEHorizontalLeftBW = new KDEHorizontalLeftBW(500, "400px");
	SliderBarGMapDemo sliderBarGMapDemoSelected = new SliderBarGMapDemo(false, 4);
	YBarDemo yBarDemo = new YBarDemo(false, 5);
	IpSliderBar146 ipSliderBar146MF = new IpSliderBar146("MALE", "FEMALE");
	IpSliderBar146 ipSliderBar146RS= new IpSliderBar146("Rain", "Snow");
	IpSliderBar51 ipSliderBar51OnOff = new IpSliderBar51("Off","On");
	IpSliderBar51 ipSliderBar51YesNo = new IpSliderBar51("No","Yes");
	SpeedAjuster speedAjuster = new SpeedAjuster();
	SizeAjuster sizeAjuster = new SizeAjuster();
	AdvancedSliderBar advancedSliderBar = new AdvancedSliderBar();
	
	
	public DemoSet(){
		title.addStyleName("demosettitle");
		this.addStyleName("demosetpanel");
		this.setSize("500px", "425px");
		this.add(title, 10,10);
		this.add(kDEVerticalTopBW,10, 60 );
		kDEVerticalTopBW.setValue(100);
		this.add(kDEVerticalBottomBW,40, 60 );
		kDEVerticalBottomBW.drawMarks("white", 8);
		kDEVerticalBottomBW.setValue(7);
		this.add(kDEHorizontalRightBW, 70, 60);
		kDEHorizontalRightBW.drawMarks("white", 8);
		kDEHorizontalRightBW.setValue(13);
		this.add(kDEHorizontalLeftBW, 70, 90);
		kDEHorizontalLeftBW.setValue(100);

		this.add(yBarDemo, 70, 120);
		this.add(sliderBarGMapDemoSelected,190, 120);
		this.add(ipSliderBar146MF, 323, 120);
		ipSliderBar146MF.setNotSelectedInFocus();
		this.add(ipSliderBar146RS, 323, 172);
		ipSliderBar146RS.setValue(1);
		this.add(ipSliderBar51OnOff, 323, 224);
		this.add(ipSliderBar51YesNo, 415, 224);
		ipSliderBar51OnOff.setValue(1);
		this.add(speedAjuster, 323, 276);
		speedAjuster.drawMarks("white", 2);
		speedAjuster.setValue(1);
		this.add(sizeAjuster, 323, 323);
		sizeAjuster.drawMarks("black", 2);
		sizeAjuster.setValue(2);
		this.add(advancedSliderBar, 323, 360);
		advancedSliderBar.drawMarks("black", 2);
		advancedSliderBar.setValue(3);
	}

}
