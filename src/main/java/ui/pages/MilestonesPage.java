package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

public class MilestonesPage extends ProjectRepositoryPage {

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "createButton")
    private WebElement createMilestoneBtn;

    private static final String MILESTONE_TITLE = "//*[text()='%s' and @class='defect-title']";
    private static final String MILESTONE_DESCRIPTION = "//*[contains(@class,'contents')]//p";

    @Step("Click on the 'Create milestone' button")
    public CreateMilestonePage clickOnCreateMilestoneButton() {
        Waiters.waitForElementLocated(driver, createMilestoneBtn, 5);
        createMilestoneBtn.click();
        return new CreateMilestonePage(driver);
    }

    @Step("Verify, that the milestone title: '{milestoneName}' is displayed on the 'Milestones' page")
    public boolean isMilestoneTitleDisplayed(String milestoneName) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(MILESTONE_TITLE, milestoneName)), 5);
        return driver.findElement(By.xpath(String.format(MILESTONE_TITLE, milestoneName))).isDisplayed();
    }

    public boolean isMilestoneDescriptionDisplayed() {
        return driver.findElement(By.xpath(MILESTONE_DESCRIPTION)).isDisplayed();
    }
}
