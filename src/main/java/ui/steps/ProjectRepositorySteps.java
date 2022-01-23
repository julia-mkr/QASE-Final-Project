package ui.steps;

import org.openqa.selenium.WebDriver;
import ui.pages.LoginPage;
import ui.pages.ProjectRepositoryPage;
import ui.pages.ProjectsPage;

public class ProjectRepositorySteps {

    private LoginPage loginPage;
    private ProjectsPage projectsPage;

    public ProjectRepositorySteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
    }

    public ProjectRepositoryPage loginAndClickOnProject(WebDriver driver, String email, String password, String projectTitle) {
        loginPage.login(email, password)
                .clickOnProject(projectTitle);
        return new ProjectRepositoryPage(driver);
    }
}
