package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectsTests extends BaseTest {

    @Test(groups = {"Smoke"}, description = "The test creates a new public project")
    public void createNewProjectTest() {
        loginPage.login(EMAIL, PASSWORD)
                .clickOnCreateProjectButton()
                .createNewPublicProject(PROJECT_TITLE_FOR_CREATION, PROJECT_CODE_FOR_CREATION, TEXT_FOR_PROJECT_DESCRIPTION_FIELD);
        Assert.assertTrue(projectRepositoryPage.isImageOnProjectRepositoryDisplayed());
        Assert.assertEquals(projectRepositoryPage.getTextThatProjectRepositoryIsEmpty(), EXPECTED_EMPTY_REPOSITORY_TEXT);
    }

    @Test(groups = {"Smoke"}, description = "The test deletes a created project")
    public void deleteProjectTest() {
        loginPage.login(EMAIL, PASSWORD)
                .clickOnCreateProjectButton()
                .createNewPublicProject(PROJECT_TITLE_FOR_DELETION, PROJECT_CODE_FOR_DELETION, TEXT_FOR_PROJECT_DESCRIPTION_FIELD);
        navigationMenuPage.clickOnProjectNavigationTab()
                .clickOnDeleteOption(PROJECT_TITLE_FOR_DELETION)
                .confirmDeletingProject();
        Assert.assertFalse(projectsPage.isDeletedProjectDisplayed(PROJECT_TITLE_FOR_DELETION));
    }
}
