package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

@Log4j2
public class DefectPage extends DefectsPage {

    public DefectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'defect-in-progress')]")
    private WebElement inProgressBtn;
    @FindBy(xpath = "//*[text()='Confirm' and contains(@class, 'btn')]")
    private WebElement confirmBtn;
    @FindBy(xpath = "//*[contains(@class, 'defect-resolve')]")
    private WebElement resolveBtn;

    private static final String DESCRIPTION_TEXT = "//*[contains(@class,'contents')]//*[text()='%s']";
    private static final String SELECTED_OPTION = "//*[text()='%s']//parent::*[contains(@class,'param')]//*[contains(@class,'param-value')]";
    private static final String DEFECT_TITLE = "//h1[text()='%s']";
    private static final By ASSIGNEE_NAME = By.xpath("//*[text()='Assignee']//parent::*[contains(@class,'param')]//*[contains(@class,'param-value')]//span");
    private static final By RESOLVED_DEFECT_STATUS = By.xpath("//span[@aria-label='Resolved']");

    @Step("Verify, that the defect title: '{title}' is displayed")
    public boolean isDefectTitleDisplayed(String title) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(DEFECT_TITLE, title)), 5);
        return driver.findElement(By.xpath(String.format(DEFECT_TITLE, title))).isDisplayed();
    }

    @Step("Verify, that the description text: '{text}' is displayed")
    public boolean isDescriptionTextDisplayed(String text) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(DESCRIPTION_TEXT, text)), 5);
        return driver.findElement(By.xpath(String.format(DESCRIPTION_TEXT, text))).isDisplayed();
    }

    @Step("Verify, that the selected option: '{label}' is displayed")
    public boolean isOptionDisplayed(String label) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(SELECTED_OPTION, label)), 5);
        return driver.findElement(By.xpath(String.format(SELECTED_OPTION, label))).isDisplayed();
    }

    @Step("Verify, that the selected assignee name is displayed")
    public boolean isAssigneeNameDisplayed() {
        return driver.findElement(ASSIGNEE_NAME).isDisplayed();
    }

    @Step("Mark the defect as 'In progress'")
    public void markDefectAsInProgress() {
        Waiters.waitForElementLocated(driver, inProgressBtn, 5);
        log.info("Clicking on the 'In progress' button");
        inProgressBtn.click();
        clickOnConfirmButton();
    }

    @Step("Mark the defect as 'Resolved'")
    public void markDefectAsResolved() {
        Waiters.waitForElementLocated(driver, resolveBtn, 10);
        log.info("Clicking on the 'Resolve' button");
        resolveBtn.click();
        clickOnConfirmButton();
    }

    @Step("Click on the 'Confirm' button")
    public void clickOnConfirmButton() {
        log.info("Clicking on the 'Confirm' button");
        confirmBtn.click();
    }

    @Step("Resolve the defect")
    public DefectPage resolveDefect() {
        markDefectAsInProgress();
        markDefectAsResolved();
        return this;
    }

    public String getDefectStatus() {
        Waiters.waitForElementBecomesVisible(driver,RESOLVED_DEFECT_STATUS, 5);
        return driver.findElement(RESOLVED_DEFECT_STATUS).getText();
    }
}
