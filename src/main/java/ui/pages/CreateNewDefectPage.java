package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.*;
import ui.objects.*;
import ui.utils.Waiters;

@Log4j2
public class CreateNewDefectPage extends DefectsPage {

    public CreateNewDefectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(@class,'save-button')]")
    private WebElement createDefectButton;
    @FindBy(xpath = "//*[contains(@class,'add-attachment')]")
    private WebElement addAttachmentBtn;
    @FindBy(xpath = "//*[contains(@id,'Group')]//p")
    private WebElement actualResultField;


    @Step("Create a new defect entering the defect title: '{defect.defectTitle}' and the actual result: '{defect.actualResult}'")
    public DefectsPage createNewDefectFillingInRequiredFields(Defect defect) {
        Waiters.waitForElementLocated(driver, createDefectButton, 10);
        new InputField(driver, DEFECT_TITLE_LABEL).writeTextIntoInputField(defect.getDefectTitle());
        new TextField(driver, ACTUAL_RESULT_LABEL).writeTextIntoTextField(defect.getActualResult());
        clickOnCreateDefectButton();
        return new DefectsPage(driver);
    }

    @Step("Create a new defect entering the defect title: '{defect.defectTitle}' and the actual result: '{defect.actualResult}'" +
            " and select the 'Milestone' value: '{defect.milestones}', the 'Severity' value: '{defect.severity}', and " +
            "the 'Assignee' name: '{defect.assignee}'")
    public DefectsPage createNewDefectFillingInAllFields(Defect defect) {
        Waiters.waitForElementLocated(driver, createDefectButton, 10);
        new InputField(driver, DEFECT_TITLE_LABEL).writeTextIntoInputField(defect.getDefectTitle());
        new TextField(driver, ACTUAL_RESULT_LABEL).writeTextIntoTextField(defect.getActualResult());
        new DropDown(driver, MILESTONE_LABEL).selectOption(defect.getMilestones());
        new DropDown(driver, SEVERITY_LABEL).selectOption(defect.getSeverity());
        new AssigneeDropdown(driver).selectAssigneeName(defect.getAssignee());
        clickOnCreateDefectButton();
        return new DefectsPage(driver);
    }

    @Step("Create a new defect entering the defect title: '{defect.defectTitle}', the actual result: '{defect.actualResult}'" +
            " and attach the '{filename}' file")
    public DefectsPage createNewDefectFillingInRequiredFieldsAndAttachingFile(Defect defect, String fileName) {
        Waiters.waitForElementLocated(driver, createDefectButton, 10);
        new InputField(driver, DEFECT_TITLE_LABEL).writeTextIntoInputField(defect.getDefectTitle());
        Waiters.waitForElementLocated(driver, actualResultField, 10);
        actualResultField.sendKeys(defect.getActualResult());
        clickOnAddAttachmentButton();
        UploadFileModalPage.uploadFile(driver, fileName);
        clickOnCreateDefectButtonWithJs();
        return new DefectsPage(driver);
    }

    @Step("Create a new defect entering the defect title: '{defect.defectTitle}', the actual result: '{defect.actualResult}' " +
            "and select the 'Severity' value: '{defect.severity}'")
    public DefectsPage createNewDefectFillingInRequiredFieldsAndSelectingSeverity(Defect defect) {
        Waiters.waitForElementLocated(driver, createDefectButton, 10);
        new InputField(driver, DEFECT_TITLE_LABEL).writeTextIntoInputField(defect.getDefectTitle());
        Waiters.waitForElementLocated(driver, actualResultField, 10);
        actualResultField.sendKeys(defect.getActualResult());
        new DropDown(driver, SEVERITY_LABEL).selectOption(defect.getSeverity());
        clickOnCreateDefectButton();
        return new DefectsPage(driver);
    }

    @Step("Click on the 'Create defect' button")
    public void clickOnCreateDefectButton() {
        log.info("Clicking on the 'Create defect' button");
        createDefectButton.click();
    }

    @Step("Click on the 'Create defect' button using JS")
    public void clickOnCreateDefectButtonWithJs() {
        log.info("Clicking on the 'Create defect' button with JS");
        jsClick(createDefectButton);
    }

    @Step("Click on the 'Add attachment' button")
    public void clickOnAddAttachmentButton() {
        Waiters.waitForElementLocated(driver, addAttachmentBtn, 5);
        log.info("Clicking on the 'Add attachment' button with JS");
        jsClick(addAttachmentBtn);
    }
}
