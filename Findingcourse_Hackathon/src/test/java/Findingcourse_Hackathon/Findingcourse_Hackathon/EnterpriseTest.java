package Findingcourse_Hackathon.Findingcourse_Hackathon;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class EnterpriseTest extends CourseList{
	public void campusTest() {
		logger = report.createTest("Enterprise test");

	click("Enterprise_xpath");
	
	 reportPass("Filling form is  completed");

	MouseHover();
	getWait(4000);
	click("productDropDown_Campus_xpath");
	Switch("campus");
	 reportPass("Navigated to campus tab ");

	click("contactus_xpath");
    getWait(3000);
    
    fillForm();
    
    getWait(2000);
    getErrorMsg();
    driver.close();
    driver.quit();
	
}
	@AfterTest
	public void endReport() {
		report.flush();
	}
}
