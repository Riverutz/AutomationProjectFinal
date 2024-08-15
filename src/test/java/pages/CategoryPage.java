package pages;

import loggerUtility.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends MethodsPage {
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Laptop/Tableta')]")
    private WebElement laptopTabletaMenu;
    @FindBy(xpath = "//strong[normalize-space()='Laptop']")
    private WebElement laptopSubMenu;

    public void laptopTabletaMenuSelection() {
        elementMethods.mouseHoverElement(laptopTabletaMenu);
        LogUtil.info("The user mouse hover on 'Laptop/Tableta' category");
    }

    public void laptopSubMenuSelection() {
        elementMethods.clickElement(laptopSubMenu);
        LogUtil.info("The user has selected the 'Laptop' submenu. ");
    }
}
