package pages;

import methods.ElementMethods;
import methods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MethodsPage {
    protected WebDriver driver;
    protected ElementMethods elementMethods;
    protected PageMethods pageMethods;

    public MethodsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }
}
