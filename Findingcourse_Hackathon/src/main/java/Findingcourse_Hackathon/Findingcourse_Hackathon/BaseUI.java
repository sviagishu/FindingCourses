package Findingcourse_Hackathon.Findingcourse_Hackathon;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import Utility.ReadExcelData;


public class BaseUI extends DriverSetup {
	
	/************************************************GET URL************************************************/
	
	public void getUrl() {
		try {
		reportPass("browser opened");
		driver.get("https://www.coursera.org/in");
		reportPass("Url opened successfully");
		}catch(Exception e) {
			reportFail("Url did not get opened");
		}
	}
	
	/******************************************SEND KEYS********************************************/
	
	public void sendKeys(String xpathKey,String textKey) {
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(prop.getProperty(textKey));
	}
	
	/********************************************CLICK**************************************************/
	
	public void click(String xpathKey) {
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).click();
	}
	
	/*************************************************WAIT******************************************/
	
	public void getWait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
			reportFail("waiting time failed");
		}
	}
	
	/*******************************************GET TEXT***************************************************/
	
	public void getText(String xpathKey) {
		String text=driver.findElement(By.xpath(prop.getProperty(xpathKey))).getText();
		System.out.println(text);
	}
	
	/***********************************************MOUSE HOVER**************************************************/
	
	public void MouseHover() {
		try {
		WebElement product=driver.findElement(By.xpath("//a[@href='https://www.coursera.org/business/products']"));
		Actions action=new Actions(driver);
		action.moveToElement(product).build().perform();
		reportPass("Mouse hovered at enterprise");
		}catch(Exception e){
			reportFail("Mouse did not hover at enterprise");
		}
	}
	
	/********************************************WINDOW HANDLE*****************************************************/
	
	 public void Switch(String page) {
		   Set<String> mainPage=driver.getWindowHandles();
		   Iterator<String> itr=mainPage.iterator();
		   String mainPageId=itr.next();
		   String campusPageId=itr.next();
		   //String formPartId=itr.next();
		   if(page.equalsIgnoreCase("campus")) {
		   driver.switchTo().window(campusPageId);
	   }
		   
		   else {
			   driver.switchTo().window(mainPageId);
		   }
	    }
	 
	 /******************************************FILL INPUT IN FORM*********************************************/
	 
	 public void fillForm() {
       
		 String[] formData = new String[9];
		 
		 try {
			formData=ReadExcelData.readData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 driver.findElement(By.cssSelector(prop.getProperty("firstname_cssSelector"))).sendKeys(formData[0]);
		 driver.findElement(By.cssSelector(prop.getProperty("lastname_cssSelector"))).sendKeys(formData[1]);
		 //selectDropDown("//*[@id=\\\"C4C_Job_Title__c\\",formData[2]);
		 Select select=new Select(driver.findElement(By.xpath("//*[@id=\"C4C_Job_Title__c\"]")));
		 select.selectByValue("Chancellor");
		 driver.findElement(By.xpath(prop.getProperty("jobTitle_xpath"))).sendKeys(formData[3]);
		 driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(formData[4]);
		 driver.findElement(By.xpath(prop.getProperty("phoneNumber"))).sendKeys(formData[5]);
		 driver.findElement(By.xpath(prop.getProperty("InstitutionName"))).sendKeys(formData[6]);
		 Select select1=new Select(driver.findElement(By.xpath(prop.getProperty("InstituitionType"))));
		 select1.selectByValue(formData[7]);
		 Select select2=new Select(driver.findElement(By.xpath(prop.getProperty("primary_xpath"))));
		 select2.selectByValue(formData[8]);
		 Select select3=new Select(driver.findElement(By.xpath(prop.getProperty("country_xpath"))));
		 select3.selectByValue(formData[9]);
		 driver.findElement(By.xpath(prop.getProperty("submit_xpath"))).click();
		 reportPass("Filling form is  completed");
		 
		  }
	 /************************************************dropdown****************************************************/
	 
	 public void selectDropDown(String xpath,String s) {
		   WebElement dropDown=driver.findElement(By.xpath(xpath));
		   Select dropdown=new Select(dropDown);
		   dropdown.selectByVisibleText(s);
	   }
	 /**************************************************get error message***********************************/
	 
	 public void getErrorMsg() {
		 String text=driver.findElement(By.xpath(prop.getProperty("errorMsg_xpath"))).getText();
		 System.out.println(text);
	 }
	 /*********************************************REPORT************************************************/
	 
	 public void reportFail(String reportString) {
			
			logger.log(Status.FAIL, reportString);
			takeScreenShot();

	 }
		
		public void reportPass(String reportString) {
			
			logger.log(Status.PASS,reportString);
			takeScreenShot();
			
			}
		/*************************************TIME STAMP***********************************************/
		
		public static String getTimeStamp() {    // renameng the time by repalcing : to _ and Space to _
			
			Date date = new Date();
			return date.toString().replaceAll(":", "_").replaceAll(" ","_");
			
		}
		
/*****************************************Screen Shot**************************************/
		
		public void takeScreenShot() {
			
			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
			File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
			
			File desFile = new File(System.getProperty("user.dir")+"\\Screenshots\\"+ getTimeStamp()+".png");
			try {
					FileUtils.copyFile(sourceFile, desFile);
					logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\"+ getTimeStamp()+".png");
				} catch (IOException e) {
		
				e.printStackTrace();
			}
			
		}
		
		
		public void waitElementClickable(String elementXpath) {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
		}
		
		
		}


