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

public class Test208 {

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

    @Test(description = "Navigate to Assets → Depreciations and post journal (Test208)")
    @Epic("Bookkeeping")
    @Feature("Assets")
    @Story("Depreciations and Post Journal")
    @Issue("verified in uat. In dev " +
            "Failed to post depreciation")
    @Severity(SeverityLevel.CRITICAL)
    public void openAssetsDepreciationsAndPostJournal() {

        Allure.step("Navigate to login page", () ->
                driver.navigate().to("https://accountsuat.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback")
        );

        Allure.step("Enter email", () ->
                driver.findElement(By.id("Input_Email")).sendKeys("demo.admin@actingoffice.com")
        );

        Allure.step("Enter password", () ->
                commonmethods.entertextmethods(driver, By.id("Input_Password"), "AdminAO@1947")
        );

        Allure.step("Click login button", () -> {
            WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"login-submit\"]")));
            elementLogin.click();
        });

        Allure.step("Navigate to admin page", () ->
                driver.navigate().to("https://appuat.actingoffice.com/admin")
        );

        Allure.step("Click Dashboard", () -> {
            WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div/div/div/div/div[2]/div[1]/div[4]/div/div/button[1]")));
            elementDashboard.click();
        });

        Allure.step("Click Bookkeeping link", () -> {
            WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
            elementBookkeeping.click();
        });

        Allure.step("Click Company link", () -> {
            WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div[3]/div/a")));
            elementCompany.click();
        });

        Allure.step("Click Inputs button", () -> {
            WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
            elementInputsButton.click();
        });

        Allure.step("Click Assets", () -> {
            WebElement elementExpenseclaims = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Assets")));
            elementExpenseclaims.click();
        });

        Allure.step("Click Depreciations", () -> {
            WebElement elementUser = wait.until(ExpectedConditions.elementToBeClickable(By.name("Depreciations")));
            elementUser.click();
        });

        Allure.step("Select depreciation checkbox", () -> {
            WebElement check = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/div[4]")));
            check.click();
        });

        Allure.step("Click Post Journal button", () -> {
            WebElement postjournel = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/button")));
            postjournel.click();
        });
    }

    private byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SUCCESS) {
                Allure.addAttachment("Screenshot", new ByteArrayInputStream(takeScreenshot()));
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
            System.out.println("Could not attach artifacts: " + e.getMessage());
        }

    }
}


























//package gettingStarted.Actingoffice;
//import extensions.commonmethods;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//public class Test208 {
//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        driver.navigate().to("https://accountsuat.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappuat.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappuat.actingoffice.com%26acr_values%3Dtenant%253Aappuat.actingoffice.com%26state%3DP0TrCqetlD3Frb7S%26nonce%3D3yAJGonYS8rc%26code_challenge%3DK-CWwVztcxdOk3nlJ2i50KVZFyjQmkNuDW1Jys-l_wg%26code_challenge_method%3DS256");
//        driver.manage().window().maximize();
//        driver.findElement(By.id("Input_Email")).sendKeys("demo.admin@actingoffice.com");
//        driver.findElement(By.id("Input_Password")).sendKeys("AdminAO@1947");
//
//        commonmethods.entertextmethods(driver, By.id("Input_Password"), "AdminAO@1947");
//
//        WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]")));
//        elementLogin.click();
//        driver.navigate().to("https://appuat.actingoffice.com/admin");
//
//        WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div/div[2]/div[1]/div[4]/div/div/button[1]")));
//        elementDashboard.click();
//
//        WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
//        elementBookkeeping.click();
//
//        WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div[3]/div/a")));
//        elementCompany.click();
//
//        WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
//        elementInputsButton.click();
//
//        WebElement elementExpenseclaims = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Assets")));
//        elementExpenseclaims.click();
//
//        WebElement elementUser = wait.until(ExpectedConditions.elementToBeClickable(By.name("Depreciations")));
//        elementUser.click();
//
//        WebElement check = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/div[4]")));
//       check.click();
//
//        WebElement postjournel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/button")));
//        postjournel.click();
//
//    }}