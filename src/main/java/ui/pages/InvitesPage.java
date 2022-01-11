package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

public class InvitesPage extends WorkspacePage {

    public InvitesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class,'btn') and contains(text(), 'Invite new')]")
    private WebElement inviteNewMemberBtn;
    private static final String MEMBER_NAME = "//span[contains (@class,'member-name') and text()='%s']";
    private static final String MEMBER_EMAIL = "//span[contains (@class,'member-role') and text()='%s']";
    private static final String MEMBER_ROLE_TITLE = "//*[contains (@class,'invite') and text()='%s']";

    public InviteNewUserModalPage clickOnInviteNewMemberButton() {
        Waiters.waitForElementLocated(driver, inviteNewMemberBtn, 5);
        inviteNewMemberBtn.click();
        return new InviteNewUserModalPage(driver);
    }

    public boolean isMemberNameDisplayed(String name) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(MEMBER_NAME, name)), 5);
        return driver.findElement(By.xpath(String.format(MEMBER_NAME, name))).isDisplayed();
    }
    public boolean isMemberEmailDisplayed(String email) {
        return driver.findElement(By.xpath(String.format(MEMBER_EMAIL, email))).isDisplayed();
    }
    public boolean isMemberRoleTitleDisplayed(String roleTitle) {
        return driver.findElement(By.xpath(String.format(MEMBER_ROLE_TITLE, roleTitle))).isDisplayed();
    }
}
