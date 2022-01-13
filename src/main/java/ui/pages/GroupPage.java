package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

public class GroupPage extends UserGroupsPage {

    public GroupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'text-center')]//child::*[text()='Add member' and contains(@class, 'btn')]")
    private WebElement addMemberButton;
    private static final String MEMBER_NAME = "//*[contains(@class, 'member-name') and contains(text(),'%s')]";

    public AddMemberToGroupModalPage clickOnAddMemberButton() {
        addMemberButton.click();
        return new AddMemberToGroupModalPage(driver);
    }

    public boolean isAddedMemberNameDisplayed(String name) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(MEMBER_NAME, name)), 5);
        return driver.findElement(By.xpath(String.format(MEMBER_NAME, name))).isDisplayed();
    }
}
