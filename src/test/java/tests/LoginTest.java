package tests;

import environmentPreparation.Environment;
import loggerUtility.LogUtil;
import objectData.LoginPageObject;
import org.testng.annotations.Test;
import pages.CookiesPage;
import pages.LoginPage;

public class LoginTest extends Environment {

    @Test
    public void validations() {

        System.out.println(" ");
        System.out.println("===== VALIDATE SUCCESSFUL LOGIN BY LOCATING THE PRESENCE OF LOGOUT BUTTON ===== ");
        successfulLoginViaButton();

        System.out.println(" ");
        System.out.println("===== VALIDATE SUCCESSFUL LOGIN VIA URL ===== ");
        successfulLoginViaURL();



    }
    public void successfulLoginViaButton(){
        CookiesPage cookiesPage = new CookiesPage(getDriver());
        cookiesPage.acceptSiteCookies();

        LoginPageObject loginTestData = new LoginPageObject("src/test/resources/testData/LoginPageData.json");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.accountLogin(loginTestData);
        loginPage.validateSuccessfulLoginViaButton();
    }

    public void successfulLoginViaURL() {
        try {
            CookiesPage cookiesPage = new CookiesPage(getDriver());
            cookiesPage.acceptSiteCookies();

            LoginPageObject loginTestData = new LoginPageObject("src/test/resources/testData/LoginPageData.json");
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.accountLogin(loginTestData);


            String currentUrl = getDriver().getCurrentUrl();
            if (currentUrl.equals("https://www.flax.ro/profil#action,login,success")) {
                LogUtil.info("Login successful. URL: " + currentUrl);
            } else {
                System.out.println("Login failed. URL: " + currentUrl);
                LogUtil.error("Login failed. URL: " + currentUrl);
            }
        } catch (Exception e) {
            LogUtil.error("An error occurred during login: " + e.getMessage());
            e.printStackTrace();
        } finally {
            getDriver().quit();
        }
    }
}




