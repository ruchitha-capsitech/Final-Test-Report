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

public class Test142 {

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

    @Test(description = "Doing transactions in the vat return period")
    @Epic("Vat Return Module")
    @Feature("Transactions during vat return")
    @Story("Doing transactions in the vat return period")
    @Severity(SeverityLevel.CRITICAL)
    public void Transactions_during_vat_return() {

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

        WebElement banking = wait.until(ExpectedConditions.elementToBeClickable(By.id("banking")));
        banking.click();
        Allure.step("Banking section opened");

        WebElement account = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/label[1]")));
        account.click();
        Allure.step("Account opened");

        WebElement addtransaction = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[2]/div/button[1]")));
        addtransaction.click();
        Allure.step("adding transaction");

        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/form/div/div/table/tbody/tr/td[1]/div/div/div/div/div/input")));
        date.click();
        date.sendKeys("08/02/2017");
        Allure.step("date entered");

        WebElement moneyin = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/form/div/div/table/tbody/tr[1]/td[3]/div/div/div/input")));
        moneyin.click();
        moneyin.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        moneyin.sendKeys("10000");
        Allure.step("money in entered");

        WebElement description = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/form/div/div/table/tbody/tr/td[2]/div/div/div/input")));
        description.click();
        description.sendKeys("tester");
        Allure.step("description entered");

        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/button[2]")));
        save.click();
        Allure.step("save button clicked");

        WebElement elementVATreturns = wait.until(ExpectedConditions.elementToBeClickable(By.id("vatreturn")));
        elementVATreturns.click();
        Allure.step("VAT returns button clicked  successfully");

        WebElement elementVATreturn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[1]/button")));
        elementVATreturn.click();
        Allure.step("VAT returns selected  successfully");
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







