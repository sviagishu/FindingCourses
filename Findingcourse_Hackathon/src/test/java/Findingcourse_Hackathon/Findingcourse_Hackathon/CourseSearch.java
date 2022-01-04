package Findingcourse_Hackathon.Findingcourse_Hackathon;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utility.SendToExcel;
import Utility.writeExcel;

public class CourseSearch extends BaseUI {
	
	@Test
	public void searchCourse() throws IOException {
		logger = report.createTest("Course search test ");

		getDriver("chrome");
		getUrl();
		reportPass("Invoked browser for test Execeution");
		
		sendKeys("searchBox","search_text");
		reportPass("Course entered and searched");

		click("search_btn");
		click("language_dropdown");
		getWait(2000);
		reportPass("Language dropdown functioanality checked");

		click("english_language");
		click("level_dropdown");
		
		reportPass("Level dropdown functionality checked");

		click("beginer_level");
		getText("title_course");
		getText("rating_course");
		getText("title2");
		getText("rating2");

  
		getWait(2000);
		click("clear_xpath");
	}

}
