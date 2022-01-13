package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.utils.PropertyReader;

public class ProjectsTests extends BaseTest {

    @Test
    public void createNewProjectTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnCreateProjectButton()
                .createNewPublicProject(PROJECT_TITLE_FOR_CREATION, PROJECT_CODE_FOR_CREATION, TEXT_FOR_PROJECT_DESCRIPTION_FIELD);
        Assert.assertTrue(projectRepositoryPage.isImageOnProjectRepositoryDisplayed());
        Assert.assertEquals(projectRepositoryPage.getTextThatProjectRepositoryIsEmpty(), EXPECTED_EMPTY_REPOSITORY_TEXT);
    }

    @Test
    public void deleteProjectTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnCreateProjectButton()
                .createNewPublicProject(PROJECT_TITLE_FOR_DELETION, PROJECT_CODE_FOR_DELETION, TEXT_FOR_PROJECT_DESCRIPTION_FIELD);
        navigationMenuPage.clickOnProjectNavigationTab()
                .clickOnDeleteOption(PROJECT_TITLE_FOR_DELETION)
                .confirmDeletingProject();
        Assert.assertFalse(projectsPage.isDeletedProjectDisplayed(PROJECT_TITLE_FOR_DELETION));
    }
}
