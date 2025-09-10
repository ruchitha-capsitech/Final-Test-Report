package gettingStarted.Actingoffice;

import extensions.commonmethods;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.time.Duration;
public class Test124 {
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

    @Test(description = "Adding the vat return and sending it for review")
    @Epic("Vat Return Module")
    @Feature("Adding vat return ")
    @Severity(SeverityLevel.CRITICAL)
    public void Adding_the_vat_return() {
        driver.navigate().to("https://accountsuat.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappuat.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappuat.actingoffice.com%26acr_values%3Dtenant%253Aappuat.actingoffice.com%26state%3DP0TrCqetlD3Frb7S%26nonce%3D3yAJGonYS8rc%26code_challenge%3DK-CWwVztcxdOk3nlJ2i50KVZFyjQmkNuDW1Jys-l_wg%26code_challenge_method%3DS256");
        driver.manage().window().maximize();
        driver.findElement(By.id("Input_Email")).sendKeys("demo.admin@actingoffice.com");
        driver.findElement(By.id("Input_Password")).sendKeys("AdminAO@1947");

        commonmethods.entertextmethods(driver, By.id("Input_Password"), "AdminAO@1947");

        WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]")));
        elementLogin.click();
        driver.navigate().to("https://appuat.actingoffice.com/admin");

        WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div/div[2]/div[1]/div[4]/div/div/button[1]")));
        elementDashboard.click();

        WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
        elementBookkeeping.click();

        WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div[3]/div/a")));
        elementCompany.click();

        WebElement elementVATreturns = wait.until(ExpectedConditions.elementToBeClickable(By.id("vatreturn")));
        elementVATreturns.click();
        Allure.step("VAT returns button clicked  successfully");

        WebElement addvat = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/div/div/div/div[1]/button")));
        addvat.click();
        Allure.step("add vat return button clicked  successfully");

        addvat.sendKeys(Keys.ENTER);
        Allure.step("obligation selected   successfully");

        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/button[2]")));
        save.click();
        Allure.step("save button clicked  successfully");

        WebElement outputvat = wait.until(ExpectedConditions.elementToBeClickable(By.name("Output VAT")));
        outputvat.click();
        Allure.step("output vat button clicked  successfully");

        WebElement inputvat = wait.until(ExpectedConditions.elementToBeClickable(By.name("Input VAT")));
        inputvat.click();
        Allure.step("input vat button clicked  successfully");

        WebElement vatreturnreport = wait.until(ExpectedConditions.elementToBeClickable(By.name("VAT return report")));
        vatreturnreport.click();
        Allure.step("vat return report button clicked  successfully");

        WebElement send = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[2]/form/div/div[2]/div/div/div[3]/div/div/div/div[2]/div/button[2]")));
        send.click();
        Allure.step("send button clicked  successfully");

        WebElement userdropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div/div[1]/div/div/div/div[1]/div[2]/input")));
        userdropdown.click();
        userdropdown.sendKeys("UAT Admin (uat@actingoffice.com)");
        userdropdown.sendKeys(Keys.ENTER);
        Allure.step("user selected   successfully");

        WebElement addattachments = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div/div[3]/div[2]/div/label/div")));
        addattachments.click();
        Allure.step("add attachments button clicked  successfully");

        WebElement save1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/button[2]")));
        save1.click();
        Allure.step("save button clicked  successfully");
    }  private byte[] takeScreenshot() {
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
