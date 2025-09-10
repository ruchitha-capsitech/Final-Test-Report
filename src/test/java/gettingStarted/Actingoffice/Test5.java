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
public class Test5 {
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

    @Test(description = "Credit note Creation when full payment recieved")
    @Epic("Sales Module")
    @Feature("Credit note Creation")
    @Severity(SeverityLevel.CRITICAL)
    public void CreditnoteCreationwhenfullpaymentrecieved() {
        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
        Allure.step("Navigated to login page");
        driver.manage().window().maximize();
        commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");

        commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");

        WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]")));
        elementLogin.click();
        driver.navigate().to("https://appdev.actingoffice.com/admin");
        Allure.step("navigating to admin page");
        WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
        elementDashboard.click();

        WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
        elementBookkeeping.click();

        WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
        elementCompany.click();

        WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
        elementInputsButton.click();

        WebElement elementSalesButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sales")));
        elementSalesButton.click();

        WebElement elementCreditNotesButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Credit notes")));
        elementCreditNotesButton.click();
        Allure.step(" credit notes clicked");
        WebElement elementAddCreditNote = wait.until(ExpectedConditions.elementToBeClickable(By.name("Credit note")));
        elementAddCreditNote.click();
        Allure.step("add credit notes clicked");
        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")
        ));
        customer.click();
        Allure.step("customer selected");
        WebElement InvoiceRefNo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div/div[2]")
        ));
        InvoiceRefNo.click();

        WebElement invoiceNo = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'rs-option') and normalize-space()='INV-0064']")
        ));
        invoiceNo.click();
        Allure.step("invoice ref no selected");
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[text()='Save']]")
        ));
        saveBtn.click();
        Allure.step("save selected");
        WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[1]/div[2]")
        ));
        accountDropdown.click();
        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Cash in hand - 157/1']")
        ));
        desiredOption.click();
        Allure.step("account selected");
        WebElement saveBtn1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[title='Save']")));
        saveBtn1.click();
    }
    private byte[] takeScreenshot() {
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

//    public static void main(String[] args) {
//        test();
//        ExcelLogger.logResult(
//                "Input/Sales",
//                "Create Credit note",
//                "Sales invoice created and full payment received from customer",
//                "Go to credit note and click on credit note, Select customer, date, invoice reference number, update quantity returned, Unit price, discount rate or amount, enter note if any and click on save button. Now it will show us a wizard for refund of amount, verify and click on save.",
//                "Credit note created with refund amount. Also General ledger of Sales, VAT and Customer updated.",
//                "Amount and refund amount got updated",
//                "",
//                "Tested",
//                ""
//        );
//    }
//}
