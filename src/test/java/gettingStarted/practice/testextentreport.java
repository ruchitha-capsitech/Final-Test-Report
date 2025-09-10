package gettingStarted.practice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class testextentreport {

    public static void main(String[] args) {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
        extent.attachReporter(spark);
        extent.createTest("Simple Test").pass("This test passed");
        extent.flush();
    }

    }

