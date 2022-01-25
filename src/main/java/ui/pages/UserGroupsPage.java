package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

@Log4j2
public class UserGroupsPage extends WorkspacePage {

    public UserGroupsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class,'btn') and contains(text(),'Create')]")
    private WebElement createNewGroupBtn;

    private static final String GROUP_TITLE = "//*[@class='defect-title' and text()='%s']";
    private static final String GROUP_DESCRIPTION = "//*[@class='project-cases' and text()='%s']";

    @Step("Click on the 'Create new group' button")
    public CreateGroupPage clickOnCreateNewGroupButton() {
        log.info("Clicking on the 'Create new group' button on the 'User Groups' page");
        createNewGroupBtn.click();
        return new CreateGroupPage (driver);
    }

    @Step("Click on the '{groupTitle}' group title")
    public GroupPage clickOnGroupTitle(String groupTitle) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(GROUP_TITLE, groupTitle)), 5);
        log.info("Clicking on the " + groupTitle + " group on the 'User Groups' page");
        driver.findElement(By.xpath(String.format(GROUP_TITLE, groupTitle))).click();
        return new GroupPage(driver);
    }

    @Step("Verify, that the group title: '{title}' is displayed on the 'User Groups' page")
    public boolean isGroupTitleDisplayed(String title) {
        return driver.findElement(By.xpath(String.format(GROUP_TITLE, title))).isDisplayed();
    }

    @Step("Verify, that the group description: '{description}' is displayed on the 'User Groups' page")
    public boolean isGroupDescriptionDisplayed(String description) {
        return driver.findElement(By.xpath(String.format(GROUP_DESCRIPTION, description))).isDisplayed();
    }
}
