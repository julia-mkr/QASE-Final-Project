package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.*;
import ui.objects.Milestone;

public class CreateMilestonePage extends MilestonesPage {

    public CreateMilestonePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Create milestone' and contains(@class, 'save-button')]")
    private WebElement createMilestoneBtn;

    @Step("Enter the milestone name: '{milestone.milestoneName}' and the description: '{milestone.description}'")
    public MilestonesPage createMilestoneFillingInRequiredFields(Milestone milestone) {
        new InputField(driver, MILESTONE_NAME_LABEL).writeTextIntoInputField(milestone.getMilestoneName());
        new TextField(driver, DESCRIPTION_LABEL).writeTextIntoTextField(milestone.getDescription());
        clickOnSaveMilestoneButton();
        return new MilestonesPage(driver);
    }

    @Step("Enter the milestone name: '{milestone.milestoneName}', the description: '{milestone.description}', " +
            "the due date: '{milestone.dueDate}' and select the 'Status' value: '{milestone.status}'")
    public MilestonesPage createMilestoneFillingInAllFields(Milestone milestone) {
        new InputField(driver, MILESTONE_NAME_LABEL).writeTextIntoInputField(milestone.getMilestoneName());
        new TextField(driver, DESCRIPTION_LABEL).writeTextIntoTextField(milestone.getDescription());
        new DropDown(driver, STATUS_LABEL).selectOption(milestone.getStatus());
        new InputField(driver, DUE_DATE_LABEL).writeTextIntoInputField(milestone.getDueDate());
        clickOnSaveMilestoneButton();
        return new MilestonesPage(driver);
    }

    @Step("Click on the 'Save milestone' button")
    public void clickOnSaveMilestoneButton() {
        createMilestoneBtn.click();
    }
}
