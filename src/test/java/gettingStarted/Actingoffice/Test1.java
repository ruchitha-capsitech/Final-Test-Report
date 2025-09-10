package gettingStarted.Actingoffice;

import extensions.commonmethods;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.time.Duration;

public class Test1 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(Method method) throws Exception {
        VideoRecorder.startRecording(method.getName());

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.manage().window().maximize();
        Allure.step("Browser launched and maximized");
    }

    @Test(description = "Sales Invoice Creation Test")
    @Epic("Sales Module")
    @Feature("Invoice Creation")
    @Story("User creates a sales invoice")

    public void testSalesInvoiceCreation() {
        driver.navigate().to("https://accountsdev.actingoffice.com/login?...");

        commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");
        commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit"))).click();
         Allure.step("successfully loginned");
        driver.navigate().to("https://appdev.actingoffice.com/admin");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a"))).click();
        Allure.step("navigated to company dashboard");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sales"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.name("Invoice"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr/td[2]/div/div/div/div/div[1]/div[2]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']"))).click();


            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Save']]"))).click();
        Allure.step("invoice created successfully");
    }

    private byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {

            if (result.getStatus() == ITestResult.FAILURE) {
                Allure.addAttachment("Failure Screenshot",
                        new ByteArrayInputStream(takeScreenshot()));
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                Allure.addAttachment("Success Screenshot",
                        new ByteArrayInputStream(takeScreenshot()));
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
        }
    }

}





