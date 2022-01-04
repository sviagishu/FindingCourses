package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class Report {
public static ExtentReports report;
	
	public static ExtentReports getExtentReport() {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "\\report.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("Project", "Finding courses");
		report.setSystemInfo("Cohort", "QEA21QE032");
		report.setSystemInfo("Team", "4");
		
		htmlReporter.config().setDocumentTitle("Coursera - Finding Course Test");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTimeStampFormat("MM dd, yyyy HH:mm:ss");
		return report;
	}

}
