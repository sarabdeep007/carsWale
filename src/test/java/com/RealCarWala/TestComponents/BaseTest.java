package com.RealCarWala.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ReadCarWala.Resources.Constants;

public class BaseTest {
	
	public WebDriver driver;
	public static Properties config;
	public String configPropPath = System.getProperty("user.dir")+"/src/main/java/com/ReadCarWala/Resources/ConfigData.properties";
	public FileInputStream fis;
	
	
	
	public WebDriver initSetup()
	{
		
		//String configPropPath = System.getProperty("user.dir")+"/src/main/java/com/ReadCarWala/Resources/ConfigData.properties";
		config = new Properties();
		try {
			fis = new FileInputStream(configPropPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String browserName = config.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		
			
		return driver;
	}
	
	
	public String getScreenshot(String testName, WebDriver driver) throws IOException
	{
		LocalDateTime dt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyy_HHmmSS");
		
		String dateTime = dt.format(dtf);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"/screenshots/"+testName+"_"+dateTime+".png");
		
		
		FileUtils.copyFile(source, destination);
		
		
		return System.getProperty("user.dir")+"/screenshots/"+testName+"_"+dateTime+".png";
		
	}
	
	
	@BeforeMethod
	public void launchApp()
	{
		driver = initSetup();
		try {
			driver.get(Constants.URL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	

}
