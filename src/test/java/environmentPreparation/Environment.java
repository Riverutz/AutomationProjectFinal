package environmentPreparation;

import loggerUtility.LogUtil;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

@Getter
public class Environment {
    private WebDriver driver;

    @BeforeMethod
    public void prepareEnvironment() {
        boolean ci_cd = Boolean.parseBoolean(System.getProperty("CI_CD"));
        ChromeOptions options = new ChromeOptions();
        if (ci_cd) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-search-engine-choice-screen");
            driver = new ChromeDriver(options);
        } else {
            options.addArguments("--disable-search-engine-choice-screen");
            driver = new ChromeDriver(options);
        }
        driver.get("https://www.flax.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        LogUtil.info("The browser has opened successfully!");
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result) {
        if (!result.isSuccess()) {
            LogUtil.info(result.getThrowable().getMessage());
        }
        driver.quit();
        LogUtil.info("The browser was closed successfully!");
    }
}
