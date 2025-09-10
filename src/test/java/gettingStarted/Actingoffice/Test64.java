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

public class Test64 {
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

    @Test(description = "Create Purchase Order and validate prefix/suffix change")
    @Epic("Purchases")
    @Feature("Purchase Order")
    @Story("Create purchase order and validate PO number prefix/suffix update")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("the prefix/suffix  changes are getting updated from the next estimate creation.")
    public void Purchase_CreatePurchaseOrder_Test() {
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

        WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
        elementDashboard.click();
        Allure.step("Dashboard opened");

        WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
        elementBookkeeping.click();
        Allure.step("Bookkeeping opened");

        WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
        elementCompany.click();
        Allure.step("Company selected");

        WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
        elementInputsButton.click();
        Allure.step("Inputs opened");

        WebElement elementPurchase = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchases")));
        elementPurchase.click();
        Allure.step("Purchases module opened");

        WebElement elementPurchaseOrders = wait.until(ExpectedConditions.elementToBeClickable(By.name("Purchase orders")));
        elementPurchaseOrders.click();
        Allure.step("Purchase Orders section opened");

        WebElement elementAddPurchaseOrder = wait.until(ExpectedConditions.elementToBeClickable(By.name("Purchase order")));
        elementAddPurchaseOrder.click();
        Allure.step("Clicked Add Purchase Order");

        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")));
        customer.click();
        Allure.step("Selected customer 'Test2'");

        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr[1]/td[2]/div/div/div/div/div[1]/div[2]")));
        item.click();
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")));
        option.click();
        Allure.step("Selected item 'Item'");

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[text()='Save']]")));
        saveButton.click();
        Allure.step("Purchase Order saved");

        WebElement settings = wait.until(ExpectedConditions.elementToBeClickable(By.id("Settings")));
        settings.click();
        Allure.step("Opened Settings");

        WebElement customize = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/button[2]")));
        customize.click();
        Allure.step("Opened Customize section");

        WebElement purchases = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/table/thead/th[7]/div")));
        purchases.click();
        Allure.step("Opened Purchases customization");

        WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/table[2]/tbody/tr[2]/td[7]/div/button")));
        edit.click();
        Allure.step("Clicked Edit for PO Number settings");

        WebElement change = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/table[2]/tbody/tr[2]/td[3]/div/div[2]/div/div/input")));
        change.click();
        change.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        change.sendKeys("PuO");
        Allure.step("Changed  prefix ");

        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/table[2]/tbody/tr[2]/td[7]/div/div/button[1]")));
        save.click();
        Allure.step("Saved PO number settings");

        WebElement inputsButtonAgain = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
        inputsButtonAgain.click();
        Allure.step("Opened Inputs again");

        WebElement purchaseAgain = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchases")));
        purchaseAgain.click();
        Allure.step("Re-opened Purchases module");

        WebElement purchaseOrdersAgain = wait.until(ExpectedConditions.elementToBeClickable(By.name("Purchase orders")));
        purchaseOrdersAgain.click();
        Allure.step("Opened Purchase Orders again to validate updated prefix/suffix");
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
//public class Test64 {
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
//            By inputsButton = By.id("inputs");
//            WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(inputsButton));
//            elementInputsButton.click();
//
//            By PurchaseButton = By.linkText("Purchases");
//            WebElement elementPurchase = wait.until(ExpectedConditions.elementToBeClickable(PurchaseButton));
//            elementPurchase.click();
//
//            By Purchaseorders = By.name("Purchase orders");
//            WebElement elementPurchaseorders = wait.until(ExpectedConditions.elementToBeClickable(Purchaseorders));
//            elementPurchaseorders.click();
//
//            By addPurchaseorder = By.name("Purchase order");
//            WebElement elementaddPurchaseorder = wait.until(ExpectedConditions.elementToBeClickable(addPurchaseorder));
//            elementaddPurchaseorder.click();
//
//            WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")
//            ));
//            customer.click();
//
//            WebElement Item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr[1]/td[2]/div/div/div/div/div[1]/div[2]")));
//            Item.click();
//            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")
//            ));
//            option.click();
//
//            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//button[.//span[text()='Save']]")
//            ));
//            saveButton.click();
//
//            WebElement settings = wait.until(ExpectedConditions.elementToBeClickable(By.id("Settings")));
//            settings.click();
//
//            WebElement customize = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/button[2]")));
//            customize.click();
//
//            WebElement purchases = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/table/thead/th[7]/div")));
//            purchases.click();
//
//            WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/table[2]/tbody/tr[2]/td[7]/div/button")));
//            edit.click();
//
//            WebElement change = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/table[2]/tbody/tr[2]/td[3]/div/div[2]/div/div/input")));
//            change.click();
//            change.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//            change.sendKeys("PuO");
//
//            WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/table[2]/tbody/tr[2]/td[7]/div/div/button[1]")));
//            save.click();
//
//            WebElement InputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
//            InputsButton.click();
//
//
//            WebElement Purchase = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchases")));
//            Purchase.click();
//
//            WebElement Purchaseorders1 = wait.until(ExpectedConditions.elementToBeClickable(By.name("Purchase orders")));
//            Purchaseorders1.click();
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
//                "Purchases/Purchase order",
//                "Create purchase order",
//                "",
//                "1. Create an estimate.\n" +
//                        "2. Change the P.O. number by going to company settings, then enter the details in the estimate and save.",
//                "Please check whether the prefix or suffix you changed has been updated in the estimate number or not.",
//                "the prefix/suffix  changes are getting updated from the next estimate creation.",
//                "",
//                "Tested",
//                ""
//        );
//
//    }
//}