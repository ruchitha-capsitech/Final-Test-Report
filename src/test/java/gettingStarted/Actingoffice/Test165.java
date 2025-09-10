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

public class Test165 {

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

    @Test(description = "Add multiple Refunds for Testuser")
    @Epic("Bookkeeping")
    @Feature("Expense Claims")
    @Story("Add Refunds")
    @Severity(SeverityLevel.CRITICAL)
    public void addMultipleRefundsTest() {
        // Login
        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback");
        Allure.step("Navigated to login page");

        commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");
        commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");
        Allure.step("Entered login credentials");

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));
        loginBtn.click();
        Allure.step("Clicked Login button");

        // Navigate to Admin
        driver.navigate().to("https://appdev.actingoffice.com/admin");
        Allure.step("Navigated to Admin page");

        // Open Dashboard → Bookkeeping → Company → Inputs → Expense claims → Refunds
        WebElement dashboard = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
        dashboard.click();
        Allure.step("Dashboard opened");

        WebElement bookkeeping = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
        bookkeeping.click();
        Allure.step("Bookkeeping section opened");

        WebElement company = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
        company.click();
        Allure.step("Company selected");

        WebElement inputsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
        inputsBtn.click();
        Allure.step("Inputs opened");

        WebElement expenseClaims = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Expense claims")));
        expenseClaims.click();
        Allure.step("Expense claims opened");

        WebElement refundTab = wait.until(ExpectedConditions.elementToBeClickable(By.name("Refunds")));
        refundTab.click();
        Allure.step("Refunds tab opened");

        // Add multiple refunds
        for (int i = 0; i <= 1; i++) {
            WebElement addRefundBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("Refund")));
            addRefundBtn.click();
            Allure.step("Clicked Add Refund button #" + (i + 1));

            WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Testuser']")));
            user.click();
            Allure.step("Selected user: Testuser");

            WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[1]/div[1]/div[3]/div[1]/div/div/div/div[1]/div[2]/input")));
            accountDropdown.click();

            WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Cash in hand - 157/1']")));
            desiredOption.click();
            Allure.step("Selected account: Cash in hand - 157/1");

            WebElement note = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[2]/div[1]/div[1]/div/div/div/div/div/input")));
            note.click();
            note.sendKeys("test");
            Allure.step("Entered note: test");

            WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='amount']")));
            amountInput.click();
            amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            amountInput.sendKeys("£100.00");
            Allure.step("Entered amount: £100.00");

            WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[2]/div[2]/div[2]/div[3]/button[2]")));
            saveBtn.click();
            Allure.step("Clicked Save button for refund #" + (i + 1));
        }
    }

    private byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            Allure.addAttachment(
                    result.getStatus() == ITestResult.FAILURE ? "Failure Screenshot" : "Success Screenshot",
                    new ByteArrayInputStream(takeScreenshot())
            );

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
        driver.quit();
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
//public class Test165 {
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
//        WebElement elementRefund = wait.until(ExpectedConditions.elementToBeClickable(By.name("Refunds")));
//        elementRefund.click();
//        for(int i=0;i<=16;i++) {
//            WebElement elementAddRefund = wait.until(ExpectedConditions.elementToBeClickable(By.name("Refund")));
//            elementAddRefund.click();
//
//            WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Testuser']")
//            ));
//            user.click();
//
//            WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[1]/div[1]/div[3]/div[1]/div/div/div/div[1]/div[2]/input")
//            ));
//            accountDropdown.click();
//            WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Cash in hand - 157/1']")
//            ));
//            desiredOption.click();
//
//            WebElement note = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[2]/div[1]/div[1]/div/div/div/div/div/input")
//            ));
//            note.click();
//            note.sendKeys("test");
//
//            WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//*[@placeholder='amount']")
//            ));
//            amountInput.click();
//            amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//            amountInput.sendKeys("£100.00");
//
//            WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[2]/div[2]/div[2]/div[3]/button[2]")
//            ));
//            save.click();
//        }
//    }}