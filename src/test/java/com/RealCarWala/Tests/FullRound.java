package com.RealCarWala.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FullRound {
	
	public static void main(String[] args) throws InterruptedException
	{
		
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.carwale.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		
		String pageTitle = driver.getTitle();
				
		System.out.println(pageTitle);
		
		
		
		
		
		WebElement topNavLogo = driver.findElement(By.xpath("//div[@class='o-dsiSgT qOkbof o-cpnuEd']"));
		
		WebElement topNavNewCarsButton = driver.findElement(By.xpath("//ul[@class='o-bkmzIL o-cpnuEd']/li[@class=' nS6XVS']"));
		
		WebElement topNavUserCarsButton = driver.findElement(By.xpath("//div[normalize-space()='USED CARS']"));
				
		WebElement topNavSearchBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		
		WebElement homePageCarSelectDefaultSelection = driver.findElement(By.xpath("//div[@data-unique-key='new']"));
		
		
		WebElement homePageCarSelectionDropDownUP = driver.findElement(By.xpath(""
				+ "//div[@class='o-brXWGL o-dsiSgT o-bUVylL o-AxjCR o-bkmzIL o-fHCdSc o-eZTujG o-TNyGU o-BEqzB o-frwuxB o-cOktWz o-cXBIhK o-jgFc  o-cpnuEd']//*[name()='svg']"));
		
		
		WebElement homePageUsedCarSelectionOption = driver.findElement(By.xpath("//span[@data-unique-key='used']"));
		
		if(homePageCarSelectionDropDownUP.isDisplayed())
		{
			homePageUsedCarSelectionOption.click();
		}
		
		Thread.sleep(2000);
		WebElement homePageSearchTextBox = driver.findElement(By.xpath("//input[@placeholder='City, eg: Mumbai']"));
		
		
		
//		WebElement homePageCarSelectionDropDownDOWN = driver.findElement(By.xpath(""
//		         + "//div[@class='o-brXWGL o-dsiSgT o-bUVylL o-AxjCR o-bkmzIL o-fHCdSc o-eZTujG o-TNyGU o-BEqzB o-frwuxB o-cOktWz o-cXBIhK o-jgFc o-flhBew o-cpnuEd']//*[name()='svg']"));
//			
//		else if(homePageCarSelectionDropDownDOWN.isDisplayed())
//		{
//			homePageCarSelectionDropDownDOWN.click();
//			homePageUsedCarSelectionOption.click();
//			
//		}
		
		
		homePageSearchTextBox.sendKeys("BMW x5");
		
		WebElement homePageSearchButton = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
		
		homePageSearchButton.click();
		
		Thread.sleep(3000);
		
		
		
	}

}
