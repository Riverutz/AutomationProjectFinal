package flaxTest;

import Pages.*;
import environmentPreparation.Environment;
import objectData.BillingPageObject;
import objectData.DeliveryPageObject;
import objectData.LoginPageObject;
import org.testng.annotations.Test;

public class FlaxTest extends Environment {

    @Test
    public void siteTest(){


        //This project aims to automate the core e-commerce customer journey by testing product search, add to cart, and checkout processes. Specifically, it will validate the ability to search for a specific product (e.g., 18-inch black gaming laptop with Intel Core i9), add it to the cart, and complete the checkout process by entering correct delivery and billing information.
        // By automating these critical steps, we will improve test efficiency, identify potential issues, and enhance the overall user experience.
        CookiesPage cookiesPage = new CookiesPage(getDriver());
        cookiesPage.acceptSiteCookies();

        LoginPageObject loginTestData = new LoginPageObject("src/test/resources/testData/LoginPageData.json");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.myAccount();
        loginPage.userEmailLogin(loginTestData);
        loginPage.userPasswordLogin(loginTestData);
        loginPage.loginButton();

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
