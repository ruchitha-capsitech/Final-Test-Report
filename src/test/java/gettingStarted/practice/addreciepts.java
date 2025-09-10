package gettingStarted.practice;
import extensions.commonmethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class addreciepts {
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

        wait.until(ExpectedConditions.elementToBeClickable(By.name("Receipts"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.name("Receipt"))).click();

        WebElement RecievedFrom = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test1']")
        ));
        RecievedFrom.click();

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
