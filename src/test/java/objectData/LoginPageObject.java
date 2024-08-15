package objectData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginPageObject extends GeneralObject{
    private String userEmailValue;
    private String userPasswordValue;

    public LoginPageObject(String filePath) {
        fromJsonToObject(filePath);
    }
}
