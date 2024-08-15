package pages;

import loggerUtility.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookiesPage extends MethodsPage{
    public CookiesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@name='accept']")
    private WebElement acceptCookies;

    public void acceptSiteCookies(){
        elementMethods.clickJSElement(acceptCookies);
        LogUtil.info("The user accepts the site cookies. ");
    }
}
