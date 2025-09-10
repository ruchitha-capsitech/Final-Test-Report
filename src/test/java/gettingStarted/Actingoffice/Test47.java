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

public class Test47 {
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

    @Test(description = "Create Expense Claim Test")
    @Epic("Bookkeeping")
    @Feature("Expense Claims")
    @Severity(SeverityLevel.CRITICAL)
    public void Create_ExpenseClaim_Test() {
        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com");
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

        WebElement elementExpenseClaimButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Expense")));
        elementExpenseClaimButton.click();
        Allure.step("Clicked Add Expense Claim");

        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[1]/div[1]/div/div/div[1]/div[2]/input")));
        user.sendKeys("testUser3");
        Allure.step("Entered User name");

        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option')]")));
        customer.click();
        Allure.step("Selected User option");

        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[3]/div/div[2]/div[2]/div[3]/div/button[2]")));
        save.click();
        Allure.step("Clicked Save User");

        WebElement remarks = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/input")));
        remarks.click();
        remarks.sendKeys("testUser remarks");
        Allure.step("Entered Remarks");

        WebElement billNo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div/div/div/input")
        ));
        billNo.click();
        billNo.sendKeys("1");
        Allure.step("Entered Bill No");

        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[3]/div/div/div/input")
        ));
        description.click();
        description.sendKeys("testUser description");
        Allure.step("Entered Description");

        WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[4]/div/div/div/div[1]/div[2]/input")
        ));
        accountDropdown.click();
        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Opening stock - 2/1']")
        ));
        desiredOption.click();
        Allure.step("Selected Account option");

        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[5]/div/div/div/input")
            ));
            amountInput.click();
            amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            amountInput.sendKeys("£600.00");
        Allure.step("Entered Amount");

        WebElement vat = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[6]/div/div/div/div[1]/div[2]/input")));
        vat.click();
        Allure.step("Opened VAT dropdown");

        WebElement vatOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'rs-option') and normalize-space()='20%']")));
        vatOption.click();
        Allure.step("Selected VAT 20%");

        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[4]/div[2]/div[3]/button[2]")));
        saveBtn.click();
        Allure.step("Clicked Save Expense Claim");

        Allure.step("Expense Claim created successfully");
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
//public class Test47 {
//    static ExtentReports extent;
//    static ExtentTest test;
//    public static void test() {
//        extent = ReportManager.getInstance();
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        test = extent.createTest("Create Expense claim Test");
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
//        WebElement elementExpenseClaimButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Expense")));
//        elementExpenseClaimButton.click();
//
//        WebElement User = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[1]/div[1]/div/div/div[1]/div[2]/input")
//        ));
//        User.click();
//        User.sendKeys("testUser");
//
//        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option')]")
//        ));
//        customer.click();
//
//        WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div[2]/div/div/div/div/div[3]/div/div[2]/div[2]/div[3]/div/button[2]")
//        ));
//        save.click();
//
//        WebElement remarks = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/input")
//        ));
//        remarks.click();
//        remarks.sendKeys("testUser");
//
//        WebElement billNo = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div/div/div/input")
//        ));
//        billNo.click();
//        billNo.sendKeys("1");
//
//        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[3]/div/div/div/input")
//        ));
//        description.click();
//        description.sendKeys("testUser description");
//
//        WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[4]/div/div/div/div[1]/div[2]/input")
//        ));
//        accountDropdown.click();
//        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Opening stock - 2/1']")
//        ));
//        desiredOption.click();
//
//        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[5]/div/div/div/input")
//            ));
//            amountInput.click();
//            amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//            amountInput.sendKeys("£600.00");
//
//        WebElement vat = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[6]/div/div/div/div[1]/div[2]/input")
//        ));
//        vat.click();
//        WebElement vatOption = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[contains(@class,'rs-option') and normalize-space()='20%']")
//        ));
//        vatOption.click();
//
//        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[4]/div[2]/div[3]/button[2]")
//        ));
//        saveBtn.click();
//            String path = "screenshots/test47.png";
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
//              test();
////        ExcelLogger.logResult(
////                "Expense claim",
////                "Create Expense claim",
////                "",
////                "Click on the 'Add Expense' icon, create a new User. The date will default to today's date. Then, enter the expense need to be claimed- Base amount, VAT rate. Now, click on 'Save'.",
////                "An Expense claim reference is now created, and the corresponding entry is posted to the report section.",
////                "verified",
////                "",
////                "Tested",
////                ""
////        );
//    }}