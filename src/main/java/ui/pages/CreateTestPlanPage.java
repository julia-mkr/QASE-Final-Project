package ui.pages;

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

    public TestPlansPage createTestPlanFillingInAllFieldsAndAddingTestCases(String title, String description, String suiteName) {
        new InputField(driver, TITLE_LABEL).writeTextIntoInputField(title);
        new TextField(driver, DESCRIPTION_LABEL).writeTextIntoTextField(description);
        clickOnAddCasesButton();
        selectSuite(suiteName);
        clickOnCreatePlanButton();
        return new TestPlansPage(driver);
    }

    private void clickOnCreatePlanButton() {
        createPlanBtn.click();
    }

    private void clickOnAddCasesButton() {
        addCasesBtn.click();
    }

    public void selectSuite(String suiteName) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(SUITE_CHECKBOX, suiteName)), 5);
        driver.findElement(By.xpath(String.format(SUITE_CHECKBOX, suiteName))).click();
        clickOnDoneButton();
    }

    private void clickOnDoneButton() {
        doneBtn.click();
    }
}
