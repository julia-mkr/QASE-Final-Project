package ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerificationUtils {

    private static final String SELECTED_OPTION = "//*[text()='%s']//parent::*[contains(@class,'param')]//*[contains(@class,'param-value')]";
    private static final String ENTERED_TEXT = "//*[contains(@class,'preview')]//child::*[text()='%s']";

    public static boolean isOptionDisplayed(WebDriver driver, String label) {
        return driver.findElement(By.xpath(String.format(SELECTED_OPTION, label))).isDisplayed();
    }

    public static boolean isEnteredTextDisplayed(WebDriver driver, String text) {
        return driver.findElement(By.xpath(String.format(ENTERED_TEXT, text))).isDisplayed();
    }
}
