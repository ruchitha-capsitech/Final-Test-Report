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
public class Test35 {
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

    @Test(description = "Verifying the cancel option")
    @Epic("Sales Module")
    @Feature("Cancel option")
    @Severity(SeverityLevel.CRITICAL)
    public void Verifying_the_cancel_option() {
        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
        Allure.step("Browser launched and maximized");
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
        WebElement elementItems = wait.until(ExpectedConditions.elementToBeClickable(By.name("Items")));
        elementItems.click();
        Allure.step("Item button clicked  successfully");
        WebElement elementAddItems = wait.until(ExpectedConditions.elementToBeClickable(By.name("Item")));
        elementAddItems.click();
        Allure.step("add Item button clicked  successfully");
        WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[1]/div/div[1]/div/div/input")
        ));
        Name.click();
        Name.sendKeys("TestItem1");
        Allure.step("item name entered  successfully");
        WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/button[1]")
        ));
        cancel.click();
        Allure.step(" cancel button clicked  successfully");
        WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div[2]/button[2]")
        ));
        yes.click();
        Allure.step("yes button clicked  successfully");
        WebElement elementCustomers = wait.until(ExpectedConditions.elementToBeClickable(By.name("Customers")));
        elementCustomers.click();
        Allure.step("Customers button clicked  successfully");
        WebElement elementAddCustomers = wait.until(ExpectedConditions.elementToBeClickable(By.name("Customer")));
        elementAddCustomers.click();
        Allure.step("Add Customers button clicked  successfully");
        WebElement CustomerName = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/div/div[1]/div[1]/div/div[1]/div/div[1]/div/div[1]/div/div/input")
        ));
        CustomerName.click();
        CustomerName.sendKeys("A1 LIMITED");
        Allure.step("customer name entered successfully");
        WebElement cancel1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/button[1]")
        ));
        cancel1.click();
        Allure.step(" cancel button clicked  successfully");
        WebElement yes1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div[2]/button[2]")
        ));
        yes1.click();
        Allure.step("yes button clicked  successfully");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Receipts"))).click();
        Allure.step("Receipt button clicked  successfully");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Receipt"))).click();
        Allure.step("add Receipt button clicked  successfully");
        WebElement RecievedFrom = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test1']")
        ));
        RecievedFrom.click();
        Allure.step("customer selected  successfully");
        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@placeholder='amount']")
        ));
        amountInput.click();
        amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        amountInput.sendKeys("£600.00");
        Allure.step("amount entered  successfully");
        WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"bk-doc-edit\"]/div[2]/form/div/div[1]/div[1]/div[3]/div[1]/div/div/div/div[2]/div")
        ));
        accountDropdown.click();
        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Cash in hand - 157/1']")
        ));
        desiredOption.click();
        Allure.step("account selected  successfully");
        WebElement cancel2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[4]/button[1]")
        ));
        cancel2.click();
        Allure.step(" cancel button clicked  successfully");
        WebElement yes2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/button[2]")
        ));
        yes2.click();
        Allure.step("yes button clicked  successfully");
        WebElement elementEstimates = wait.until(ExpectedConditions.elementToBeClickable(By.name("Estimates")));
        elementEstimates.click();
        Allure.step("Estimate button clicked  successfully");
        WebElement elementEstimate = wait.until(ExpectedConditions.elementToBeClickable(By.name("Estimate")));
        elementEstimate.click();
        Allure.step("add Estimate button clicked  successfully");
        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test1']")
        ));
        customer.click();
        Allure.step("customer selected  successfully");
        WebElement Item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr[1]/td[2]/div/div/div/div/div[1]/div[2]")));
        Item.click();
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")
        ));
        option.click();
        Allure.step("item selected  successfully");
        WebElement cancel3 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[3]/div/div[3]/div[2]/div[2]/div[3]/button[1]")
        ));
        cancel3.click();
        Allure.step(" cancel button clicked  successfully");
        WebElement yes3 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/button[2]")
        ));
        yes3.click();
        Allure.step("yes button clicked  successfully");
        WebElement elementCreditNotesButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Credit notes")));
        elementCreditNotesButton.click();
        Allure.step("Credit Note button clicked  successfully");
        WebElement elementAddCreditNote = wait.until(ExpectedConditions.elementToBeClickable( By.name("Credit note")));
        elementAddCreditNote.click();
        Allure.step("Add Credit Note button clicked  successfully");
        WebElement customer1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")
        ));
        customer1.click();
        Allure.step(" customer selected   successfully");
        WebElement InvoiceRefNo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div/div[2]")
        ));
        InvoiceRefNo.click();

        WebElement invoiceNo = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'rs-option') and normalize-space()='INV-0048']")
        ));
        invoiceNo.click();
        Allure.step(" invoiceNo selected   successfully");
        WebElement cancel4 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/form/div/div[3]/div/div[4]/div[2]/div[2]/div[3]/button[1]")
        ));
        cancel4.click();
        Allure.step(" cancel button clicked  successfully");
        WebElement yes4 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/button[2]")
        ));
        yes4.click();
        Allure.step("yes button clicked  successfully");
        WebElement elementAddInvoice = wait.until(ExpectedConditions.elementToBeClickable(By.name("Invoices")));
        elementAddInvoice.click();
        Allure.step("Invoices button clicked  successfully");
        WebElement elementAddInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Invoice")));
        elementAddInvoiceButton.click();
        Allure.step("Add Invoice button clicked  successfully");
        WebElement customer2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")
        ));
        customer2.click();
        Allure.step("customer selected  successfully");
        WebElement Item2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr/td[2]/div/div/div/div/div[1]/div[2]")));
        Item2.click();
        WebElement option1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")
        ));
        option1.click();
        Allure.step("Item selected  successfully");
        WebElement cancel5 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[4]/button[1]")
        ));
        cancel5.click();
        Allure.step(" cancel button clicked  successfully");
        WebElement yes5 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/button[2]")
        ));
        yes5.click();
        Allure.step("yes button clicked  successfully");
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
//            String path = "screenshots/test35.png";
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
////                "Fill some details",
////                "Start creating the item, customer, receipts, Estimates, Credit notes, Invoices & fill some details then click on cancel",
////                "The system will display a validation prompt before you leave the page.",
////                "verified",
////                "",
////                "Tested",
////                ""
////        );
//    }
//}
