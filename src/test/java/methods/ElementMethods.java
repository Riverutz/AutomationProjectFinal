package methods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@AllArgsConstructor
public class ElementMethods {
    public WebDriver driver;

    public void waitForElementVisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element) {
        waitForElementVisible(element);
        element.click();
    }

    public void fillElement(WebElement element, String text) {
        waitForElementVisible(element);
        element.sendKeys(text);
    }

    public void pressElement(WebElement element, Keys key) {
        waitForElementVisible(element);
        element.sendKeys(key);
    }

    public void clickJSElement(WebElement element) {
        JavascriptExecutor jsClick = (JavascriptExecutor) driver;
        jsClick.executeScript("arguments[0].click();", element);
    }

    public void selectByTextElement(WebElement element, String text) {
        waitForElementVisible(element);
        Select monthSelect = new Select(element);
        monthSelect.selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String text) {
        waitForElementVisible(element);
        Select yearSelect = new Select(element);
        yearSelect.selectByValue(text);
    }

    public void clearFillElement(WebElement element, String text) {
        waitForElementVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void mouseHoverElement(WebElement element){
        waitForElementVisible(element);
        Actions act = new Actions(driver); //add waitForElementVisible(element); in case of fail
        act.moveToElement(element).perform();
    }

    public void dropDownElement(WebElement element, Integer index){
        waitForElementVisible(element);
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }
}
