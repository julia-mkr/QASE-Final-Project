package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.*;
import ui.objects.TestCase;
import ui.utils.Waiters;

@Log4j2
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

    @Step("Create a new test case filling in the required fields entering the case title: '{testCase.title}' into the input field")
    public ProjectRepositoryPage createTestCaseFillingInRequiredFields(TestCase testCase) {
        Waiters.waitForElementLocated(driver, saveBtn, 5);
        new InputField(driver, TITLE_LABEL).writeTextIntoInputField(testCase.getTitle());
        clickOnSaveButton();
        return new ProjectRepositoryPage(driver);
    }

    @Step("Create a new test case entering the case title: '{testCase.title}' into the input field and select " +
            "the 'Suite' value: '{testCase.suite}', " +
            "the 'Priority' value: '{testCase.priority}', the 'Type' value: '{testCase.type}', " +
            "the 'Layer' value: '{testCase.layer}', " +
            "the 'Automation status' value: '{testCase.automationStatus}' from the dropdown menu")
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

    @Step("Create a new test case entering the case title: '{testCase.title}', the description: '{testCase.description}', " +
            "the preconditions: '{testCase.preConditions}', the post-conditions: '{testCase.postConditions}'," +
            " the action: '{testCase.action}', the input data: '{testCase.inputData}', and the expected result: " +
            "'{testCase.expectedResult}' into the input fields")
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

    @Step("Create a new test case entering the case title: '{testCase.title}', the description: '{testCase.description}' " +
            "into the input fields and " +
            "attach the '{fileName}' file")
    public ProjectRepositoryPage createTestcaseFillingInSomeFieldsAndAttachingFile(TestCase testCase, String fileName) {
        Waiters.waitForElementLocated(driver, saveBtn, 5);
        new InputField(driver, TITLE_LABEL).writeTextIntoInputField(testCase.getTitle());
        new TextField(driver, DESCRIPTION_LABEL).writeTextIntoTextField(testCase.getDescription());
        clickOnAddAttachmentButton();
        UploadFileModalPage.uploadFile(fileName);
        clickOnSaveButton();
        return new ProjectRepositoryPage(driver);
    }

    @Step("Click on the 'Save' button")
    public void clickOnSaveButton() {
        log.info("Clicking on the 'Save' button");
        saveBtn.click();
    }

    @Step("Click on the 'Add attachment' button")
    public void clickOnAddAttachmentButton() {
        Waiters.waitForElementLocated(driver, addAttachmentBtn, 5);
        log.info("Clicking on the 'Add attachment' button with JS");
        jsClick(addAttachmentBtn);
    }

    @Step("Click on the 'Add step' button")
    public void clickOnAddStepButton() {
        Waiters.waitForElementLocated(driver, addStepBtn, 5);
        log.info("Clicking on the 'Add step' button with JS");
        jsClick(addStepBtn);
    }

    @Step("Verify, that selected option: '{label}' is displayed")
    public boolean isOptionDisplayed(String label) {
        return driver.findElement(By.xpath(String.format(SELECTED_OPTION, label))).isDisplayed();
    }

    @Step("Verify, that entered text: '{text}' is displayed")
    public boolean isEnteredTextDisplayed(String text) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(ENTERED_TEXT, text)), 5);
        return driver.findElement(By.xpath(String.format(ENTERED_TEXT, text))).isDisplayed();
    }
}
