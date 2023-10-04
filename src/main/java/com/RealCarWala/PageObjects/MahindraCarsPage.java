package com.RealCarWala.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.RealCarWala.AbstractComponents.AbstractComponents;

public class MahindraCarsPage extends AbstractComponents {

	WebDriver driver;
	
	public MahindraCarsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
