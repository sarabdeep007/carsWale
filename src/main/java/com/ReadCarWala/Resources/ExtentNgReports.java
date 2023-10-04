package com.ReadCarWala.Resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentNgReports {

	public static ExtentReports getExtentReports()
	{
		String reportPath = System.getProperty("user.dir")+"/Reports/index.html";
						
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		
		reporter.config().setDocumentTitle("Deep's Extent Reports");
		reporter.config().setReportName("CarWale Test Report");
	
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		return extent;
	}
}
