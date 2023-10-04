package com.RealCarWala.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.RealCarWala.PageObjects.HomePage;
import com.RealCarWala.TestComponents.BaseTest;

public class VerifyFindNewCars extends BaseTest {
	
	
	private HomePage homePage;
	
	@BeforeMethod
	public void testSetup()
	{
		homePage = new HomePage(driver);
		
	}
	
	@Test
	public void openPage() throws InterruptedException
	{
		System.out.println(homePage.findNewCars().pageTitle());
		
		
		Thread.sleep(2000);
	}

	@Test
	public void openMahindraPage() throws InterruptedException
	{
		System.out.println(homePage.findNewCars().gotoMahindra().pageTitle());
		
		
		Thread.sleep(2000);
	}
}
