package ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ui.constants.IConstants;

public class BasePage implements IConstants {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor  = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
