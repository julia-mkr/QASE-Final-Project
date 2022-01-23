package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

@Log4j2
public class GroupPage extends UserGroupsPage {

    public GroupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'text-center')]//child::*[text()='Add member' and contains(@class, 'btn')]")
    private WebElement addMemberButton;
    private static final String MEMBER_NAME = "//*[contains(@class, 'member-name') and contains(text(),'%s')]";

    @Step("Click on the 'Add member' button")
    public AddMemberToGroupModalPage clickOnAddMemberButton() {
        log.info("Clicking on 'Add member' button on the 'Group' page");
        addMemberButton.click();
        return new AddMemberToGroupModalPage(driver);
    }

    @Step("Verify, that the name of the added member: '{name}' is displayed on the 'Group' page")
    public boolean isAddedMemberNameDisplayed(String name) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(MEMBER_NAME, name)), 5);
        return driver.findElement(By.xpath(String.format(MEMBER_NAME, name))).isDisplayed();
    }
}
