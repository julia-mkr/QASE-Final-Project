package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

@Log4j2
public class InvitesPage extends WorkspacePage {

    public InvitesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class,'btn') and contains(text(), 'Invite new')]")
    private WebElement inviteNewMemberBtn;
    private static final String MEMBER_NAME = "//span[contains (@class,'member-name') and text()='%s']";
    private static final String MEMBER_EMAIL = "//span[contains (@class,'member-role') and text()='%s']";
    private static final String MEMBER_ROLE_TITLE = "//*[contains (@class,'invite') and text()='%s']";

    @Step("Click on the 'Invite new member' button")
    public InviteNewUserModalPage clickOnInviteNewMemberButton() {
        Waiters.waitForElementLocated(driver, inviteNewMemberBtn, 5);
        log.info("Clicking on the 'Invite new member' button on the 'Invites' page");
        inviteNewMemberBtn.click();
        return new InviteNewUserModalPage(driver);
    }

    @Step("Verify, that the member name: '{name}' is displayed on the 'Invites' page")
    public boolean isMemberNameDisplayed(String name) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(MEMBER_NAME, name)), 5);
        return driver.findElement(By.xpath(String.format(MEMBER_NAME, name))).isDisplayed();
    }

    @Step("Verify, that the member email: '{email}' is displayed on the 'Invites' page")
    public boolean isMemberEmailDisplayed(String email) {
        return driver.findElement(By.xpath(String.format(MEMBER_EMAIL, email))).isDisplayed();
    }

    @Step("Verify, that the member role title: '{roleTitle}' is displayed on the 'Invites' page")
    public boolean isMemberRoleTitleDisplayed(String roleTitle) {
        return driver.findElement(By.xpath(String.format(MEMBER_ROLE_TITLE, roleTitle))).isDisplayed();
    }
}
