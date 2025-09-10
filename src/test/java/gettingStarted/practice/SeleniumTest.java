package gettingStarted.practice;

import extensions.commonmethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class SeleniumTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    @Test(priority = 1)
    public void login() {

        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
        driver.findElement(By.id("login-submit")).click();
        commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");

        commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");
        commonmethods.click(driver, By.cssSelector(".btn"));

        driver.navigate().to("https://appdev.actingoffice.com/books/clients/6658b0d14ac07e645cfb5474/dashboard");
        driver.manage().window().maximize();

        By inputsButton = By.id("inputs");
        WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(inputsButton));
        elementInputsButton.click();

        By salesButton = By.linkText("Sales");
        WebElement elementSalesButton = wait.until(ExpectedConditions.elementToBeClickable(salesButton));
        elementSalesButton.click();

    }

    @Test(priority = 2)
    public void addreciepts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Receipts"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Receipt"))).click();
        WebElement option6 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test1']")
        ));
        option6.click();
        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@placeholder='amount']")
        ));
        amountInput.click();
        amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        amountInput.sendKeys("£600.00");
        WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"bk-doc-edit\"]/div[2]/form/div/div[1]/div[1]/div[3]/div[1]/div/div/div/div[2]/div")
        ));
        accountDropdown.click();
        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Cash in hand - 157/1']")
        ));
        desiredOption.click();
        By addSave = By.xpath("//*[@id=\"bk-doc-edit\"]/div[4]/button[2]");
        WebElement elementSave = wait.until(ExpectedConditions.elementToBeClickable(addSave));
        elementSave.click();
    }

    }
