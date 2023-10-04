package com.RealCarWala.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RealCarWala.AbstractComponents.AbstractComponents;

public class NewCarsPage extends AbstractComponents{

	WebDriver driver;
	Actions action;
	
	public NewCarsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	//elements
	@FindBy(xpath="//img[@title='Mahindra']")
	private WebElement newCarsMahindra;
	
	
	
	
	//methods
	public MahindraCarsPage gotoMahindra()
	{
		newCarsMahindra.click();
		return new MahindraCarsPage(driver);
	}
	
	
	

}
