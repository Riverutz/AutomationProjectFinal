package pages;

import loggerUtility.LogUtil;
import objectData.DeliveryPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryPage extends MethodsPage {
    public DeliveryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='add-delivery-details']//span[contains(text(),'Adauga')]")
    private WebElement deliveryDetails;
    @FindBy(id = "delivery_last_name")
    private WebElement deliveryAddressLastName;
    @FindBy(id = "delivery_first_name")
    private WebElement deliveryFirstName;
    @FindBy(id = "delivery_phone")
    private WebElement deliveryPhoneNumber;
    @FindBy(id = "delivery_state")
    private WebElement deliveryAddressCounty;
    @FindBy(id = "delivery_city")
    private WebElement deliveryAddressCity;
    @FindBy(id = "delivery_address")
    private WebElement delivery_address;
    @FindBy(id = "delivery_postal_code")
    private WebElement deliveryAdressPostalCode;
    @FindBy(xpath = "//button[contains(@class, 'js-add-delivery-address') and text()='Salveaza']")
    private WebElement clickSalveazaAddButton;
    @FindBy(xpath = "//label[@for='shipping-method-16']")
    private WebElement courier;
    @FindBy(xpath = "//span[contains(text(),'Ramburs la livrare – achitati numerar curierului')]")
    private WebElement paymentMethod;
    @FindBy(id = "observations")
    private WebElement observations;
    @FindBy(xpath = "//label[@for='terms-order']")
    private WebElement termensAndConditions;

    public void addDeliveryDetails() {
        elementMethods.clickJSElement(deliveryDetails);
        LogUtil.info("The user clicked on 'Adauga' button to fill the 'Delivery' address. ");
    }

    public void addDeliveryAddress(DeliveryPageObject testData) {
        elementMethods.fillElement(deliveryAddressLastName, testData.getDeliveryLastNameValue());
        LogUtil.info("The user filled the 'Nume' field with the value: " + testData.getDeliveryLastNameValue());
        elementMethods.fillElement(deliveryFirstName, testData.getDeliveryFirstNameValue());
        LogUtil.info("The user filled the 'Prenume' field with the value: " + testData.getDeliveryFirstNameValue());
        elementMethods.fillElement(deliveryPhoneNumber, testData.getDeliveryAddressPhoneNumberValue());
        LogUtil.info("The user filled the 'Telefon' field with the value: " + testData.getDeliveryAddressPhoneNumberValue());
        elementMethods.fillElement(deliveryAddressCounty, testData.getDeliveryAddressCountyValue());
        LogUtil.info("The user filled the 'Judet' field with the value: " + testData.getDeliveryAddressCountyValue());
        elementMethods.fillElement(deliveryAddressCity, testData.getDeliveryAddressCityValue());
        LogUtil.info("The user filled the 'Oras' field with the value: " + testData.getDeliveryAddressCityValue());
        elementMethods.fillElement(delivery_address, testData.getDeliveryAddressValue());
        LogUtil.info("The user filled the 'Adresa completa' field with the value: " + testData.getDeliveryAddressValue());
        elementMethods.fillElement(deliveryAdressPostalCode, testData.getDeliveryAddressPostalCodeValue());
        LogUtil.info("The user filled the 'Cod postal' field with the value: " + testData.getDeliveryAddressPostalCodeValue());
    }

    public void deliverySalveazaButton(){
        elementMethods.clickJSElement(clickSalveazaAddButton);
        pageMethods.scrollPage(0,400);
        LogUtil.info("The user clicked on 'Salveaza' button");
    }
    public void fanCourier(){
        elementMethods.clickJSElement(courier);
        pageMethods.scrollPage(0,400);
        LogUtil.info("The user checked 'Fan Courier'. ");
    }

    public void paymentMethods(){
        elementMethods.clickJSElement(paymentMethod);
        pageMethods.scrollPage(0,400);
        LogUtil.info("The user checked 'Plata la termen' as payment method. ");
    }

    public void tinyObservations(DeliveryPageObject testData){
        elementMethods.fillElement(observations,testData.getObservationsValue());
        LogUtil.info("The user filled the 'Observatii' field with the value: " + testData.getObservationsValue());
    }

    public void agreeWithTermsAndConditions(){
        elementMethods.clickJSElement(termensAndConditions);
        LogUtil.info("The user checked 'Am citit Termenii si conditiile si sunt de acord cu acestea'.");
    }
}