//    @Test(priority = 2)
//    public void addInvoice() {
//
//        By addInvoiceButton = By.name("Invoice");
//        WebElement elementAddInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(addInvoiceButton));
//        elementAddInvoiceButton.click();
//        WebElement option1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")
//        ));
//        option1.click();
//
//
//        WebElement Item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr/td[2]/div/div/div/div/div[1]/div[2]")));
//        Item.click();
//
//        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")
//        ));
//        option.click();
//
//
//        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[.//span[text()='Save']]")
//        ));
//        saveButton.click();
//       }
//    @Test(priority = 3)
//    public void addcreditnote() {
//        By addInvoiceButton = By.name("Credit notes");
//        WebElement elementAddInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(addInvoiceButton));
//        elementAddInvoiceButton.click();
//        By addcreditnote = By.name("Credit note");
//       WebElement elementaddcreditnote = wait.until(ExpectedConditions.elementToBeClickable(addcreditnote));
//       elementaddcreditnote.click();
//        WebElement option1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//               By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")
//       ));
//       option1.click();
//        WebElement option2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div/div[2]")
//        ));
//        option2.click();
//        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[contains(@class, 'rs-option') and normalize-space()='INV-0029']")
//        ));
//        option.click();
//        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[.//span[text()='Save']]")
//        ));
//        saveBtn.click();
//        WebElement saveBtn1 = wait.until(ExpectedConditions.elementToBeClickable(
//                By.cssSelector("button[title='Save']")));
//        saveBtn1.click();
//    }
//    @Test(priority = 4)
//    public void addestimate() {
//        By addEstimates = By.name("Estimates");
//        WebElement elementEstimates = wait.until(ExpectedConditions.elementToBeClickable(addEstimates));
//        elementEstimates.click();
//        By addEstimate = By.name("Estimate");
//        WebElement elementEstimate = wait.until(ExpectedConditions.elementToBeClickable(addEstimate));
//        elementEstimate.click();
//        WebElement option5 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test1']")
//        ));
//        option5.click();
//        WebElement Item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr[1]/td[2]/div/div/div/div/div[1]/div[2]")));
//        Item.click();
////        WebElement placeholder = wait.until(ExpectedConditions.elementToBeClickable(
////                By.xpath("//div[contains(@class, 'rs-placeholder') and normalize-space(.)='Select']")
////        ));
////        placeholder.click();
//
//
//    //        WebElement Item1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-8-input")));
//    //        Item1.click();
//
//        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")
//        ));
//        option.click();
//        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[.//span[text()='Save']]")
//        ));
//        saveButton.click();
//    }
//    @Test(priority = 5)
//    public void purchase()
//    {
//        By salesButton = By.linkText("Purchases");
//        WebElement elementSalesButton = wait.until(ExpectedConditions.elementToBeClickable(salesButton));
//        elementSalesButton.click();
//    }
//    @Test (priority = 6)
//    public void addinvoicepurchase() {
//
//        By addInvoiceButton = By.name("Invoice");
//        WebElement elementAddInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(addInvoiceButton));
//        elementAddInvoiceButton.click();
//        WebElement option1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")
//        ));
//        option1.click();
//
//
//        WebElement Item = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-8-input")));
//        Item.click();
//
//        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")
//        ));
//        option.click();
//
//
//        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[.//span[text()='Save']]")
//        ));
//        saveButton.click();
//    }
//    @Test (priority = 7)
//    public void addcreditnotepurchase() {
//        By addInvoiceButton = By.name("Credit notes");
//        WebElement elementAddInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(addInvoiceButton));
//        elementAddInvoiceButton.click();
//        By addcreditnote = By.name("Credit note");
//       WebElement elementaddcreditnote = wait.until(ExpectedConditions.elementToBeClickable(addcreditnote));
//       elementaddcreditnote.click();
//        WebElement option1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//               By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")
//       ));
//       option1.click();
//        WebElement option2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div/div[2]")
//        ));
//        option2.click();
//        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[contains(@class, 'rs-option') and normalize-space()='PUR-0005']")
//        ));
//        option.click();
//        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[.//span[text()='Save']]")
//        ));
//        saveBtn.click();
//        WebElement saveBtn1 = wait.until(ExpectedConditions.elementToBeClickable(
//                By.cssSelector("button[title='Save']")));
//        saveBtn1.click();
//    }
//    @Test (priority = 8)
//    public void addpurchaseorders()
//    {
//        By addEstimates = By.name("Purchase orders");
//        WebElement elementEstimates = wait.until(ExpectedConditions.elementToBeClickable(addEstimates));
//        elementEstimates.click();
//        By addEstimate = By.name("Purchase order");
//        WebElement elementEstimate = wait.until(ExpectedConditions.elementToBeClickable(addEstimate));
//        elementEstimate.click();
//        WebElement option5 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")
//        ));
//        option5.click();
//        WebElement Item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr[1]/td[2]/div/div/div/div/div[1]/div[2]")));
//        Item.click();
//        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")
//        ));
//        option.click();
//        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[.//span[text()='Save']]")
//        ));
//        saveButton.click();
//    }


//   public void addreciepts() {
//        By addReceipts = By.name("Receipts");
//        WebElement elementReceipts = wait.until(ExpectedConditions.elementToBeClickable(addReceipts));
//        elementReceipts.click();
//        By addReceipt = By.name("Receipt");
//        WebElement elementReceipt = wait.until(ExpectedConditions.elementToBeClickable(addReceipt));
//        elementReceipt.click();
//        WebElement option6 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test1']")
//        ));
//        option6.click();
//
//        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(
//                By.cssSelector("input[placeholder='amount']")
//        ));
//        wait.until(ExpectedConditions.elementToBeClickable(amountInput)).click();
//        wait.until(ExpectedConditions.visibilityOf(amountInput)).sendKeys(Keys.CONTROL + "a");
//        wait.until(ExpectedConditions.visibilityOf(amountInput)).sendKeys(Keys.DELETE);
//
//
//
//        wait.until(ExpectedConditions.visibilityOf(amountInput)).sendKeys("600.00");
//        WebElement option2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[@id=\"bk-doc-edit\"]/div[2]/form/div/div[1]/div[1]/div[3]/div[1]/div/div/div/div[1]/div[2]")
//        ));
//        option2.click();
////        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.rs-input")));
////        input.click();
////       WebElement select=wait.until(ExpectedConditions.elementToBeClickable(By.name("Deposit account - 158/1")));
////       select.click();
//        By addSave = By.name("Save");
//        WebElement elementSave = wait.until(ExpectedConditions.elementToBeClickable(addSave));
//        elementSave.click();
//    }


