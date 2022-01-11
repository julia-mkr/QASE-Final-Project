package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.*;
import ui.objects.TestCase;
import ui.utils.Waiters;

public class CreateTestCasePage extends ProjectRepositoryPage {

    public CreateTestCasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "save-case")
    private WebElement saveBtn;
    @FindBy(xpath = "//*[contains(@class,'add-attachment')]")
    private WebElement addAttachmentBtn;
    @FindBy(id = "add-step")
    private WebElement addStepBtn;
    private static final String SELECTED_OPTION = "//*[text()='%s']//parent::*[contains(@class,'param')]//*[contains(@class,'param-value')]";
    private static final String ENTERED_TEXT = "//*[contains(@class,'preview')]//child::*[text()='%s']";

    public ProjectRepositoryPage createTestCaseFillingInRequiredFields(TestCase testCase) {
        Waiters.waitForElementLocated(driver, saveBtn, 5);
        new InputField(driver, TITLE_LABEL).writeTextIntoInputField(testCase.getTitle());
        clickOnSaveButton();
        return new ProjectRepositoryPage(driver);
    }

    public ProjectRepositoryPage createTestCaseFillingInRequiredFieldsAndSelectingOptionsFromDropdowns(TestCase testCase) {
        Waiters.waitForElementLocated(driver, saveBtn, 5);
        new InputField(driver, TITLE_LABEL).writeTextIntoInputField(testCase.getTitle());
        new DropDown(driver, SUITE_DROPDOWN_LABEL).selectOption(testCase.getSuite());
        new DropDown(driver, PRIORITY_DROPDOWN_LABEL).selectOption(testCase.getPriority());
        new DropDown(driver, TYPE_DROPDOWN_LABEL).selectOption(testCase.getType());
        new DropDown(driver, LAYER_DROPDOWN_LABEL).selectOption(testCase.getLayer());
        new DropDown(driver, AUTOMATION_STATUS_DROPDOWN_LABEL).selectOption(testCase.getAutomationStatus());
        clickOnSaveButton();
        return new ProjectRepositoryPage(driver);
    }

    public ProjectRepositoryPage createTestCaseFillingInInputFields(TestCase testCase) {
        Waiters.waitForElementLocated(driver, saveBtn, 5);
        new InputField(driver, TITLE_LABEL).writeTextIntoInputField(testCase.getTitle());
        new TextField(driver, DESCRIPTION_LABEL).writeTextIntoTextField(testCase.getDescription());
        new TextField(driver, PRE_CONDITIONS_LABEL).writeTextIntoTextField(testCase.getPreConditions());
        new TextField(driver, POST_CONDITIONS_LABEL).writeTextIntoTextField(testCase.getPostConditions());
        clickOnAddStepButton();
        new TextField(driver, ACTION_LABEL).writeTextIntoTextField(testCase.getAction());
        new TextField(driver, INPUT_DATA_LABEL).writeTextIntoTextField(testCase.getInputData());
        new TextField(driver, EXPECTED_RESULT_LABEL).writeTextIntoTextField(testCase.getExpectedResult());
        clickOnSaveButton();
        return new ProjectRepositoryPage(driver);
    }

    public ProjectRepositoryPage createTestSuiteFillingInSomeFieldsAndAttachingFile(TestCase testCase, String fileName) {
        Waiters.waitForElementLocated(driver, saveBtn, 5);
        new InputField(driver, TITLE_LABEL).writeTextIntoInputField(testCase.getTitle());
        new TextField(driver, DESCRIPTION_LABEL).writeTextIntoTextField(testCase.getDescription());
        clickOnAddAttachmentButton();
        UploadFileModalPage.uploadFile(fileName);
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

    public boolean isOptionDisplayed(String label) {
        return driver.findElement(By.xpath(String.format(SELECTED_OPTION, label))).isDisplayed();
    }

    public boolean isEnteredTextDisplayed(String text) {
        return driver.findElement(By.xpath(String.format(ENTERED_TEXT, text))).isDisplayed();
    }
}
