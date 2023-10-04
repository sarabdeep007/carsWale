package com.RealCarWala.Tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ReadCarWala.Resources.Constants;
import com.RealCarWala.PageObjects.HomePage;
import com.RealCarWala.PageObjects.UsedCarsCitiyWise;
import com.RealCarWala.TestComponents.BaseTest;

public class VerifySearchingCars extends BaseTest {
	
	private HomePage homePage;

	
	
	
	@BeforeMethod
	public void testSetUp()
	{
		homePage = new HomePage(driver);
		
	}
	
	
	@Test
	public void searchUsedCars() throws InterruptedException
	{
		UsedCarsCitiyWise usedCarsCitywisePage = homePage.searchUsedCar(Constants.carToSearch);
		try {
			homePage.locationSetup();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(usedCarsCitywisePage.verifyPageTitle("Used Cars"));
		
		
		
	}
	

}
