package com.fta.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
	
	ExtentReports extent;
	public ExtentReports extentreport()
	{
		if(extent==null)
		{
		String extentreportpath=System.getProperty("user.dir") + "/test-output/ExtentReport.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(extentreportpath);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test Engineer", "Sanjay Singh");
		}
		return extent;
	}

}
