package ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(By.xpath(String.format(PROJECT_DROPDOWN_MENU, projectName))).click();
        driver.findElement(By.xpath(String.format(DELETE_OPTION, projectName))).click();
    }
}
