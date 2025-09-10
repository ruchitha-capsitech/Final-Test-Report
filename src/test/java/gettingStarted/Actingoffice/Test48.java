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

public class Test48 {
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

    @Test(description = "Create Reimbursement Test")
    @Epic("Bookkeeping")
    @Feature("Expense Claims")
    @Severity(SeverityLevel.CRITICAL)
    public void Create_Reimbursement_Test() {
        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
        Allure.step("Navigated to login page");

        commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");
        Allure.step("Entered email");

        commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");
        Allure.step("Entered password");

        WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));
        elementLogin.click();
        Allure.step("Clicked on login button");

        driver.navigate().to("https://appdev.actingoffice.com/admin");
        Allure.step("Navigated to Admin page");

        WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
        elementDashboard.click();
        Allure.step("Clicked Dashboard");

        WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
        elementBookkeeping.click();
        Allure.step("Clicked Bookkeeping");

        WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
        elementCompany.click();
        Allure.step("Selected Company");

        WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
        elementInputsButton.click();
        Allure.step("Clicked Inputs");

        WebElement elementExpenseClaimsButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Expense claims")));
        elementExpenseClaimsButton.click();
        Allure.step("Opened Expense Claims");

        WebElement elementReimbursements = wait.until(ExpectedConditions.elementToBeClickable(By.name("Reimbursements")));
        elementReimbursements.click();
        Allure.step("Opened Reimbursements tab");

        WebElement elementReimbursement = wait.until(ExpectedConditions.elementToBeClickable(By.name("Reimbursement")));
        elementReimbursement.click();
        Allure.step("Clicked Add Reimbursement");

        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Testuser']")
        ));
        customer.click();
        Allure.step("Selected User 'TestUser'");

        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='amount']")));
        amountInput.click();
        amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        amountInput.sendKeys("£800.00");
        Allure.step("Entered Amount £800.00");

        WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[1]/div[1]/div[3]/div[1]/div/div/div/div[1]/div[2]/input")
        ));
        accountDropdown.click();

        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Cash in hand - 157/1']")
        ));
        desiredOption.click();
        Allure.step("Selected Account: Cash in hand - 157/1");

        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[2]/div[2]/div[2]/div[3]/button[2]")
        ));
        save.click();
        Allure.step("Clicked Save Reimbursement");

        Allure.step("Reimbursement created successfully");
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
            }
        }
    }
}



//package gettingStarted.Actingoffice;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import extensions.commonmethods;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.io.File;
//import java.time.Duration;
//public class          Test48 {
//    static ExtentReports extent;
//    static ExtentTest test;
//    public static void test() {
//        extent = ReportManager.getInstance();
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        test = extent.createTest("Create Reimbersement Test");
//        try {
//        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
//            test.info("Navigated to login page");
//            driver.manage().window().maximize();
//        commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");
//
//        commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");
//
//        WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]")));
//        elementLogin.click();
//        driver.navigate().to("https://appdev.actingoffice.com/admin");
//
//        WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
//        elementDashboard.click();
//
//        WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
//        elementBookkeeping.click();
//
//        WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
//        elementCompany.click();
//
//        WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
//        elementInputsButton.click();
//
//        WebElement elementExpenseClaimsButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Expense claims")));
//        elementExpenseClaimsButton.click();
//
//        WebElement elementReimbursements = wait.until(ExpectedConditions.elementToBeClickable(By.name("Reimbursements")));
//        elementReimbursements.click();
//
//        WebElement elementReimbursement = wait.until(ExpectedConditions.elementToBeClickable(By.name("Reimbursement")));
//        elementReimbursement.click();
//
//        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='TestUser']")
//        ));
//        customer.click();
//
//        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//*[@placeholder='amount']")
//        ));
//        amountInput.click();
//        amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//        amountInput.sendKeys("£800.00");
//
//        WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[1]/div[1]/div[3]/div[1]/div/div/div/div[1]/div[2]/input")
//        ));
//        accountDropdown.click();
//        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Cash in hand - 157/1']")
//        ));
//        desiredOption.click();
//
//        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[2]/div[2]/div[2]/div[3]/button[2]")
//        ));
//        save.click();
//            String path = "screenshots/test48.png";
//            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(screenshot, new File(path));
//            test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
//        }
//        catch (Exception e) {
//            test.fail("Test failed: " + e.getMessage());
//        }
//        finally {
//            extent.flush();
//        }
//    }
//    public static void main(String[] args) {
//                test();
////        ExcelLogger.logResult(
////                "Expense claim",
////                "Create Reimbersement",
////                "It can be prepared with or without linking with expense claim.",
////                "Click on the 'Add reimbersement' icon, Select user if already created, and if not create new user. Now, select the Account head, method and amount. Finaly, click on 'Save'.",
////                "A reimbersement has been created in connection with the Expense claim, and Expense claim due amount is updated. The corresponding entry is posted to the report section. If money reimbersement amount is more then Expenses claim then same is retained as advance to user whcih is an un-allocated amount.",
////                "verified",
////                "",
////                "Tested",
////                ""
////        );
//    }}