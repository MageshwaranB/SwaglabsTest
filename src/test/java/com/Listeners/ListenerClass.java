package com.Listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.TestBase;
import utils.TakingScreenshot;

public class ListenerClass extends TestListenerAdapter
{
	public ExtentReports extent;
	public ExtentSparkReporter reporter;
	public ExtentTest extentTest;
	
	
	public void onStart(ITestContext context) 
	{
		
		reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/extentReport.html");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		reporter.config().setDocumentTitle("Swaglabs Demo Website Testing");
		reporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("Tester", "Mageshwaran");
		
		extent.setSystemInfo("Environment", "QA");
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		extentTest= extent.createTest(result.getName());
		extentTest.log(Status.PASS, "Testcase passed is "+result.getName());
		extentTest.log(Status.PASS, "Testcase status is "+result.getStatus());
	}

	public void onTestSkipped(ITestResult result) {
		extentTest=extent.createTest(result.getName());
		extentTest.log(Status.SKIP, "Testcase skipped is "+result.getName());
		extentTest.log(Status.SKIP, "Testcase status is "+result.getStatus());
	}
	public void onTestFailure(ITestResult result) 
	{
		extentTest= extent.createTest(result.getName());
		extentTest.log(Status.FAIL, "Testcase failed is "+result.getName());
		extentTest.log(Status.FAIL, "Testcase encountered "+result.getThrowable());
		extentTest.log(Status.FAIL, "Testcase status is "+result.getStatus());
		extentTest.addScreenCaptureFromPath(TakingScreenshot.getScreenshot(result.getName()), "Taking Screenshot of failed testcase: "+result.getName());
	}

	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}

}
