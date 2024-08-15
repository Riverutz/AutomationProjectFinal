package Pages;

import loggerUtility.LogUtil;
import objectData.BillingPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BillingPage extends MethodsPage {
    public BillingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath= "//div[@id='billing_details_person_tab']//span[contains(text(),'Adauga')]")
    private WebElement billingDetails;
    @FindBy(id = "billing_person_last_name")
    private WebElement billingAddressLastName;
    @FindBy(id = "billing_person_first_name")
    private WebElement billingAddressFirstName;
    @FindBy(id = "billing_person_phone")
    private WebElement billingAddressPhoneNumber;
    @FindBy(id = "billing_person_state")
    private WebElement billingAddressCounty;
    @FindBy(id = "billing_person_city")
    private WebElement billingAddressCity;
    @FindBy(id = "billing_person_address")
    private WebElement billingAddress;
    @FindBy(id = "billing_person_postal_code")
    private WebElement billingAddressPostalCode;
    @FindBy(xpath = "//button[contains(@class, 'js-add-billing-details') and @data-target='person']")
    private WebElement button;


    public void addBillingDetails() {
        pageMethods.scrollPage(0,350);
        elementMethods.clickJSElement(billingDetails);
        LogUtil.info("The user has clicked on 'Adauga' button. ");
    }

    public void addBillingAddress(BillingPageObject testData){
        elementMethods.fillElement(billingAddressLastName,testData.getPersonLastNameValue());
        LogUtil.info("The user filled the 'Nume' field with the value: " + testData.getPersonLastNameValue());
        elementMethods.fillElement(billingAddressFirstName, testData.getPersonFirstNameValue());
        LogUtil.info("The user filled the 'Prenume' field with the value: " + testData.getPersonFirstNameValue());
        elementMethods.fillElement(billingAddressPhoneNumber, testData.getBillingAddressPhoneNumberValue());
        LogUtil.info("The user filled the 'Telefon' field with the value: " + testData.getBillingAddressPhoneNumberValue());
        elementMethods.fillElement(billingAddressCounty, testData.getBillingAddressCountyValue());
        LogUtil.info("The user filled the 'Judet' field with the value: " + testData.getBillingAddressCountyValue());
        elementMethods.fillElement(billingAddressCity, testData.getBillingAddressCityValue());
        LogUtil.info("The user filled the 'Oras' field with the value: " + testData.getBillingAddressCityValue());
        elementMethods.fillElement(billingAddress, testData.getBillingAddressValue());
        LogUtil.info("The user filled the 'Adresa completa' field with the value: " + testData.getBillingAddressValue());
        elementMethods.fillElement(billingAddressPostalCode, testData.getBillingAddressPostalCodeValue());
        LogUtil.info("The user filled the 'Cod postal' field with the value: " + testData.getBillingAddressPostalCodeValue());
    }

    public void billingSalveazaButton(){
        elementMethods.clickJSElement(button);
        LogUtil.info("The user clicked on 'Salveaza' button");
    }
}
