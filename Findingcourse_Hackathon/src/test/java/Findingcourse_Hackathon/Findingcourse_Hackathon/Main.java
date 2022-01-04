package Findingcourse_Hackathon.Findingcourse_Hackathon;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import Utility.Report;

public class Main {
	public ExtentReports report = Report.getExtentReport();
    
	
	public static void main(String args[]) throws IOException {
		EnterpriseTest test=new EnterpriseTest();
		test.searchCourse();
		test.testList();
		test.campusTest();
		
				
	}
	

}
