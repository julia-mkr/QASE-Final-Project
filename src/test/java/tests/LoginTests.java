package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.utils.PropertyReader;

public class LoginTests extends BaseTest {

    @Test
    public void loginUsingValidDataTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        Assert.assertTrue(projectsPage.isCreateProjectButtonDisplayed());
    }

    @Test
    public void loginUsingInvalidEmailTest() {
        loginPage.login(System.getProperty("invalidEmail", PropertyReader.getProperty("invalidEmail")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        Assert.assertEquals(loginPage.getErrorMessage(), "These credentials do not match our records.");
    }
 }
