package ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextField {

    WebDriver driver;

    public TextField(WebDriver driver) {
        this.driver = driver;
    }

    private static final By DESCRIPTION_FIELD = By.xpath("//*[text()='Description']//ancestor::*[@id='descriptionGroup']//p");
    private static final By PRECONDITIONS_FIELD = By.xpath("//*[text()='Preconditions']//ancestor::*[@id='preconditionsGroup']//p");

    public void writeTextForSuite(String description, String preconditions) {
        driver.findElement(DESCRIPTION_FIELD).sendKeys(description);
        driver.findElement(PRECONDITIONS_FIELD).sendKeys(preconditions);
    }
}
