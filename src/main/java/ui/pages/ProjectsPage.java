package ui.pages;

import ui.elements.DropDownMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

import java.util.ArrayList;
import java.util.List;

public class ProjectsPage extends BasePage{

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "createButton")
    WebElement createProjectBtn;
    @FindBy(css = ".defect-title")
    List<WebElement> projectTitles;
    private static final String PROJECT_TITLE = "//*[@class='defect-title' and text()='%s']";


    public NewProjectPage clickOnCreateProjectButton() {
        createProjectBtn.click();
        return new NewProjectPage(driver);
    }

    public ProjectRepositoryPage clickOnProject(String projectName) {
        driver.findElement(By.xpath(String.format(PROJECT_TITLE, projectName))).click();
        return new ProjectRepositoryPage(driver);
    }

    public DeleteProjectPage clickOnDeleteOption(String projectName) {
        new DropDownMenu(driver, projectName).selectDeleteOption();
        return new DeleteProjectPage(driver);
    }

    public boolean isDeletedProjectDisplayed(String projectName) {
        Waiters.waitForElementsBecomeVisible(driver, projectTitles, 5);
        for(WebElement element : projectTitles) {
            if (element.getText().contains(projectName)) {
                return true;
            }
        }   return false;
    }

    public boolean isCreateProjectButtonDisplayed() {
        Waiters.waitForElementLocated(driver, createProjectBtn, 5);
        return createProjectBtn.isDisplayed();
    }
}
