package ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssigneeDropdown {

    WebDriver driver;

    public AssigneeDropdown(WebDriver driver) {
        this.driver = driver;
    }

    private static final By ASSIGNEE_DROPDOWN = By.xpath("//*[text()='Assignee']//parent::*[contains(@class, 'col')]//*[contains(@class,'container')]");
    private static final String ASSIGNEE_NAME = "//*[text()='%s' and contains(@id, 'select')]";

    public void selectAssigneeName(String assigneeName) {
        driver.findElement(ASSIGNEE_DROPDOWN).click();
        driver.findElement(By.xpath(String.format(ASSIGNEE_NAME, assigneeName))).click();
    }
}
