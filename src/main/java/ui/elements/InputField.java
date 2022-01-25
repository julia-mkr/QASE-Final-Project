package ui.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class InputField {
    WebDriver driver;
    String label;

    public InputField(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    private static final String INPUT_FIELD = "//*[text()='%s']//ancestor::*[@class='form-group']//input";

    public void writeTextIntoInputField(String text) {
        log.info(String.format("Typing the text: '%s' into the '%s' input field", text, label));
        driver.findElement(By.xpath(String.format(INPUT_FIELD, label))).sendKeys(text);
    }
}
