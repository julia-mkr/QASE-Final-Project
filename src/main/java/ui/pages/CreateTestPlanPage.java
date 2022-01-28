package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.InputField;
import ui.elements.TextField;
import ui.utils.Waiters;

@Log4j2
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

    @Step("Create a test plan with the title: '{title}', the description: '{description}', and add the '{suiteName}' suite to it")
    public TestPlansPage createTestPlanFillingInAllFieldsAndAddingTestCases(String title, String description, String suiteName) throws InterruptedException {
        Waiters.waitForElementLocated(driver, createPlanBtn, 5);
        new InputField(driver, TITLE_LABEL).writeTextIntoInputField(title);
        new TextField(driver, DESCRIPTION_LABEL).writeTextIntoTextField(description);
        clickOnAddCasesButton();
        selectSuite(suiteName);
        clickOnCreatePlanButton();
        return new TestPlansPage(driver);
    }

    @Step("Click on the 'Create plan' button")
    public void clickOnCreatePlanButton() {
        log.info("Clicking on the 'Create plan' button");
        createPlanBtn.click();
    }

    @Step("Click on the 'Add cases' button")
    public void clickOnAddCasesButton() {
        Waiters.waitForElementLocated(driver, addCasesBtn, 5);
        log.info("Clicking on the 'Add cases' button");
        addCasesBtn.click();
    }

    @Step("Select the suite: '{suiteName}'")
    public void selectSuite(String suiteName) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(SUITE_CHECKBOX, suiteName)), 5);
        log.info("Selecting the " + suiteName + " suite");
        driver.findElement(By.xpath(String.format(SUITE_CHECKBOX, suiteName))).click();
        clickOnDoneButton();
    }

    @Step("Click on the 'Done' button")
    public void clickOnDoneButton() {
        log.info("Clicking on the 'Done' button");
        Waiters.waitForElementLocated(driver, doneBtn, 5);
        doneBtn.click();
    }
}
