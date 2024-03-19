package com.mobile.bd.tests;

import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.Duration;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.mobile.bd.drivers.PageDriver;
import com.mobile.bd.pages.ReadAcceptPage;
import com.mobile.bd.utilities.ExtentFactory;

//import io.appium.java_client.android.AndroidDriver;

public class ReadAcceptTest {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void openUrl() throws InterruptedException {
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:15px\"><b>Read Accept</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}
	
	@Test
	public void testPlaceOrderMethod() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:15px\"><b>Read Accept Details</b></p>");
		ReadAcceptPage readAcceptPage = new ReadAcceptPage(childTest);
		readAcceptPage.readacceptmethod();
	}
	
	@AfterClass
	public void report() throws InterruptedException {
		report.flush();
	}  
}
