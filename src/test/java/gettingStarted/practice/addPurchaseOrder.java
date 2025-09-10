package gettingStarted.practice;
import extensions.commonmethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class addPurchaseOrder {
    public static void main(String [] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
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

        By PurchaseButton = By.linkText("Purchases");
        WebElement elementPurchase = wait.until(ExpectedConditions.elementToBeClickable(PurchaseButton));
        elementPurchase.click();

        By Purchaseorders = By.name("Purchase orders");
        WebElement elementPurchaseorders = wait.until(ExpectedConditions.elementToBeClickable(Purchaseorders));
        elementPurchaseorders.click();

                              //#creating invoice from purchase orders#//
        By createinvoice = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[6]/div/div[3]/div/button/span");
        WebElement elementcreateinvoice = wait.until(ExpectedConditions.elementToBeClickable(createinvoice));
        elementcreateinvoice.click();

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[text()='Save']]")
        ));
        saveButton.click();
                                 //#adding purchase orders#//

//        By addPurchaseorder = By.name("Purchase order");
//        WebElement elementaddPurchaseorder = wait.until(ExpectedConditions.elementToBeClickable(addPurchaseorder));
//        elementaddPurchaseorder.click();
//
//        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")
//        ));
//        customer.click();
//
//        WebElement Item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr[1]/td[2]/div/div/div/div/div[1]/div[2]")));
//        Item.click();
//        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")
//        ));
//        option.click();
//
//        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[.//span[text()='Save']]")
//        ));
//        saveButton.click();

                                      //#downloading purchase order #//

//        By download = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[6]/div/div[1]/div/button/span");
//        WebElement elementdownload = wait.until(ExpectedConditions.elementToBeClickable(download));
//        elementdownload.click();

                                               //#editing purchase order #//

//        By edit = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[6]/div/div[2]/div/button/span");
//        WebElement elementedit = wait.until(ExpectedConditions.elementToBeClickable(edit));
//        elementedit.click();
//
//        WebElement editc =wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[1]/div[1]/div/div[1]/div[1]/div/div/div[1]/div[2]/input")));
//      editc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//
//        By a = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[1]/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div");
//        WebElement elementa = wait.until(ExpectedConditions.elementToBeClickable(a));
//        elementa.click();
//
//        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[1]/div[1]/div/div[1]/div[1]/div/div/div[1]/div[2]")
//        ));
//        customer.click();
//        WebElement customer1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//               By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test-1 (Alok Kumar)']")
//        ));
//       customer1.click();
//
//      editc.sendKeys("Test-1 (Alok Kumar)");
//
//        WebElement customer2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test-1 (Alok Kumar)']")
//        ));
//        customer2.click();
//
//        By save = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div/div[3]/div/div[3]/div[2]/div[2]/div[3]/button[2]");
//        WebElement elementsave = wait.until(ExpectedConditions.elementToBeClickable(save));
//        elementsave.click();

    }
    }
