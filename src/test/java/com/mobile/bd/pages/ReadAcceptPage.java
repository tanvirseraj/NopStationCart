package com.mobile.bd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.mobile.bd.drivers.PageDriver;
import com.mobile.bd.utilities.GetScreenShot;

public class ReadAcceptPage {
		
	ExtentTest test;

	public ReadAcceptPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBys({ @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/btnAccept\"]") })
	WebElement readaccept;
	
	//Pass Case
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
	}
	
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	
	//Fail Case
	public void failCase(String message, String scName) throws IOException {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void readacceptmethod() throws IOException{
		try {
			test.info("Please click on read accept");
			if (readaccept.isDisplayed()) {
				readaccept.click();
				//passCase("You have click on read accept");
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			//failCase("Read accept was not locateable. Please check the error message.", "readaccept_fail");
		}
	}
}
