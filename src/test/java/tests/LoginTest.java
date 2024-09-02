package tests;

import environmentPreparation.Environment;
import objectData.LoginPageObject;
import org.testng.annotations.Test;
import pages.CookiesPage;
import pages.LoginPage;

public class LoginTest extends Environment {
    @Test
    public void validations() {
        System.out.println("===== 1. VALIDATE THE PRESENCE OF LOGIN BUTTON ===== ");
        loginButtonPresence();
        System.out.println("===== 2. VALIDATE THE PRESENCE OF LOGOUT BUTTON ==== ");
        logoutButtonPresence();

    }

    public void loginButtonPresence() {
        CookiesPage cookiesPage = new CookiesPage(getDriver());
        cookiesPage.acceptSiteCookies();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.validateLoginButton();
    }

    public void logoutButtonPresence() {
        CookiesPage cookiesPage = new CookiesPage(getDriver());
        cookiesPage.acceptSiteCookies();

        LoginPageObject loginTestData = new LoginPageObject("src/test/resources/testData/LoginPageData.json");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.accountLogin(loginTestData);
        loginPage.validateLogOutButton();
    }
}


