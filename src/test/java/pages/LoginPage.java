package pages;

import loggerUtility.LogUtil;
import objectData.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends MethodsPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Contul meu']")
    private WebElement contulMeu;
    @FindBy(id = "login-email-header")
    private WebElement userEmail;
    @FindBy(id = "login-password-header")
    private WebElement userPassword;
    @FindBy(xpath = "//a[normalize-space()='Login']")
    private WebElement clickLoginButton;
    @FindBy(xpath = "//a[@title='Logout']")
    private WebElement logOutButton;

    public void accountLogin(LoginPageObject testData) {
        elementMethods.mouseHoverElement(contulMeu);
        LogUtil.info("The user mouse hover on 'CONTUL MEU' ");
        elementMethods.fillElement(userEmail, testData.getUserEmailValue());
        LogUtil.info("The user filled the 'EMAIL' field with the value: " + testData.getUserEmailValue());
        elementMethods.fillElement(userPassword, testData.getUserPasswordValue());
        LogUtil.info("The user filled the 'PASSWORD' field with the value: " + testData.getUserPasswordValue());
        elementMethods.clickJSElement(clickLoginButton);
        LogUtil.info("The user clicked on 'LOGIN' Button");
    }

    public void validateSuccessfulLoginViaButton() {
        elementMethods.mouseHoverElement(contulMeu);
        elementMethods.waitForElementVisible(logOutButton);
        Assert.assertTrue(logOutButton.isDisplayed(), "Logout button is not displayed.");
        LogUtil.info("Login successful. The logout button is displayed.");
        elementMethods.clickJSElement(logOutButton);
    }
}