package Pages;

import loggerUtility.LogUtil;
import objectData.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MethodsPage{
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

    public void myAccount(){
        elementMethods.mouseHoverElement(contulMeu);
        LogUtil.info("The user mouse hover on 'CONTUL MEU' ");
    }

    public void userEmailLogin(LoginPageObject testData){
        elementMethods.fillElement(userEmail, testData.getUserEmailValue());
        LogUtil.info("The user filled the 'EMAIL' field with the value: " + testData.getUserEmailValue());
    }

    public void userPasswordLogin(LoginPageObject testData){
        elementMethods.fillElement(userPassword, testData.getUserPasswordValue());
        LogUtil.info("The user filled the 'PASSWORD' field with the value: " + testData.getUserPasswordValue());
    }

    public void loginButton(){
        elementMethods.clickJSElement(clickLoginButton);
        LogUtil.info("The user clicked on 'LOGIN' Button");
    }
}
