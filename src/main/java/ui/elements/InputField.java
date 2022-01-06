package ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputField {
    WebDriver driver;
    String label;

    public InputField(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    private static final String INPUT_FIELD = "//*[text()='%s']//ancestor::*[@class='form-group']//input";

    public void writeTextIntoInputField(String text) {
        driver.findElement(By.xpath(String.format(INPUT_FIELD, label))).sendKeys(text);
    }
}
