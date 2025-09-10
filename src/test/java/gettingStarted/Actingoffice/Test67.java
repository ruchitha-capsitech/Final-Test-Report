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

public class Test67 {
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

    @Test(description = "Create and delete supplier, create invoice for supplier")
    @Epic("Purchases")
    @Feature("Supplier & Invoice")
    @Story("Add supplier, delete supplier, create invoice")
    @Severity(SeverityLevel.BLOCKER)
    public void Purchase_SupplierAndInvoice_Test() {
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

        WebElement elementSupplier = wait.until(ExpectedConditions.elementToBeClickable(By.name("Suppliers")));
        elementSupplier.click();
        Allure.step("Suppliers section opened");

        WebElement elementAddSupplier = wait.until(ExpectedConditions.elementToBeClickable(By.name("Supplier")));
        elementAddSupplier.click();
        Allure.step("Clicked Add Supplier");

        WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/form/div/div[1]/div[1]/div/div[1]/div/div[1]/div/div[1]/div/div/input")));
        Name.click();
        Name.sendKeys("A LIMITED");
        Allure.step("Entered supplier name 'A LIMITED'");

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[text()='Save']]")));
        saveButton.click();
        Allure.step("Supplier saved");

        driver.findElement(By.xpath("//*[@id=\"btn-btnDelete\"]")).click();
        Allure.step("Clicked delete supplier button");

        WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/button[2]")));
        yes.click();
        Allure.step("Confirmed supplier deletion");

        WebElement elementAddSupplier2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("Supplier")));
        elementAddSupplier2.click();
        Allure.step("Clicked Add Supplier again");

        WebElement Name2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/form/div/div[1]/div[1]/div/div[1]/div/div[1]/div/div[1]/div/div/input")));
        Name2.click();
        Name2.sendKeys("A LIMITED");


        WebElement saveButton2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[text()='Save']]")));
        saveButton2.click();
        Allure.step("Supplier saved ");

        WebElement elementInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Invoices")));
        elementInvoiceButton.click();
        Allure.step("Invoices section opened");

        WebElement elementAddInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Invoice")));
        elementAddInvoiceButton.click();
        Allure.step("Clicked Add Invoice");

        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='A LIMITED']")));
        customer.click();
        Allure.step("Selected supplier 'A LIMITED' for invoice");

        WebElement Item = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr/td[2]/div/div/div/div/div[1]/div[2]")));
        Item.click();
        Allure.step("Item dropdown opened");

        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")));
        option.click();
        Allure.step("Selected 'Item'");

        WebElement saveButton1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[text()='Save']]")));
        saveButton1.click();
        Allure.step("Invoice saved");

        WebElement elementSupplier1 = wait.until(ExpectedConditions.elementToBeClickable(By.name("Suppliers")));
        elementSupplier1.click();
        Allure.step("Navigated back to Suppliers");

        driver.findElement(By.xpath("//*[@id=\"btn-btnDelete\"]")).click();
        Allure.step("Clicked delete supplier button again");

        WebElement yes1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/button[2]")));
        yes1.click();
        Allure.step("Confirmed supplier deletion after invoice");
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
//public class Test67 {
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
//            WebElement elementSupplier = wait.until(ExpectedConditions.elementToBeClickable(By.name("Suppliers")));
//            elementSupplier.click();
//
//            WebElement elementAddSupplier = wait.until(ExpectedConditions.elementToBeClickable(By.name("Supplier")));
//            elementAddSupplier.click();
//
//            WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/form/div/div[1]/div[1]/div/div[1]/div/div[1]/div/div[1]/div/div/input")
//            ));
//            Name.click();
//            Name.sendKeys("A LIMITED");
//
//            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//button[.//span[text()='Save']]")
//            ));
//            saveButton.click();
//            driver.findElement(By.xpath("//*[@id=\"btn-btnDelete\"]")).click();
//            WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/button[2]")
//            ));
//            yes.click();
//
//            WebElement elementAddSupplier2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("Supplier")));
//            elementAddSupplier2.click();
//
//            WebElement Name2 = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/form/div/div[1]/div[1]/div/div[1]/div/div[1]/div/div[1]/div/div/input")
//            ));
//            Name2.click();
//            Name2.sendKeys("A LIMITED");
//
//            WebElement saveButton2 = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//button[.//span[text()='Save']]")
//            ));
//            saveButton2.click();
//
//            By InvoiceButton = By.name("Invoices");
//            WebElement elementInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(InvoiceButton));
//            elementInvoiceButton.click();
//
//            By addInvoiceButton = By.name("Invoice");
//            WebElement elementAddInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(addInvoiceButton));
//            elementAddInvoiceButton.click();
//
//            WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='A LIMITED']")
//            ));
//            customer.click();
//
//            WebElement Item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr/td[2]/div/div/div/div/div[1]/div[2]")));
//            Item.click();
//            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")
//            ));
//            option.click();
//
//            WebElement saveButton1 = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//button[.//span[text()='Save']]")
//            ));
//            saveButton1.click();
//            WebElement elementSupplier1 = wait.until(ExpectedConditions.elementToBeClickable(By.name("Suppliers")));
//            elementSupplier1.click();
//            driver.findElement(By.xpath("//*[@id=\"btn-btnDelete\"]")).click();
//            WebElement yes1 = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/button[2]")
//            ));
//            yes1.click();
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
//                "Purchases/Supplier",
//                "Add a supplier",
//                "",
//                "1. Please add a new supplier by entering all the required details.\n" +
//                        "2. Edit the supplier details, change the information, and save it again.",
//                "Delete the supplier only if there are no transactions linked to them — it should get deleted easily. But if there are any transactions, the supplier should not be deletable, and the delete icon should be disabled.",
//                "verified",
//                "",
//                "Tested",
//                ""
//        );
//
//    }
//}