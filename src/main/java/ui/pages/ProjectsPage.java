package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import ui.elements.ProjectsDropdown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

import java.util.List;

@Log4j2
public class ProjectsPage extends BasePage{

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "createButton")
    private WebElement createProjectBtn;
    @FindBy(css = ".defect-title")
    private List<WebElement> projectTitles;

    @Step("Click on the 'Create Project' button")
    public NewProjectPage clickOnCreateProjectButton() {
        log.info("Clicking on the 'Create Project' button");
        createProjectBtn.click();
        return new NewProjectPage(driver);
    }

    @Step("Click on the project: '{projectName}'")
    public ProjectRepositoryPage clickOnProject(String projectName) {
        Waiters.waitForElementsBecomeVisible(driver, projectTitles, 5);
        log.info("Clicking on the " + projectName + " project");
        projectTitles.stream()
                .filter(title -> title.getText().matches(projectName))
                .forEach(WebElement::click);
        return new ProjectRepositoryPage(driver);
    }

    @Step("Delete the project:'{projectName}' clicking on the 'Delete' option")
    public DeleteProjectPage clickOnDeleteOption(String projectName) {
        new ProjectsDropdown(driver, projectName).selectDeleteOption();
        return new DeleteProjectPage(driver);
    }

    @Step("Verify, that the deleted '{projectName}' project is not displayed")
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
