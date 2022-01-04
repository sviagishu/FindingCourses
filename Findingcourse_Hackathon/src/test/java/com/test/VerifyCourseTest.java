package com.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Findingcourse_Hackathon.Findingcourse_Hackathon.BaseUI;
import Findingcourse_Hackathon.Findingcourse_Hackathon.DriverSetup;
import junit.framework.Assert;

public class VerifyCourseTest extends DriverSetup{
	BaseUI bse=new BaseUI();
	
	@BeforeTest
	public void initialSetup() {
		getDriver("chrome");

	}
	@Test
	public void getTestUrl() {
		driver.get(prop.getProperty("homeUrl"));
        driver.findElement(By.xpath(prop.getProperty("searchBox"))).sendKeys("web development course");
        driver.findElement(By.xpath(prop.getProperty("search_btn"))).click();

		}
	@Test
	public void selectLevelFilter() {
		driver.findElement(By.xpath(prop.getProperty("level_dropdown"))).click();
		driver.findElement(By.xpath(prop.getProperty("beginer_level"))).click();
	}
	@Test
	public void verifyLevelSelected() {
		//To test whether all displayed courses are of beginner level .........
		String levelCheck=driver.findElement(By.xpath(prop.getProperty("AllLevelXpath"))).getText();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(levelCheck);
		if(levelCheck.equalsIgnoreCase("Beginner")) {
         
			System.out.println("Level filter functionality is Working fine");
		}
		else {
			System.out.println("Level filter functionality is not Working fine");

		}
		
		driver.close();
	}
	
	

}
