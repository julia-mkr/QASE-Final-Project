package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.utils.PropertyReader;

public class ProjectsTests extends BaseTest {

    @Test
    public void createNewProjectTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnCreateProjectButton()
                .createNewPublicProject("Project 2.5", "Proj25", TEXT_FOR_PROJECT_DESCRIPTION_FIELD);
        Assert.assertTrue(projectRepositoryPage.isImageOnProjectRepositoryDisplayed());
        Assert.assertEquals(projectRepositoryPage.getTextThatProjectRepositoryIsEmpty(), EXPECTED_EMPTY_REPOSITORY_TEXT);
    }

    @Test
    public void deleteProjectTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnCreateProjectButton()
                .createNewPublicProject("Project 3.0", "Proj3", TEXT_FOR_PROJECT_DESCRIPTION_FIELD)
                .clickOnNavigationTab("Projects")
                .clickOnDeleteOption("Project 3.0")
                .confirmDeletingProject();
        Assert.assertFalse(projectsPage.isDeletedProjectDisplayed("Project 3.0"));
    }
}
