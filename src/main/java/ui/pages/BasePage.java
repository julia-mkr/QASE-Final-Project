package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ui.constants.IConstants;

@Log4j2
public class BasePage implements IConstants {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        log.debug("Initializing PageFactory");
        PageFactory.initElements(driver, this);
    }

    @Step("Opening URL: '{url}'")
    public void openUrl(String url) {
        log.info("Opening the URL: " + url);
        driver.get(url);
    }

    public void jsClick(WebElement element) {
        log.warn("Using a JS click");
        JavascriptExecutor executor  = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
