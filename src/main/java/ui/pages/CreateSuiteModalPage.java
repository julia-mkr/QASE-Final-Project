package ui.pages;

import io.qameta.allure.Step;
import ui.elements.InputField;
import ui.elements.TextField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.objects.TestSuite;

public class CreateSuiteModalPage extends ProjectRepositoryPage {

    public CreateSuiteModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "save-suite-button")
    private WebElement createBtn;

    @Step("Enter the suite name: '{testSuite.suiteName}'")
    public ProjectRepositoryPage createSuiteFillingInRequiredFields(TestSuite testSuite) {
        new InputField(driver, SUITE_NAME_LABEL).writeTextIntoInputField(testSuite.getSuiteName());
        clickOnCreateButton();
        return new ProjectRepositoryPage(driver);
    }

    @Step("Enter the suite name: '{testSuite.suiteName}', the description: '{testSuite.description}' " +
            "and the preconditions: '{testSuite.preCondition}'")
    public ProjectRepositoryPage createSuiteFillingInAllFields(TestSuite testSuite) {
        new InputField(driver, SUITE_NAME_LABEL).writeTextIntoInputField(testSuite.getSuiteName());
        new TextField(driver, DESCRIPTION_LABEL).writeTextIntoTextField(testSuite.getDescription());
        new TextField(driver, TS_PRECONDITIONS_LABEL).writeTextIntoTextField(testSuite.getPreCondition());
        clickOnCreateButton();
        return new ProjectRepositoryPage(driver);
    }

    @Step("Click on the 'Create' button")
    public void clickOnCreateButton() {
        createBtn.click();
    }
}
