package ui.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utils.Waiters;

@Log4j2
public class AssigneeDropdown {

    WebDriver driver;

    public AssigneeDropdown(WebDriver driver) {
        this.driver = driver;
    }

    private static final By ASSIGNEE_DROPDOWN = By.xpath("//*[text()='Assignee']//parent::*[contains(@class, 'col')]//*[contains(@class,'container')]");
    private static final String ASSIGNEE_NAME = "//*[text()='%s' and contains(@id, 'select')]";

    public void selectAssigneeName(String assigneeName) {
        Waiters.waitForElementBecomesVisible(driver, ASSIGNEE_DROPDOWN, 5);
        log.info("Clicking on the 'Assignee' dropdown");
        driver.findElement(ASSIGNEE_DROPDOWN).click();
        log.info("Selecting " + assigneeName);
        driver.findElement(By.xpath(String.format(ASSIGNEE_NAME, assigneeName))).click();
    }
}
