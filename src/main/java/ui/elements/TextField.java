package ui.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
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
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(TEXT_FIELD, label)), 20);
        log.info(String.format("Typing the text: '%s' into the '%s' text field", text, label));
        driver.findElement(By.xpath(String.format(TEXT_FIELD, label))).sendKeys(text);
    }
}
