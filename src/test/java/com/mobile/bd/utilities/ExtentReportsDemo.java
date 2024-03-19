package com.mobile.bd.utilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemo {
  ExtentHtmlReporter htmlReporter;
  ExtentReports extent;
  
  @BeforeSuite
  public void reportSetup() {
	  htmlReporter = new ExtentHtmlReporter("extent.html");
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);	  
  }
  @AfterSuite
  public void reportTearDown() {
  extent.flush();
  }
  
}
