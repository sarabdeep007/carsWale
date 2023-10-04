package com.RealCarWala.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ReadCarWala.Resources.Constants;

public class AbstractComponents {
	
	WebDriver driver;
	
	public  AbstractComponents(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Elements
	@FindBy(xpath="//div[@class='o-dsiSgT qOkbof o-cpnuEd']")
	WebElement topNavLogo;
	
	@FindBy(xpath="//ul[@class='o-bkmzIL o-cpnuEd']/li[@class=' nS6XVS']")
	WebElement topNavNewCarsButton;
	
	@FindBy(xpath="//div[normalize-space()='USED CARS']")
	WebElement topNavUserCarsButton;
			
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement topNavSearchBox;
	
	@FindAll({@FindBy(xpath="//input[@placeholder='Type your city']"), 
		@FindBy(xpath="//input[@placeholder='Type your Pincode or City']")})
	
	
	WebElement locationSetup;
	
	
	
	@FindBy(xpath="(//div[@role='presentation']/div/div)[1]")
	WebElement selectCityTitle;
	
	@FindBy(css="#ui-id-2 li")
	List<WebElement> locationSelectionResults;
	
	
	
	//methods
	
	public void waitElementIsVisible(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitElementsListIsVisible(List<WebElement> ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	
	
	public WebElement topNavLogo()
	{
		return topNavLogo;
	}
	
	public WebElement topNavNewCarsButton()
	{
		return topNavNewCarsButton;
	}

	public WebElement topNavUserCarsButton()
	{
		return topNavUserCarsButton;
	}
	
	public WebElement topNavSearchBox()
	{
		return topNavSearchBox;
	}
	
	//div[@class='loc-widget position-rel openLocWidget loc-widget-fixed']
	public void locationSetup() throws InterruptedException
	{
		
		waitElementIsVisible(locationSetup);
		
		if(locationSetup.isDisplayed()) {
			locationSetup.sendKeys(Constants.locationSelection);
		}
		
		//waitElementsListIsVisible(locationSelectionResults);
		locationSelectionResults.get(0).click();
	}
	
	
	
	
	
			
	
	
}
