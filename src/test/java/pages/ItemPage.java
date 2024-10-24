package pages;

import loggerUtility.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends MethodsPage {

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Filtreaza dupa : Pret descrescator']")
    private WebElement laptopSelectionByHighestPrice;
    @FindBy(xpath = "//a[@title='Filtreaza dupa: Gaming']")
    private WebElement laptopSelectionByGamingCategory;
    @FindBy(xpath = "//a[@title='Filtreaza dupa: Intel Core i9']")
    private WebElement laptopSelectionByCpu;
    @FindBy(xpath = "//a[@title='Filtreaza dupa: 18 Inch']")
    private WebElement laptopSelectionByScreenSize;
    @FindBy(xpath = "//a[@title='Filtreaza dupa: Negru']")
    private WebElement laptopSelectionByColor;
    @FindBy(xpath = "//div[contains(@class,'products-wrapper content-wrapper cf')]//div[1]//div[1]//div[2]//div[5]//a[1]")
    private WebElement addToCart;
    @FindBy(xpath = "//a[normalize-space()='Detalii Comanda']")
    private WebElement detaliiComanda;

    public void highestPriceSelection() {
        pageMethods.scrollPage(0, 350);
        elementMethods.clickJSElement(laptopSelectionByHighestPrice);
        LogUtil.info("The user checked 'Prest Descrescator'. ");
    }

    public void laptopCategorySelection() {
        pageMethods.scrollPage(0, 450);
        elementMethods.clickJSElement(laptopSelectionByGamingCategory);
        LogUtil.info("The user scrolled down the page and checked the 'Gaming Category'. ");
    }

    public void laptopCpuSelection() {
        elementMethods.clickJSElement(laptopSelectionByCpu);
        LogUtil.info("The user has checked the 'CPU' as Intel Core I9. ");
    }

    public void laptopScreenSizeSelection() {
        pageMethods.scrollPage(0, 800);
        LogUtil.info("The user scrolled down the page. ");
        elementMethods.clickJSElement(laptopSelectionByScreenSize);
        LogUtil.info("The user has checked 'Display Size' as 18 inch. ");
    }

    public void laptopColorSelection() {
        elementMethods.clickJSElement(laptopSelectionByColor);
        LogUtil.info("The user has checked 'Colour' as black. ");
    }

    public void addItemToCart() {
        elementMethods.clickJSElement(addToCart);
        LogUtil.info("The user added the item to basket.");
    }

    public void clickDetaliiComanda() {
        elementMethods.clickJSElement(detaliiComanda);
        LogUtil.info("The user has clicked on the basket. ");
    }
}



