package com.RealCarWala.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RealCarWala.AbstractComponents.AbstractComponents;

public class UsedCarsCitiyWise extends AbstractComponents{

	WebDriver driver;
	public UsedCarsCitiyWise(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//elements
	@FindBy(css="#lisitngPageTitle")
	WebElement usedCarPageTitle;
	
	
	
	
	//methods
	public boolean verifyPageTitle(String pageTitle) throws InterruptedException
	{
		Thread.sleep(2000);
		
		if(usedCarPageTitle.getText().contains(pageTitle))
		{
			System.out.println(usedCarPageTitle.getText()+" is the Page title");
			System.out.println(driver.getTitle());
			return true;
			
		}
		
		return false;
	}
	
	

}
