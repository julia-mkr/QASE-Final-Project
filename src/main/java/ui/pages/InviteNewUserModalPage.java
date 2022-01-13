package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.InputField;
import ui.objects.InvitationOfNewUser;
import ui.utils.Waiters;

public class InviteNewUserModalPage extends InvitesPage {

    public InviteNewUserModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'btn') and text()='Invite']")
    private WebElement inviteBtn;
    @FindBy (xpath = "//*[@id='emailGroup']//child::*[contains(@class,'feedback')]")
    private WebElement emptyEmailMessage;
    @FindBy (xpath = "//*[@id='role_titleGroup']//child::*[contains(@class,'feedback')]")
    private WebElement emptyRoleTitleMessage;
    @FindBy (xpath = "//*[@id='emailGroup']//child::*[contains(@class,'feedback')]")
    private WebElement invalidEmailMessage;

    public InvitesPage inviteNewUserFillingInAllInputFields(InvitationOfNewUser invitationOfNewUser) {
        new InputField(driver, "Email").writeTextIntoInputField(invitationOfNewUser.getEmail());
        new InputField(driver, "Name").writeTextIntoInputField(invitationOfNewUser.getName());
        new InputField(driver, "Role title").writeTextIntoInputField(invitationOfNewUser.getRoleTitle());
        clickOnInviteButton();
        return new InvitesPage(driver);
    }

    public InvitesPage inviteNewUserUsingInvalidData(InvitationOfNewUser invitationOfNewUser) {
        new InputField(driver, "Email").writeTextIntoInputField(invitationOfNewUser.getEmail());
        new InputField(driver, "Name").writeTextIntoInputField(invitationOfNewUser.getName());
        new InputField(driver, "Role title").writeTextIntoInputField(invitationOfNewUser.getRoleTitle());
        clickOnInviteButton();
        return this;
    }

    public String getEmptyEmailErrorMessage() {
        Waiters.waitForElementLocated(driver, emptyEmailMessage, 5);
        return emptyEmailMessage.getText();
    }

    public String getEmptyRoleTitleErrorMessage() {
        Waiters.waitForElementLocated(driver, emptyRoleTitleMessage, 5);
        return emptyRoleTitleMessage.getText();
    }

    public String getInvalidEmailErrorMessage() {
        Waiters.waitForElementLocated(driver, invalidEmailMessage, 5);
        return invalidEmailMessage.getText();
    }

    public void clickOnInviteButton() {
        inviteBtn.click();
    }
}
