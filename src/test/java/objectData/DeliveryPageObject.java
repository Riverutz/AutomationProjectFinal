package objectData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryPageObject extends GeneralObject{
    private String deliveryLastNameValue;
    private String deliveryFirstNameValue;
    private String deliveryAddressPhoneNumberValue;
    private String deliveryAddressCountyValue;
    private String deliveryAddressCityValue;
    private String deliveryAddressValue;
    private String deliveryAddressPostalCodeValue;
    private String observationsValue;

    public DeliveryPageObject(String filePath) {
        fromJsonToObject(filePath);
    }
}
