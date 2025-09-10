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
public class Test32 {
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

    @Test(description = "Sending email to client")
    @Epic("Sales Module")
    @Feature("Sending email to client")
    @Severity(SeverityLevel.CRITICAL)
    public void Sending_email_to_client() {
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

        WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
        elementInputsButton.click();
        Allure.step("inputs button clicked  successfully");
        WebElement elementSalesButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sales")));
        elementSalesButton.click();
        Allure.step("Sales button clicked  successfully");
        WebElement elementDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[9]/div/div[4]/div/button")));
        elementDropdown.click();
        Allure.step("Dropdown button clicked  successfully");
        WebElement elementEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/div/div/ul/li[4]/button")));
        elementEmail.click();
        Allure.step("Email button clicked  successfully");
        WebElement elementSend = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div[2]/div/div[3]/div/div/div/div[2]/div/div/span/button[1]")));
        elementSend.click();
        Allure.step("Send button clicked  successfully");
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
//            String path = "screenshots/test32.png";
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
//    public static void main(String [] args) throws InterruptedException {
//                test();
////        ExcelLogger.logResult(
////                "Input/Sales",
////                "",
////                "Invoice created",
////                "Click on the three dots to send an email; a wizard will open where you can review the email content, and once satisfied, click on Save to complete the process.",
////                "Email will sent to the client",
////                "When clicked on save the email is not being sent",
////                "",
////                "Tested",
////                ""
////        );
//    }
//}
