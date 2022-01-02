package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.utils.PropertyReader;

public class ProjectsTests extends BaseTest {

    @Test
    public void createNewProjectTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnCreateProjectButton()
                .createNewPublicProject("Project 2", "Proj2", "Some description for this project");
        Assert.assertTrue(projectRepositoryPage.isImageOnProjectRepositoryDisplayed());
        Assert.assertEquals(projectRepositoryPage.getTextOnProjectRepository(), "Looks like you don’t have any suites and cases yet.");
    }

    @Test
    public void deleteProjectTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnCreateProjectButton()
                .createNewPublicProject("Project 3.0", "Project3", "Some description for the project")
                .clickOnProjectTab()
                .clickOnDeleteOption("Project 3.0")
                .confirmDeletingProject();
        Assert.assertFalse(projectsPage.isDeletedProjectDisplayed("Project 3.0"));
    }
}
