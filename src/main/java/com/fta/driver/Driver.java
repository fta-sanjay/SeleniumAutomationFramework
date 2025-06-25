package com.fta.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fta.utils.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static WebDriver driver;
	
	public static void initDriver()
	{
		if(Objects.isNull(DriverManager.getDriver()))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.getDriver().get(ReadPropertyFile.getValue("URL"));
		}
	}
	
	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
