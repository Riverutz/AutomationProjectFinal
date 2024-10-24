package pages;

import loggerUtility.LogUtil;
import objectData.BillingPageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class BillingPage extends MethodsPage {
    public BillingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "choose_billing_type_person")
    private WebElement billingTypePerson;
    @FindBy(id = "add-billing-details")
    private WebElement addBillingPersonDetails;
    @FindBy(id = "billing_person_last_name")
    private WebElement billingPersonLastName;
    @FindBy(id = "billing_person_first_name")
    private WebElement billingPersonFirstName;
    @FindBy(id = "billing_person_phone")
    private WebElement billingPersonPhone;
    @FindBy(id = "billing_person_state_chosen")
    private WebElement billingPersonCounty;
    @FindBy(xpath = "//li[contains(text(), 'Vrancea')]")
    private WebElement countyChosen;
    @FindBy(id = "billing_person_city_chosen")
    private WebElement billingPersonCity;
    @FindBy(xpath = "//li[contains(text(), 'Adjud')]")
    private WebElement cityChosen;
    @FindBy(id = "billing_person_address")
    private WebElement billingPersonAddress;
    @FindBy(id = "billing_person_postal_code")
    private WebElement billingPersonPostalCode;
    @FindBy(xpath = "//button[@class='button default-btn black js-add-billing-details' and text()='Salveaza']")
    private WebElement saveBillingDetails;
    @FindBy(xpath = "//label[contains(@for,'shipping-method-16')]//p[1]")
    private WebElement deliveryOption;
    @FindBy(xpath = "//label[@for='payment-method-3']")
    private WebElement paymentOption;

    public void billingPersonAddress(BillingPageObject testData) {
        System.out.println(" ");
        System.out.println("===== BILLING & DELIVERY DETAILS =====");
        System.out.println(" ");
        elementMethods.clickJSElement(billingTypePerson);
        LogUtil.info("The user has checked 'Persoana Fizica'. ");
        elementMethods.clickJSElement(addBillingPersonDetails);
        LogUtil.info("The user clicked on 'Adauga persoana fizica'. ");
        elementMethods.fillElement(billingPersonLastName, testData.getPersonLastNameValue());
        LogUtil.info("The user filled the 'Nume' field with the value: " + testData.getPersonLastNameValue());
        elementMethods.fillElement(billingPersonFirstName, testData.getPersonFirstNameValue());
        LogUtil.info("The user filled the 'Prenume' field with the value: " + testData.getPersonFirstNameValue());
        elementMethods.fillElement(billingPersonPhone, testData.getBillingAddressPhoneNumberValue());
        LogUtil.info("The user filled the 'Telefon' field with the value: " + testData.getBillingAddressPhoneNumberValue());
        elementMethods.clickElement(billingPersonCounty);
        elementMethods.clickElement(countyChosen);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String countyText = (String) js.executeScript("return arguments[0].innerText;", countyChosen);
        LogUtil.info("The user has added the 'County' of " + countyText + " to the billing address");
        elementMethods.clickElement(billingPersonCity);
        elementMethods.clickElement(cityChosen);
        JavascriptExecutor jst = (JavascriptExecutor) driver;
        String cityText = (String) jst.executeScript("return arguments[0].innerText;", cityChosen);
        LogUtil.info("The user has added the 'City' of " + cityText + " to the billing address.");
        elementMethods.fillElement(billingPersonAddress, testData.getBillingAddressValue() + ".");
        LogUtil.info("The user filled the 'Adresa completa' field with the value: " + testData.getBillingAddressValue() + ".");
        elementMethods.fillElement(billingPersonPostalCode, testData.getBillingAddressPostalCodeValue());
        LogUtil.info("The user filled the 'Cod postal' field with the value: " + testData.getBillingAddressPostalCodeValue() + ".");
        elementMethods.clickElement(saveBillingDetails);
        LogUtil.info("The user has on the 'Salveaza' button and saved the billing information. ");
    }

    public void shippingMethods() {
        pageMethods.scrollPage(0, 100);
        elementMethods.clickJSElement(deliveryOption);
        LogUtil.info("The user has chosen 'Fan Curier' as the delivery method.");
    }

    public void paymentMethods() {
        pageMethods.scrollPage(0, 250);
        elementMethods.clickJSElement(paymentOption);
        LogUtil.info("The user has chosen 'Online cu card bancar - Visa, Mastercard, etc.' as the payment method.");

    }
}
