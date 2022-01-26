package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import ui.elements.InputField;
import ui.utils.Waiters;

@Log4j2
public class CreateGroupPage extends UserGroupsPage {

    public CreateGroupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputDescription")
    private WebElement descriptionField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createBtn;
    @FindBy(xpath = "//*[contains(@class, 'feedback')]")
    private WebElement emptyDescriptionFieldMessage;

    @Step("Create a group filling in all the fields and entering the group title: " +
            "'{groupTitle}' and the description: '{description}'")
    public UserGroupsPage createGroupFillingInAllFields(String groupTitle, String description) {
        Waiters.waitForElementLocated(driver, createBtn, 5);
        new InputField(driver, GROUP_TITLE_LABEL).writeTextIntoInputField(groupTitle);
        log.info("Typing the group description " + description + " into the 'Description' field");
        descriptionField.sendKeys(description);
        clickOnCreateButton();
        return new UserGroupsPage (driver);
    }

    @Step("Create a group filling in the group title: '{groupTitle}' and leave the description field blank")
    public CreateGroupPage createGroupFillingInOneOfRequiredFields(String groupTitle, String description) {
        Waiters.waitForElementLocated(driver, createBtn, 5);
        new InputField(driver, GROUP_TITLE_LABEL).writeTextIntoInputField(groupTitle);
        log.info("Typing the group description " + description + " into the 'Description' field");
        descriptionField.sendKeys(description);
        clickOnCreateButton();
        return this;
    }

    @Step("Click on the 'Create' button")
    public void clickOnCreateButton() {
        log.info("Clicking on the 'Create' button");
        createBtn.click();
    }

    public String getEmptyDescriptionFieldErrorMessage() {
        Waiters.waitForElementLocated(driver, emptyDescriptionFieldMessage, 5);
        return emptyDescriptionFieldMessage.getText();
    }
}
