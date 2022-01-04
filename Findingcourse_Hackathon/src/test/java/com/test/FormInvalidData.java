package com.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Findingcourse_Hackathon.Findingcourse_Hackathon.BaseUI;
import Findingcourse_Hackathon.Findingcourse_Hackathon.DriverSetup;

public class FormInvalidData extends DriverSetup {
	BaseUI base=new BaseUI();
	
	@BeforeTest
	public void invokeBrowser() {
		getDriver("chrome");
		base.logger = report.createTest("Check form functionality ");
	}
	
	@Test(priority=1)
	public void onlyFirstName() {
		
		driver.get(prop.getProperty("formUrl"));
		driver.findElement(By.xpath(prop.getProperty("contactus_xpath"))).click();
		driver.findElement(By.cssSelector(prop.getProperty("firstname_cssSelector"))).sendKeys("demo");
		driver.findElement(By.xpath(prop.getProperty("submit_xpath"))).click();
		
		driver.navigate().refresh();
	}
	
	@Test(priority=2)
	public void onlyLastName() {
		driver.findElement(By.cssSelector(prop.getProperty("lastname_cssSelector"))).sendKeys("demoLN");
		driver.findElement(By.xpath(prop.getProperty("submit_xpath"))).click();
		driver.navigate().refresh();
		
	}
	
	@Test(priority=3)
	public void onlyJobTitle() {
		driver.findElement(By.xpath(prop.getProperty("jobTitle_xpath"))).sendKeys("demoLN");
        driver.findElement(By.xpath(prop.getProperty("submit_xpath"))).click();
        
		driver.navigate().refresh();
	}
	
	@Test(priority=4)
	public void onlyValidEmail() {
		driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys("demo@gmail.com");
        driver.findElement(By.xpath(prop.getProperty("submit_xpath"))).click();
       

		driver.navigate().refresh();
		
	}
	
	@Test(priority=5)
	public void onlyInvalidEmail() {
		driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys("demo12345");
        driver.findElement(By.xpath(prop.getProperty("submit_xpath"))).click();
        

		driver.navigate().refresh();
	}
	@Test(priority=6)

	public void validPhNumber() {
		driver.findElement(By.xpath(prop.getProperty("phoneNumber"))).sendKeys("91 9876445671");
        driver.findElement(By.xpath(prop.getProperty("submit_xpath"))).click();
        

		driver.navigate().refresh();
	}
	@Test(priority=7)

	public void invalidPhNumber() {
		driver.findElement(By.xpath(prop.getProperty("phoneNumber"))).sendKeys("9876445");
        driver.findElement(By.xpath(prop.getProperty("submit_xpath"))).click();
		driver.navigate().refresh();
	}
	@Test(priority=8)

	public void nullSubmit() {
		 driver.findElement(By.xpath(prop.getProperty("submit_xpath"))).click();
			driver.navigate().refresh();
		
	}
	@Test(priority=9)
	public void ValidFormSubmit() {

		driver.close();
		
	}
}
