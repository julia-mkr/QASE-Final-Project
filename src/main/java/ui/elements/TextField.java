package ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextField {

    WebDriver driver;
    String label;

    public TextField(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    private static final String TEXT_FIELD = "//*[text()='%s']//ancestor::*[contains(@id, 'Group')]//p";

    public void writeTextIntoInputField(String text) {
        driver.findElement(By.xpath(String.format(TEXT_FIELD, label))).sendKeys(text);
    }
}
