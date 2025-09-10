package gettingStarted.Actingoffice;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import extensions.commonmethods;
import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
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
public class Test22 {
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

    @Test(description = "Setting the filter")
    @Epic("Sales Module")
    @Feature("Setting the filter")
    @Severity(SeverityLevel.CRITICAL)
    public void Settingthefilter() {
        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
        Allure.step("Navigated to login page");
        driver.manage().window().maximize();
        commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");

        commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");

        WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]")));
        elementLogin.click();
        driver.navigate().to("https://appdev.actingoffice.com/admin");
        Allure.step("Navigated to admin page");
        WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
        elementDashboard.click();

        WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
        elementBookkeeping.click();

        WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
        elementCompany.click();

        WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
        elementInputsButton.click();
        Allure.step("inputs button clicked  successfully");
        WebElement elementSalesButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sales")));
        elementSalesButton.click();
        Allure.step("Sales button clicked  successfully");
        WebElement elementFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[3]/div/div")));
        elementFilter.click();

        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Due']")
        ));
        desiredOption.click();
        Allure.step("filter changed  successfully");
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
//            String path = "screenshots/test22.png";
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
//               test();
////        ExcelLogger.logResult(
////                "Apply filter",
////                "",
////                "",
////                "Apply any status filter",
////                "System will show data accordingly",
////                "System is showing data accordingly",
////                "",
////                "Tested",
////                ""
////        );
//    }}
