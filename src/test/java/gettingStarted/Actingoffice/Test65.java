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

public class Test65 {
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

    @Test(description = "Create payment with advance handling")
    @Epic("Purchases")
    @Feature("Payment")
    @Story("Create payment greater than invoice value and validate advance")
    @Severity(SeverityLevel.CRITICAL)
    public void Purchase_CreatePayment_Test() {
        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");

        Allure.step("Navigated to login page");

        commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");
        commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");
        Allure.step("Entered login credentials");

        WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]")));
        elementLogin.click();
        Allure.step("Login submitted");

        driver.navigate().to("https://appdev.actingoffice.com/admin");
        Allure.step("Navigated to Admin page");

        WebElement dashboard = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
        dashboard.click();
        Allure.step("Dashboard opened");

        WebElement bookkeeping = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
        bookkeeping.click();
        Allure.step("Bookkeeping opened");

        WebElement company = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
        company.click();
        Allure.step("Company selected");

        WebElement inputs = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
        inputs.click();
        Allure.step("Inputs opened");

        WebElement purchases = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchases")));
        purchases.click();
        Allure.step("Purchases module opened");

        WebElement payments = wait.until(ExpectedConditions.elementToBeClickable(By.name("Payments")));
        payments.click();
        Allure.step("Payments section opened");

        WebElement addPayment = wait.until(ExpectedConditions.elementToBeClickable(By.name("Payment")));
        addPayment.click();
        Allure.step("Clicked Add Payment");

        WebElement supplier = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='GG Aegon Limited (Mark Wood)']")));
        supplier.click();
        Allure.step("Selected supplier 'GG Aegon Limited (Mark Wood)'");

        WebElement price = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/form/div/div[1]/div[1]/div[3]/div[3]/div/div/div/input")));
        price.click();
        price.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        price.sendKeys("5000");
        Allure.step("Entered payment amount greater than invoice value");

        WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/form/div/div[1]/div[1]/div[3]/div[1]/div/div/div/div[1]/div[2]/input")));
        accountDropdown.click();
        Allure.step("Account dropdown opened");

        WebElement accountOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Cash in hand - 157/1']")));
        accountOption.click();
        Allure.step("Selected account 'Cash in hand - 157/1'");

        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[4]/button[2]")));
        save.click();
        Allure.step("Payment saved");

        WebElement reports = wait.until(ExpectedConditions.elementToBeClickable(By.id("reports")));
        reports.click();
        Allure.step("Reports opened");

        WebElement supplierBalances = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[4]")));
        supplierBalances.click();
        Allure.step("Supplier balance report opened");

        WebElement companyExpand = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div/div/div/div/div[6]/div/div/div[1]/button")));
        companyExpand.click();

        reports.click();
        Allure.step("Reports opened again");

        WebElement generalLedger = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div/div/div[1]")));
        generalLedger.click();
        Allure.step("General Ledger report opened");
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
        }
    }
}


















//package gettingStarted.Actingoffice;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import extensions.commonmethods;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//public class Test65 {
//    static ExtentReports extent;
//    static ExtentTest test;
//
//    public static void test() {
//        extent = ReportManager.getInstance();
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        test = extent.createTest("Create purchase invoice Test");
//        try {
//            driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
//
//            driver.manage().window().maximize();
//            commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");
//
//            commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");
//
//            WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]")));
//            elementLogin.click();
//            driver.navigate().to("https://appdev.actingoffice.com/admin");
//
//            WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
//            elementDashboard.click();
//
//            WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
//            elementBookkeeping.click();
//
//            WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
//            elementCompany.click();
//
//            WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
//            elementInputsButton.click();
//
//            WebElement elementPurchase = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchases")));
//            elementPurchase.click();
//
//            WebElement elementPayments = wait.until(ExpectedConditions.elementToBeClickable(By.name("Payments")));
//            elementPayments.click();
//
//            WebElement elementAddPayments = wait.until(ExpectedConditions.elementToBeClickable(By.name("Payment")));
//            elementAddPayments.click();
//
//            WebElement supplier = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='GG Aegon Limited (Mark Wood)']")
//            ));
//            supplier .click();
//
//            WebElement price = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/form/div/div[1]/div[1]/div[3]/div[3]/div/div/div/input")
//            ));
//            price.click();
//            price.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//            price.sendKeys("5000");
//
//            WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/form/div/div[1]/div[1]/div[3]/div[1]/div/div/div/div[1]/div[2]/input")
//            ));
//            accountDropdown.click();
//            WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Cash in hand - 157/1']")
//            ));
//            desiredOption.click();
//
//            WebElement save = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[4]/button[2]")
//            ));
//            save.click();
//
//            WebElement reports = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//*[@id=\"reports\"]")
//            ));
//            reports.click();
//
//            WebElement supplierbalances = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[4]")
//            ));
//            supplierbalances.click();
//
//            WebElement company = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//*[@id=\"row5967-3\"]/div/div[1]/button")
//            ));
//            company.click();
//
//            WebElement reports1 = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//*[@id=\"reports\"]")
//            ));
//            reports1.click();
//
//            WebElement generalledger = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div/div/div[1]")
//            ));
//            generalledger.click();
//        } catch (Exception e) {
//            test.fail("Test failed: " + e.getMessage());
//        } finally {
//            extent.flush();
//        }
//    }
//
//    public static void main(String[] args) {
//        //        test();
//        ExcelLogger.logResult(
//                "Purchases/Payment",
//                "Create payment",
//                "The invoices should already be created",
//                "Create a payment against a supplier’s invoice, but make sure the payment amount is more than the actual invoice value. Once done, go ahead and save it.",
//                "Allocate only the exact amount of the invoice—no extra. Any remaining amount should be recorded as an advance to the supplier.\n" +
//                        "Please check whether both the payment and the advance are correctly reflected in the supplier’s statement of accounts and in the supplier balance report.\n" +
//                        "When creating the payment, please make sure the account you selected is showing correctly in the entry. Also, check that it’s properly reflected in the GL and the balance sheet.",
//                "verified",
//                "",
//                "Tested",
//                ""
//        );
//
//    }
//}