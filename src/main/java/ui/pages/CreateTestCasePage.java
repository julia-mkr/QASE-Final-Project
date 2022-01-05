package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.*;
import ui.objects.TestCase;
import ui.utils.Waiters;

public class CreateTestCasePage extends BasePage {

    public CreateTestCasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "save-case")
    WebElement saveBtn;
    @FindBy(xpath = "//*[contains(@class,'add-attachment')]")
    WebElement addAttachmentBtn;
    @FindBy(id = "add-step")
    WebElement addStepBtn;

    public ProjectRepositoryPage createTestCaseFillingInRequiredFields(TestCase testCase) {
        Waiters.waitForElementLocated(driver, saveBtn, 5);
        new InputField(driver, "Title").writeTextIntoInputField(testCase.getTitle());
        clickOnSaveButton();
        return new ProjectRepositoryPage(driver);
    }

    public ProjectRepositoryPage createTestCaseFillingInRequiredFieldsAndSelectingOptionsFromDropdowns(TestCase testCase) {
        Waiters.waitForElementLocated(driver, saveBtn, 5);
        new InputField(driver, "Title").writeTextIntoInputField(testCase.getTitle());
        new DropDown(driver, "Suite").selectOptionFromDropdown(testCase.getSuite());
        new DropDown(driver, "Priority").selectOptionFromDropdown(testCase.getPriority());
        new DropDown(driver, "Type").selectOptionFromDropdown(testCase.getType());
        new DropDown(driver, "Layer").selectOptionFromDropdown(testCase.getLayer());
        new DropDown(driver, "Automation status").selectOptionFromDropdown(testCase.getAutomationStatus());
        clickOnSaveButton();
        return new ProjectRepositoryPage(driver);
    }

    public ProjectRepositoryPage createTestCaseFillingInInputFields(TestCase testCase) {
        Waiters.waitForElementLocated(driver, saveBtn, 5);
        new InputField(driver, "Title").writeTextIntoInputField(testCase.getTitle());
        new TextField(driver, "Description").writeTextIntoInputField(testCase.getDescription());
        new TextField(driver, "Pre-conditions").writeTextIntoInputField(testCase.getPreConditions());
        new TextField(driver, "Post-conditions").writeTextIntoInputField(testCase.getPostConditions());
        clickOnAddStepButton();
        new TextField(driver, "Action").writeTextIntoInputField(testCase.getAction());
        new TextField(driver, "Input data").writeTextIntoInputField(testCase.getInputData());
        new TextField(driver, "Expected result").writeTextIntoInputField(testCase.getExpectedResult());
        clickOnSaveButton();
        return new ProjectRepositoryPage(driver);
    }

    public ProjectRepositoryPage createTestSuiteFillingInSomeFieldsAndAttachingFile(TestCase testCase, String fileName) {
        Waiters.waitForElementLocated(driver, saveBtn, 5);
        new InputField(driver, "Title").writeTextIntoInputField(testCase.getTitle());
        new TextField(driver, "Description").writeTextIntoInputField(testCase.getDescription());
        clickOnAddAttachmentButton();
        uploadFile(fileName);
        clickOnSaveButton();
        return new ProjectRepositoryPage(driver);
    }

    public void clickOnSaveButton() {
        saveBtn.click();
    }

    public void clickOnAddAttachmentButton() {
        Waiters.waitForElementLocated(driver, addAttachmentBtn, 5);
        jsClick(addAttachmentBtn);
    }

    public void clickOnAddStepButton() {
        Waiters.waitForElementLocated(driver, addStepBtn, 5);
        jsClick(addStepBtn);
    }
}
