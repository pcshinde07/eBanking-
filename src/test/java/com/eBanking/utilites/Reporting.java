package com.eBanking.utilites;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentRep;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp statement.
		String resName = "Test-Report-" + timestamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + resName); // location
															// "./test-												// path to
																											// store the
																											// report
																											// file
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		extentRep = new ExtentReports();

		extentRep.attachReporter(htmlReporter);
		extentRep.setSystemInfo("Host name", "localhost");
		extentRep.setSystemInfo("Environment", "QA");
		extentRep.setSystemInfo("user", "Pratik");

		htmlReporter.config().setDocumentTitle("eBanking Test Project");// to sent the tile of report
		htmlReporter.config().setReportName("Functional Test Report"); // name of the report
		htmlReporter.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult tr) {
		logger = extentRep.createTest(tr.getName()); // create each passed test new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // Send the passed
																							// information to the report
	}

	public void onTestFailure(ITestResult tr) {
		logger = extentRep.createTest(tr.getName()); // crate each failed test entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		try {
			logger.addScreenCaptureFromPath(tr.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void onTestSkipped(ITestResult tr) {
		logger = extentRep.createTest(tr.getName());// create each skipped test entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext) {
		extentRep.flush();
	}

}
