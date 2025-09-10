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

public class Test168 {

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

    @Test(description = "Add a new User")
    @Epic("Bookkeeping")
    @Feature("Users")
    @Story("Add User")
    @Severity(SeverityLevel.CRITICAL)
    public void addUserTest() {
        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback");
        Allure.step("Navigated to login page");

        commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");
        commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");
        Allure.step("Entered login credentials");

        WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]")));
        elementLogin.click(); // kept click as is
        Allure.step("Clicked Login button");

        driver.navigate().to("https://appdev.actingoffice.com/admin");
        Allure.step("Navigated to Admin page");

        WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
        elementDashboard.click(); // kept click as is
        Allure.step("Dashboard opened");

        WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
        elementBookkeeping.click(); // kept click as is
        Allure.step("Bookkeeping section opened");

        WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
        elementCompany.click(); // kept click as is
        Allure.step("Company selected");

        WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
        elementInputsButton.click(); // kept click as is
        Allure.step("Inputs opened");

        WebElement elementExpenseclaims = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Expense claims")));
        elementExpenseclaims.click(); // kept click as is
        Allure.step("Expense claims opened");

        WebElement elementUser = wait.until(ExpectedConditions.elementToBeClickable(By.name("Users")));
        elementUser.click(); // kept click as is
        Allure.step("Users tab opened");

        WebElement elementAddUser = wait.until(ExpectedConditions.elementToBeClickable(By.name("User")));
        elementAddUser.click(); // kept click as is
        Allure.step("Add User clicked");

        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[1]/div[2]/div/div/div[2]/div/div/input")));
        name.click(); // kept click as is

        WebElement fname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Mrs']")));
        fname.click(); // kept click as is

        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'ms-TextField-field')][1]")));
        firstName.sendKeys("testing-user1");

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[2]/div[1]/div/div/div/div/div/div/div/input")));
        email.click(); // kept click as is
        email.sendKeys("testing-user-gmail.com");

        WebElement phoneno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[2]/div[2]/div/div/div/div/div/input")));
        phoneno.click(); // kept click as is
        phoneno.sendKeys("1234567890");

        WebElement dob = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[2]/div[3]/div/div/div/div/div/input")));
        dob.click(); // kept click as is
        dob.sendKeys("04/08/2002");

        WebElement nino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[3]/div[1]/div[2]/div/div/input")));
        nino.click(); // kept click as is
        nino.sendKeys("AB 123456 C");

        WebElement UTR = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[3]/div[2]/div/div/div/input")));
        UTR.click(); // kept click as is
        UTR.sendKeys("1234");

        WebElement mandatory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[4]/div/div/label/div")));
        mandatory.click(); // kept click as is

        WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/button[2]")));
        save.click(); // kept click as is
        Allure.step("User saved successfully");
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
//public class Test168 {
//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
//        driver.manage().window().maximize();
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
//        WebElement elementExpenseclaims = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Expense claims")));
//        elementExpenseclaims.click();
//
//        WebElement elementUser = wait.until(ExpectedConditions.elementToBeClickable(By.name("Users")));
//        elementUser.click();
//
//        WebElement elementAddUser = wait.until(ExpectedConditions.elementToBeClickable(By.name("User")));
//        elementAddUser.click();
//
//        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[1]/div[2]/div/div/div[2]/div/div/input")));
//        name.click();
//
//        WebElement fname = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Mrs']")
//        ));
//        fname.click();
//
//        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//input[contains(@class,'ms-TextField-field')][1]")
//        ));
//        firstName.sendKeys("testing-user1");
//
//        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[2]/div[1]/div/div/div/div/div/div/div/input")
//        ));
//        email.click();
//        email.sendKeys("testing-user-gmail.com");
//
//        WebElement phoneno = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[2]/div[2]/div/div/div/div/div/input")
//        ));
//        phoneno.click();
//        phoneno.sendKeys("1234567890");
//
//        WebElement dob = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[2]/div[3]/div/div/div/div/div/input")
//        ));
//        dob.click();
//        dob.sendKeys("04/08/2002");
//
//        WebElement nino = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[3]/div[1]/div[2]/div/div/input")
//        ));
//        nino.click();
//        nino.sendKeys("AB 123456 C");
//
//        WebElement UTR = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[3]/div[2]/div/div/div/input")
//        ));
//        UTR.click();
//        UTR.sendKeys("1234");
//
//        WebElement mandatory = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div/div[4]/div/div/label/div")
//        ));
//        mandatory.click();
//
//        WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/button[2]")
//        ));
//        save.click();
//    }
//}