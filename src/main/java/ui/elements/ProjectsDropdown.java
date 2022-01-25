package ui.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utils.Waiters;

@Log4j2
public class ProjectsDropdown {

    WebDriver driver;
    String projectName;

    public ProjectsDropdown(WebDriver driver, String projectName) {
        this.driver = driver;
        this.projectName = projectName;
    }

    private static final String PROJECT_DROPDOWN_MENU = "//*[text()='%s']//ancestor::tr//*[contains(@class, 'btn-dropdown')]";
    private static final String DELETE_OPTION = "//*[text()='%s']//ancestor::tr//*[@class='text-danger']";

    public void selectDeleteOption() {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(PROJECT_DROPDOWN_MENU, projectName)), 5);
        driver.findElement(By.xpath(String.format(PROJECT_DROPDOWN_MENU, projectName))).click();
        log.info(String.format("Click on the 'Delete' button near the '%s' project", projectName));
        driver.findElement(By.xpath(String.format(DELETE_OPTION, projectName))).click();
    }
}
