package ui.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DropDown {

    WebDriver driver;
    String dropdownLabel;

    public DropDown(WebDriver driver, String dropdownLabel) {
        this.driver = driver;
        this.dropdownLabel = dropdownLabel;
    }

    private static final String DROPDOWN = "//*[text()='%s']//ancestor::*[contains(@id, 'Group')]//*[contains(@class,'container')]";
    private static final String OPTION = "//*[text()='%s' and contains(@id, 'select')]";

    public void selectOption(String optionText) {
        driver.findElement(By.xpath(String.format(DROPDOWN, dropdownLabel))).click();
        log.info(String.format("Selecting '%s' option from '%s' dropdown", optionText, dropdownLabel));
        driver.findElement(By.xpath(String.format(OPTION, optionText))).click();
    }
}
