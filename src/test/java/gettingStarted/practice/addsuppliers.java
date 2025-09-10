package gettingStarted.practice;
import extensions.commonmethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class addsuppliers {
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

        By Suppliers = By.name("Suppliers");
        WebElement elementSuppliers = wait.until(ExpectedConditions.elementToBeClickable(Suppliers));
        elementSuppliers.click();

        By addSupplier = By.name("Supplier");
        WebElement elementSupplier = wait.until(ExpectedConditions.elementToBeClickable(addSupplier));
        elementSupplier.click();

        WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/form/div/div[1]/div[1]/div/div[1]/div/div[1]/div/div[1]/div/div/input")
        ));
        Name.click();
        Name.sendKeys("A LIMITED");

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[text()='Save']]")
        ));
        saveButton.click();
    }
}
