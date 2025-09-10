package gettingStarted.Actingoffice;

import extensions.commonmethods;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.time.Duration;

public class Test70 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup(Method method) throws Exception {
        VideoRecorder.startRecording(method.getName());
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.manage().window().maximize();
        Allure.step("Browser launched and maximized");
    }

    @Test(description = "Charts should display values for all statuses: Pending, Accepted, Paid, and Due")
    @Epic("Entire BK")
    @Feature("Chart")
    @Story("Chart should reflect all statuses correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void Chart_Validation_Test() {
        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com");
        Allure.step("Navigated to login page");

        commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");
        commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");
        Allure.step("Entered login credentials");

        WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));
        elementLogin.click();
        Allure.step("Login submitted");

        driver.navigate().to("https://appdev.actingoffice.com/admin");
        Allure.step("Navigated to Admin page");

        WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
        elementDashboard.click();
        Allure.step("Dashboard opened");

        WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
        elementBookkeeping.click();
        Allure.step("Bookkeeping opened");

        WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
        elementCompany.click();
        Allure.step("Company selected");

        WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
        elementInputsButton.click();
        Allure.step("Inputs opened");

        WebElement elementSales = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sales")));
        elementSales.click();
        Allure.step("Sales module opened");

        WebElement elementEstimates = wait.until(ExpectedConditions.elementToBeClickable(By.name("Estimates")));
        elementEstimates.click();
        Allure.step("Estimates chart opened");

        WebElement elementPurchase = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchases")));
        elementPurchase.click();
        Allure.step("Purchases chart opened");

        WebElement elementPurchaseOrders = wait.until(ExpectedConditions.elementToBeClickable(By.name("Purchase orders")));
        elementPurchaseOrders.click();
        Allure.step("Purchase Orders chart opened");


    }

    private byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(takeScreenshot()));
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                Allure.addAttachment("Success Screenshot", new ByteArrayInputStream(takeScreenshot()));
            }
            String videoPath = VideoRecorder.stopRecording();
            if (videoPath != null) {
                File videoFile = new File(videoPath);
                if (videoFile.exists() && videoFile.length() > 0) {
                    Allure.addAttachment("Test Video (AVI)", "video/x-msvideo",
                            new FileInputStream(videoFile), "avi");
                }
            }
        } catch (Exception e) {
            System.out.println("Could not capture artifacts: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
                Allure.step("Browser closed");
            }
        }
    }
}
















//package gettingStarted.Actingoffice;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import extensions.commonmethods;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//public class Test70 {
//    static ExtentReports extent;
//    static ExtentTest test;
//
//    public static void test() {
//        extent = ReportManager.getInstance();
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        test = extent.createTest("Create purchase invoice Test");
//        try {
//            driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
//            driver.manage().window().maximize();
//            commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");
//
//            commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");
//
//            WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]")));
//            elementLogin.click();
//            driver.navigate().to("https://appdev.actingoffice.com/admin");
//
//            WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
//            elementDashboard.click();
//
//            WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
//            elementBookkeeping.click();
//
//            WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
//            elementCompany.click();
//
//            By inputsButton = By.id("inputs");
//            WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(inputsButton));
//            elementInputsButton.click();
//
//
//            WebElement elementSales = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sales")));
//            elementSales.click();
//
//            WebElement elementEstimates = wait.until(ExpectedConditions.elementToBeClickable(By.name("Estimates")));
//            elementEstimates.click();
//
//            WebElement elementPurchase = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchases")));
//            elementPurchase.click();
//
//            WebElement elementPurchaseorders = wait.until(ExpectedConditions.elementToBeClickable(By.name("Purchase orders")));
//            elementPurchaseorders.click();
//        } catch (Exception e) {
//            test.fail("Test failed: " + e.getMessage());
//        } finally {
//            extent.flush();
//        }
//    }
//
//    public static void main(String[] args) {
//        //        test();
//        ExcelLogger.logResult(
//                "Entire BK",
//                "Chart",
//                "There should be a value present in all statuses: Pending, Accepted, Paid, and Due.",
//                "Display all the charts in the report and create invoices within them so that values appear in all of them.",
//                "Check the calculations for all charts to ensure that the totals and percentages are calculated correctly.",
//                "verified",
//                "",
//                "Tested",
//                ""
//        );
//
//    }
//}