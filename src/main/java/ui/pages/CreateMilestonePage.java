package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.*;
import ui.objects.Milestone;

@Log4j2
public class CreateMilestonePage extends MilestonesPage {

    public CreateMilestonePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Create milestone' and contains(@class, 'save-button')]")
    private WebElement createMilestoneBtn;

    @Step("Create a new milestone filling in the required fields and entering the milestone name: '{milestone.milestoneName}' and " +
            "the description: '{milestone.description}'")
    public MilestonesPage createMilestoneFillingInRequiredFields(Milestone milestone) {
        new InputField(driver, MILESTONE_NAME_LABEL).writeTextIntoInputField(milestone.getMilestoneName());
        new TextField(driver, DESCRIPTION_LABEL).writeTextIntoTextField(milestone.getDescription());
        clickOnCreateMilestoneBtn();
        return new MilestonesPage(driver);
    }

    @Step("Create a new milestone filling in all the fields and entering the milestone name: '{milestone.milestoneName}', " +
            "the description: '{milestone.description}', the due date: '{milestone.dueDate}' and " +
            "select the 'Status' value: '{milestone.status}'")
    public MilestonesPage createMilestoneFillingInAllFields(Milestone milestone) {
        new InputField(driver, MILESTONE_NAME_LABEL).writeTextIntoInputField(milestone.getMilestoneName());
        new TextField(driver, DESCRIPTION_LABEL).writeTextIntoTextField(milestone.getDescription());
        new DropDown(driver, STATUS_LABEL).selectOption(milestone.getStatus());
        new InputField(driver, DUE_DATE_LABEL).writeTextIntoInputField(milestone.getDueDate());
        clickOnCreateMilestoneBtn();
        return new MilestonesPage(driver);
    }

    @Step("Click on the 'Create milestone' button")
    public void clickOnCreateMilestoneBtn() {
        log.info("Clicking on the 'Create milestone' button");
        createMilestoneBtn.click();
    }
}
