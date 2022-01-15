package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.utils.PropertyReader;

public class QaseTests extends BaseTest {

    @Test(groups = {"Smoke"}, description = "The signs out from the website")
    public void signOutFromWebsiteTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        userMenuPage.signOut();
        Assert.assertEquals(loginPage.getCurrentPageUrl(), LOGIN_URL);
        Assert.assertTrue(loginPage.isQaseLogoDisplayed());
    }
}
