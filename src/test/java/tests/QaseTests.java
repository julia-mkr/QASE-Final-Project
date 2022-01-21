package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QaseTests extends BaseTest {

    @Test(groups = {"Smoke"}, description = "The signs out from the website")
    @Description("Signing out from the 'qase.io' website")
    public void signOutFromWebsiteTest() {
        loginPage.login(EMAIL, PASSWORD);
        userMenuPage.signOut();
        Assert.assertEquals(loginPage.getCurrentPageUrl(), LOGIN_URL);
        Assert.assertTrue(loginPage.isQaseLogoDisplayed());
    }
}
