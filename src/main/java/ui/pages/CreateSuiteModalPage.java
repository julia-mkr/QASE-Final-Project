package ui.pages;

import ui.elements.InputField;
import ui.elements.TextField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.objects.TestSuite;

public class CreateSuiteModalPage extends BasePage {

    public CreateSuiteModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "save-suite-button")
    WebElement createBtn;

    public ProjectRepositoryPage createSuiteFillingInRequiredFields(TestSuite testSuite) {
        new InputField(driver, "Suite name").writeTextIntoInputField(testSuite.getSuiteName());
        clickOnCreateButton();
        return new ProjectRepositoryPage(driver);
    }

    public ProjectRepositoryPage createSuiteFillingInAllFields(TestSuite testSuite) {
        new InputField(driver, "Suite name").writeTextIntoInputField(testSuite.getSuiteName());
        new TextField(driver, "Description").writeTextIntoInputField(testSuite.getDescription());
        new TextField(driver, "Preconditions").writeTextIntoInputField(testSuite.getPreCondition());
        clickOnCreateButton();
        return new ProjectRepositoryPage(driver);
    }

    public void clickOnCreateButton() {
        createBtn.click();
    }
}
