package com.test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Findingcourse_Hackathon.Findingcourse_Hackathon.BaseUI;
import Findingcourse_Hackathon.Findingcourse_Hackathon.DriverSetup;

public class HomeSearchTest extends DriverSetup {

	BaseUI base=new BaseUI();
	
	@Test(priority=1)
	public void openBrowser() {
		getDriver("chrome");

	}
	@Test(priority=2)
	public void geturlForTest() {
		driver.get(prop.getProperty("homeUrl"));

	}
	@Test(priority=3)
	public void Search() {
          driver.findElement(By.xpath(prop.getProperty("searchBox"))).sendKeys("web development course");
	}
	@Test(priority=4)
	public void SearchProvidedCourse() {
        driver.findElement(By.xpath(prop.getProperty("search_btn"))).click();
        driver.navigate().back();

	}
	@Test(priority=5)
	public void searchNullTest() {
        driver.findElement(By.xpath(prop.getProperty("searchBox"))).sendKeys(" ");
        driver.findElement(By.xpath(prop.getProperty("search_btn"))).click();
        driver.navigate().back();


	}
	@AfterTest
	public void SearchTestClose() {
		driver.close();
	}
}
