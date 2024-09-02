package flaxTest;

import pages.*;
import environmentPreparation.Environment;
import objectData.BillingPageObject;
import objectData.DeliveryPageObject;
import objectData.LoginPageObject;
import org.testng.annotations.Test;

public class FlaxTest extends Environment {

    @Test
    public void siteTest(){

        CookiesPage cookiesPage = new CookiesPage(getDriver());
        cookiesPage.acceptSiteCookies();

        LoginPageObject loginTestData = new LoginPageObject("src/test/resources/testData/LoginPageData.json");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.accountLogin(loginTestData);

        CategoryPage categoryPage = new CategoryPage(getDriver());
        categoryPage.laptopTabletaMenuSelection();
        categoryPage.laptopSubMenuSelection();

        ItemPage itemPage = new ItemPage(getDriver());
        itemPage.highestPriceSelection();
        itemPage.laptopCategorySelection();
        itemPage.laptopCpuSelection();
        itemPage.laptopScreenSizeSelection();
        itemPage.laptopColorSelection();
        itemPage.addItemToCart();
        itemPage.checkTheBasket();
        itemPage.clickTheBasket();

        BillingPageObject billingTestData = new BillingPageObject("src/test/resources/testData/BillingPageData.json");
        BillingPage billingPage = new BillingPage(getDriver());
        billingPage.addBillingDetails();
        billingPage.addBillingAddress(billingTestData);
        billingPage.billingSalveazaButton();

        DeliveryPageObject deliveryTestData = new DeliveryPageObject("src/test/resources/testData/DeliveryPageObject.json");
        DeliveryPage deliveryPage = new DeliveryPage(getDriver());
        deliveryPage.addDeliveryDetails();
        deliveryPage.addDeliveryAddress(deliveryTestData);
        deliveryPage.deliverySalveazaButton();
        deliveryPage.fanCourier();
        deliveryPage.paymentMethods();
        deliveryPage.tinyObservations(deliveryTestData);
        deliveryPage.agreeWithTermsAndConditions();

    }
}
