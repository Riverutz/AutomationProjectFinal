package objectData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillingPageObject extends GeneralObject{
    private String personLastNameValue;
    private String personFirstNameValue;
    private String billingAddressPhoneNumberValue;
    private String billingAddressCountyValue;
    private String billingAddressCityValue;
    private String billingAddressValue;
    private String billingAddressPostalCodeValue;

    public BillingPageObject(String filePath) {
        fromJsonToObject(filePath);
    }
}
