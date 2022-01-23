package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.InputField;
import ui.objects.InvitationOfNewUser;
import ui.utils.Waiters;

@Log4j2
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

    @Step("Create an invitation of new member filling in the email: '{invitationOfNewUser.email}', " +
            "the name: '{invitationOfNewUser.name}' and the role title: '{invitationOfNewUser.roleTitle}'")
    public InvitesPage inviteNewUserFillingInAllInputFields(InvitationOfNewUser invitationOfNewUser) {
        new InputField(driver, "Email").writeTextIntoInputField(invitationOfNewUser.getEmail());
        new InputField(driver, "Name").writeTextIntoInputField(invitationOfNewUser.getName());
        new InputField(driver, "Role title").writeTextIntoInputField(invitationOfNewUser.getRoleTitle());
        clickOnInviteButton();
        return new InvitesPage(driver);
    }

    @Step("Create an invitation of new member with invalid data entering the email: '{invitationOfNewUser.email}', " +
            "the name: '{invitationOfNewUser.name}' and the role title: '{invitationOfNewUser.roleTitle}'")
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

    @Step("Click in the 'Invite' button")
    public void clickOnInviteButton() {
        log.info("Clicking on the 'Invite' button");
        inviteBtn.click();
    }
}
