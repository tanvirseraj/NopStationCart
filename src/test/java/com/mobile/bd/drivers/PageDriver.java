package com.mobile.bd.drivers;

import io.appium.java_client.android.AndroidDriver;

import com.mobile.bd.drivers.PageDriver;

public class PageDriver {
	public static final ThreadLocal<AndroidDriver> AndroidDriver = new ThreadLocal<AndroidDriver>();
	private static PageDriver instance = null;
	
	private PageDriver() {
		
	}
	
	public static PageDriver getInstance() {
		if(instance == null) {
			instance = new PageDriver();
		}
		return instance;
	}
	
	public AndroidDriver getDriver() {
		return AndroidDriver.get();
	}
	
	public void setDriver( AndroidDriver driver) {
		AndroidDriver.set(driver);
	}
	
	public static AndroidDriver getCurrentDriver() {
		return getInstance().getDriver();
	}
}
