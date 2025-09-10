package gettingStarted.Actingoffice;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("testreport1.html");
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("ActingOffice Test Suite");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}