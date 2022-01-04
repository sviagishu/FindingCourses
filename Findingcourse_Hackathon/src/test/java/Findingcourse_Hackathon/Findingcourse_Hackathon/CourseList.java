package Findingcourse_Hackathon.Findingcourse_Hackathon;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Utility.ConvertToMap;
import Utility.SendToExcel;


public class CourseList extends CourseSearch {
	
	
	
	@Test(dependsOnMethods="searchCourse")
	public void ListElements() throws IOException {
		logger = report.createTest("Listing test");
		  waitElementClickable(prop.getProperty("languageDrop"));

	        // Find and Click Drop Down language filter
	        driver.findElement(By.xpath(prop.getProperty("languageDrop"))).click();
	       // snap("Language DropDown");

	        // Find SHOW ALL element and click it
	        waitElementClickable(prop.getProperty("showAll"));
	        waitElementClickable(prop.getProperty("showAll"));
	        Boolean present = false;
	        WebElement display = driver.findElement(By.xpath(prop.getProperty("showAll")));
	        present = display.isDisplayed();
	        display.click();
	        String text=driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[1]/div/div[3]/div/div[3]/div[2]")).getText();
	       
	        if (present) {
	           System.out.println("Langugaes are Displayed"+text);
	            
	        }
	        else {
	            System.out.println("Languages are not Displayed");
	        }
			reportPass("Language element Listed");

	
	}
	 @Test(dependsOnMethods="ListElements")
public void extractLanguageDetails() {
	        // Create lists of filter names and number of courses in it

	 

	        List<WebElement> languages = driver.findElements(By.xpath(prop.getProperty("languageList")));
	        List<WebElement> langCounts = driver.findElements(By.xpath(prop.getProperty("languageListCount")));

	 

	        LinkedHashMap<String, String> languageMap = new LinkedHashMap<String, String>();
	        System.out.println("Languages and their course count");

	 

	        // Convert list to map, to store in excel file
	        languageMap = ConvertToMap.convert(languages, langCounts);
	        try {

	 

	            // Send all the data to excel
	            // Parameters: Data_To_Be_Sent_From, SheetName, Column1_Heading, Column2_Heading
	            SendToExcel.sendData(languageMap, "Language", "LANGUAGE NAME", "INDIVIDUAL COURSE COUNT");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			reportPass("Language Element Listed and Extracted");

	        driver.findElement(By.xpath(prop.getProperty("languageClose"))).click();
       }
	 
@Test(dependsOnMethods="extractLanguageDetails")
   public void setLevels() {
	   
	         waitElementClickable(prop.getProperty("show"));

	        driver.findElement(By.xpath(prop.getProperty("show"))).click();
	        Boolean presentl = false;
	        presentl = driver.findElements(By.xpath(prop.getProperty("levelList"))).size() != 0;
	        String levelText=driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]")).getText();
	        if (presentl) {
	            System.out.println("Levels are Displayed"+levelText);
			reportPass("Level Element displayed");
	        }
	        else {
	            System.out.println("Levels are not Displayed");
	            reportFail("Level not displayed");
	        }
		   

	    }
@Test(dependsOnMethods="setLevels")
 public void extractLevelDetails() {
	        List<WebElement> levels = driver.findElements(By.xpath(prop.getProperty("levelList")));
	        List<WebElement> levelsCount = driver.findElements(By.xpath(prop.getProperty("levelListCount")));
	        LinkedHashMap<String, String> lMap = new LinkedHashMap<String, String>();
	        System.out.println("Levels and their course count");
	        lMap = ConvertToMap.convert(levels, levelsCount);
	        try {
	            SendToExcel.sendData(lMap, "Level", "LEVEL NAME", "INDIVIDUAL LEVEL COURSES");
				reportPass("Level dropdown element extracted and stored");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	   }
 @Test(dependsOnMethods="extractLevelDetails")
 public void backHome() {
     click("homepage");

 }
 @AfterSuite
 public void quitAll() {
	 driver.quit();
 }
 
 public void testList() throws IOException {
	 ListElements();
	 extractLanguageDetails();
	 setLevels();
     extractLevelDetails();
     backHome();
	 
 }
 
 
 
}
	        

	    
		


		
	          
		

	


