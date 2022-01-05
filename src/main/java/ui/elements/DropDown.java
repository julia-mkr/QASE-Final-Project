package ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {

    WebDriver driver;
    String dropdownLabel;

    public DropDown(WebDriver driver, String dropdownLabel) {
        this.driver = driver;
        this.dropdownLabel = dropdownLabel;
    }

    private static final String DROPDOWN = "//*[text()='%s']//ancestor::*[contains(@id, 'Group')]//*[contains(@class,'container')]";
    private static final String OPTION = "//*[text()='%s' and contains(@id, 'select')]";

    public void selectOptionFromDropdown(String optionText) {
        driver.findElement(By.xpath(String.format(DROPDOWN, dropdownLabel))).click();
        driver.findElement(By.xpath(String.format(OPTION, optionText))).click();
    }
}
