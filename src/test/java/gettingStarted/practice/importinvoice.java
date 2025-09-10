package gettingStarted.practice;
import extensions.commonmethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class importinvoice {
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

        By salesButton = By.linkText("Sales");
        WebElement elementSalesButton = wait.until(ExpectedConditions.elementToBeClickable(salesButton));
        elementSalesButton.click();

                           //# for making invoice into bad debts #//

//        By Baddebtsdropdown = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/div/div/div[8]/div/div[4]/div/button/span");
//        WebElement elementBaddebtsdropdown = wait.until(ExpectedConditions.elementToBeClickable(Baddebtsdropdown));
//        elementBaddebtsdropdown.click();
//
//        By Baddebts = By.xpath("/html/body/div[2]/div/div/div/div/div[3]/div/div/ul/li[2]/button/div");
//        WebElement elementBaddebts = wait.until(ExpectedConditions.elementToBeClickable(Baddebts));
//        elementBaddebts.click();
//
//        By save = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/button[2]/span");
//        WebElement elementsave = wait.until(ExpectedConditions.elementToBeClickable(save));
//        elementsave.click();

                         //# for making bad debts invoice into normal invoice #//

//        By rollback = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/div/div/div[8]/div/div/div/button");
//        WebElement elementrollback = wait.until(ExpectedConditions.elementToBeClickable(rollback));
//        elementrollback.click();
//
//        By yes = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/button[2]");
//        WebElement elementyes = wait.until(ExpectedConditions.elementToBeClickable(yes));
//        elementyes.click();

                                    //# for creating reciept from invoice # //

//        By createrecieptButton = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[8]/div/div[3]/div/button/span");
//        WebElement elementcreaterecieptButton = wait.until(ExpectedConditions.elementToBeClickable(createrecieptButton));
//        elementcreaterecieptButton.click();
//
//        WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//*[@id=\"bk-doc-edit\"]/div[2]/form/div/div[1]/div[1]/div[3]/div[1]/div/div/div/div[2]/div")
//        ));
//        accountDropdown.click();
//        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Cash in hand - 157/1']")
//        ));
//        desiredOption.click();
//
//        By addSave = By.xpath("//*[@id=\"bk-doc-edit\"]/div[4]/button[2]");
//        WebElement elementSave = wait.until(ExpectedConditions.elementToBeClickable(addSave));
//        elementSave.click();

                        //# for editing the invoice #//

//        By edit = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[8]/div/div[2]/div/button/span/i");
//        WebElement elementedit = wait.until(ExpectedConditions.elementToBeClickable(edit));
//        elementedit.click();
//
//        WebElement editc =wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/form/div/div[1]/div[1]/div/div[1]/div[1]/div/div/div[1]/div[2]/input")));
//      editc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//
//        By a = By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/form/div/div[1]/div[1]/div/div[2]/div[1]/div[2]/div/div/div/div");
//        WebElement elementa = wait.until(ExpectedConditions.elementToBeClickable(a));
//        elementa.click();
//
//        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/form/div/div[1]/div[1]/div/div[1]/div[1]/div/div/div[1]/div[2]")
//        ));
//        customer.click();
//        WebElement customer1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//               By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test1']")
//        ));
//       customer1.click();

//      editc.sendKeys("Test1");

//        elementeditc.click();
//        elementeditc.clear();
//        elementeditc.sendKeys(Keys.chord(Keys.CONTROL, "a"));


//        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test1']")
//        ));
//        customer.click();

                                        //# for downloading the invoice # //

//        By download = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[8]/div/div[1]/div/button/span/i");
//        WebElement elementdownload = wait.until(ExpectedConditions.elementToBeClickable(download));
//        elementdownload.click();
//
//        By importbutton = By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div/div/div[2]/button/span");
//        WebElement elementimportbutton = wait.until(ExpectedConditions.elementToBeClickable(importbutton));
//        elementimportbutton.click();
//
//        By upload = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]");
//        WebElement elementupload = wait.until(ExpectedConditions.elementToBeClickable(upload));
//        elementupload.click();
//
//        By importfile = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/button[2]/span/span/span");
//        WebElement elementimportfile = wait.until(ExpectedConditions.elementToBeClickable(importfile));
//        elementimportfile.click();
//
//        By save = By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div[2]/div/div[4]/button[2]/span/span/span");
//        WebElement elementsave = wait.until(ExpectedConditions.elementToBeClickable(save));
//        elementsave.click();
    }
    }
