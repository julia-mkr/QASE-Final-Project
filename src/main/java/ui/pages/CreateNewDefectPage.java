package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.*;
import ui.objects.*;
import ui.utils.Waiters;

public class CreateNewDefectPage extends DefectsPage {

    public CreateNewDefectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(@class,'save-button')]")
    private WebElement createDefectButton;
    @FindBy(xpath = "//*[contains(@class,'add-attachment')]")
    private WebElement addAttachmentBtn;


    public DefectsPage createNewDefectFillingInRequiredFields(Defect defect) {
        Waiters.waitForElementLocated(driver, createDefectButton, 5);
        new InputField(driver, DEFECT_TITLE_LABEL).writeTextIntoInputField(defect.getDefectTitle());
        new TextField(driver, ACTUAL_RESULT_LABEL).writeTextIntoTextField(defect.getActualResult());
        clickOnCreateDefectButton();
        return new DefectsPage(driver);
    }

    public DefectsPage createNewDefectFillingInAllFields(Defect defect) {
        Waiters.waitForElementLocated(driver, createDefectButton, 5);
        new InputField(driver, DEFECT_TITLE_LABEL).writeTextIntoInputField(defect.getDefectTitle());
        new TextField(driver, ACTUAL_RESULT_LABEL).writeTextIntoTextField(defect.getActualResult());
        new DropDown(driver, MILESTONE_LABEL).selectOption(defect.getMilestones());
        new DropDown(driver, SEVERITY_LABEL).selectOption(defect.getSeverity());
        new AssigneeDropdown(driver).selectAssigneeName(defect.getAssignee());
        clickOnCreateDefectButton();
        return new DefectsPage(driver);
    }

    public DefectsPage createNewDefectFillingInRequiredFieldsAndAttachingFile(Defect defect, String fileName) {
        Waiters.waitForElementLocated(driver, createDefectButton, 5);
        new InputField(driver, DEFECT_TITLE_LABEL).writeTextIntoInputField(defect.getDefectTitle());
        new TextField(driver, ACTUAL_RESULT_LABEL).writeTextIntoTextField(defect.getActualResult());
        clickOnAddAttachmentButton();
        UploadFileModalPage.uploadFile(fileName);
        clickOnCreateDefectButtonWithJs();
        return new DefectsPage(driver);
    }

    public DefectsPage createNewDefectFillingInRequiredFieldsAndSelectingSeverity(Defect defect) {
        Waiters.waitForElementLocated(driver, createDefectButton, 5);
        new InputField(driver, DEFECT_TITLE_LABEL).writeTextIntoInputField(defect.getDefectTitle());
        new TextField(driver, ACTUAL_RESULT_LABEL).writeTextIntoTextField(defect.getActualResult());
        new DropDown(driver, SEVERITY_LABEL).selectOption(defect.getSeverity());
        clickOnCreateDefectButton();
        return new DefectsPage(driver);
    }

    private void clickOnCreateDefectButton() {
        createDefectButton.click();
    }

    private void clickOnCreateDefectButtonWithJs() {
        jsClick(createDefectButton);
    }

    private void clickOnAddAttachmentButton() {
        jsClick(addAttachmentBtn);
    }
}
