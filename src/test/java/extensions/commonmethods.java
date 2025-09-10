package extensions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class commonmethods {
    public static void entertextmethods(WebDriver driver, By locator, String value) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
    public static void click(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }
}
