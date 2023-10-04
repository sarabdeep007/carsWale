package com.RealCarWala.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.RealCarWala.AbstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	//Elements
	@FindBy(xpath="//div[@data-unique-key='new']")
	private WebElement homePageCarSelectDefaultSelection;
	
	@FindBy(xpath="//div[@class='o-brXWGL o-dsiSgT o-bUVylL o-AxjCR o-bkmzIL o-fHCdSc o-eZTujG o-TNyGU o-BEqzB o-frwuxB o-cOktWz o-cXBIhK o-jgFc  o-cpnuEd']//*[name()='svg']")
	private WebElement homePageCarSelectionDropDownUP;
	
	@FindBy(xpath="//span[@data-unique-key='used']")
	private WebElement homePageUsedCarSelectionOption;
	
	@FindBy(xpath="//input[@placeholder='City, eg: Mumbai']")
	private WebElement homePageSearchTextBox;
	
	
	@FindBy(xpath="//div[@class='o-brXWGL o-dsiSgT o-bUVylL o-AxjCR o-bkmzIL o-fHCdSc o-eZTujG o-TNyGU o-BEqzB o-frwuxB o-cOktWz o-cXBIhK o-jgFc o-flhBew o-cpnuEd']//*[name()='svg']")
	private WebElement homePageCarSelectionDropDownDOWN;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	private WebElement homePageSearchButton;
	
	
	
	//methods
	public UsedCarsCitiyWise searchUsedCar(String carName)
	{
		if(homePageCarSelectionDropDownUP.isDisplayed())
		{
			homePageUsedCarSelectionOption.click();
		}
		else if(homePageCarSelectionDropDownDOWN.isDisplayed())
		{
			homePageCarSelectionDropDownDOWN.click();
			homePageUsedCarSelectionOption.click();
		}
		
		homePageSearchTextBox.sendKeys(carName);
		homePageSearchButton.click();
		
		return new UsedCarsCitiyWise(driver);
		
		
	}

}
