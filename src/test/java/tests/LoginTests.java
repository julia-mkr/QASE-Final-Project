package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.utils.PropertyReader;

public class LoginTests extends BaseTest {

    @Test(groups = {"Smoke"}, description = "The test logs into the website using valid email and password")
    public void loginUsingValidDataTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        Assert.assertTrue(projectsPage.isCreateProjectButtonDisplayed());
    }

    @Test(groups = {"Critical"}, description = "The test logs into the website using an invalid email")
    public void loginUsingInvalidEmailTest() {
        loginPage.login(System.getProperty("invalidEmail", PropertyReader.getProperty("invalidEmail")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        Assert.assertEquals(loginPage.getErrorMessage(), EXPECTED_LOGIN_ERROR_MESSAGE);
    }
 }
