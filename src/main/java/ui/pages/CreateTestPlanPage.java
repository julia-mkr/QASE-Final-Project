package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.InputField;
import ui.elements.TextField;
import ui.utils.Waiters;

public class CreateTestPlanPage extends TestPlansPage {

    public CreateTestPlanPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "save-plan")
    private WebElement createPlanBtn;
    @FindBy(id = "edit-plan-add-cases-button")
    private WebElement addCasesBtn;
    @FindBy(id = "select-cases-done-button")
    private WebElement doneBtn;
    private static final String SUITE_CHECKBOX = "//*[text()='%s']//ancestor::*[contains (@id, 'suite')]//span";

    @Step("Enter the title: '{title}', the description: '{description}', and select the '{suiteName}' suite")
    public TestPlansPage createTestPlanFillingInAllFieldsAndAddingTestCases(String title, String description, String suiteName) {
        new InputField(driver, TITLE_LABEL).writeTextIntoInputField(title);
        new TextField(driver, DESCRIPTION_LABEL).writeTextIntoTextField(description);
        clickOnAddCasesButton();
        selectSuite(suiteName);
        clickOnCreatePlanButton();
        return new TestPlansPage(driver);
    }

    @Step("Click on the 'Create plan' button")
    public void clickOnCreatePlanButton() {
        createPlanBtn.click();
    }

    @Step("Click on the 'Add cases' button")
    public void clickOnAddCasesButton() {
        addCasesBtn.click();
    }

    @Step("Select the suite: '{suiteName}'")
    public void selectSuite(String suiteName) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(SUITE_CHECKBOX, suiteName)), 5);
        driver.findElement(By.xpath(String.format(SUITE_CHECKBOX, suiteName))).click();
        clickOnDoneButton();
    }

    @Step("Click on the 'Done' button")
    public void clickOnDoneButton() {
        doneBtn.click();
    }
}
