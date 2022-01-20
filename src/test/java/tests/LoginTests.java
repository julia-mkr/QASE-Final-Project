package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(groups = {"Smoke"}, description = "The test logs in to the website using valid email and password")
    public void loginUsingValidDataTest() {
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(projectsPage.isCreateProjectButtonDisplayed());
    }

    @Test(groups = {"Critical"}, description = "The test logs in to the website using an invalid email")
    public void loginUsingInvalidEmailTest() {
        loginPage.login(INVALID_EMAIL, PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), EXPECTED_LOGIN_ERROR_MESSAGE);
    }
 }
