package ui.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ui.utils.Waiters;

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
        driver.findElement(By.xpath(String.format(TEXT_FIELD, label))).click();
        log.info(String.format("Typing the text: '%s' into the '%s' text field", text, label));
        driver.findElement(By.xpath(String.format(TEXT_FIELD, label))).sendKeys(text);
    }

    public void writeTextIntoTextFieldWithJs(String text) {
        JavascriptExecutor js  = (JavascriptExecutor)driver;
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(TEXT_FIELD, label)), 5);
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(String.format(TEXT_FIELD, label))));
        driver.findElement(By.xpath(String.format(TEXT_FIELD, label))).sendKeys(text);
    }
}
