package ui.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.utils.Waiters;

import java.time.Duration;

@Log4j2
public class TextField {

    WebDriver driver;
    String label;

    public TextField(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    private static final String TEXT_FIELD = "//*[text()='%s']//ancestor::*[contains(@id, 'Group')]//p";

    public void writeTextIntoTextField(String text) {
        try {
            driver.findElement(By.xpath(String.format(TEXT_FIELD, label))).click();
            log.info(String.format("Typing the text: '%s' into the '%s' text field", text, label));
            driver.findElement(By.xpath(String.format(TEXT_FIELD, label))).sendKeys(text);
        } catch (UnhandledAlertException e) {
            driver.switchTo().alert().dismiss();
            log.info(String.format("Typing the text: '%s' into the '%s' text field", text, label));
            driver.findElement(By.xpath(String.format(TEXT_FIELD, label))).sendKeys(text);
        }
    }

    public void writeTextIntoTextFieldWithJs(String text) {
        JavascriptExecutor js  = (JavascriptExecutor)driver;
        try {
            Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(TEXT_FIELD, label)), 5);
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath(String.format(TEXT_FIELD, label))));
            log.info(String.format("Typing the text: '%s' into the '%s' text field", text, label));
            driver.findElement(By.xpath(String.format(TEXT_FIELD, label))).sendKeys(text);
        } catch (UnhandledAlertException e) {
            driver.switchTo().alert().dismiss();
            log.info(String.format("Typing the text: '%s' into the '%s' text field", text, label));
            driver.findElement(By.xpath(String.format(TEXT_FIELD, label))).sendKeys(text);
        }
    }
}
