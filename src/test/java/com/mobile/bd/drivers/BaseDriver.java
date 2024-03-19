package com.mobile.bd.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mobile.bd.drivers.PageDriver;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	
		
	AndroidDriver driver;

		@BeforeSuite
		public void startBrowser() throws MalformedURLException {
			 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		        desiredCapabilities.setCapability("appium:deviceName", "Pixel");
		        desiredCapabilities.setCapability("platformName", "android");
		        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
		        desiredCapabilities.setCapability("appium:appPackage", "com.nopstation.nopcommerce.nopstationcart");
		        desiredCapabilities.setCapability("appium:appActivity", "com.bs.ecommerce.main.SplashScreenActivity");
		        desiredCapabilities.setCapability("appium:udid", "emulator-5554");
		        URL remoteUrl = new URL("http://127.0.0.1:4723");
		        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			
			PageDriver.getInstance().setDriver(driver);
		}

		@AfterSuite
		public void closeBrowser() {
			driver.quit();
		}
}
