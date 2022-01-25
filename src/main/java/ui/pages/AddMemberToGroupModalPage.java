package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

import java.util.List;

@Log4j2
public class AddMemberToGroupModalPage extends GroupPage {

    public AddMemberToGroupModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addMember")
    private WebElement addMemberBtnOnModal;
    @FindBy(xpath = "//*[contains(@class,'bootstrap-select')]")
    private WebElement dropdownMenu;
    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> memberNames;

    @Step("Add Member: '{name}' to the group")
    public GroupPage addMemberToGroup(String name) {
        clickOnDropdownMenu();
        log.info("Adding " + name + " to the group");
        memberNames.stream()
                .filter(names -> names.getText().matches(name))
                .forEach(WebElement::click);
        clickOnAddMemberButtonOnModal();
        return new GroupPage(driver);
    }

    @Step("Click on the dropdown menu")
    public void clickOnDropdownMenu() {
        Waiters.waitForElementLocated(driver, dropdownMenu, 5);
        log.info("Clicking on the dropdown");
        dropdownMenu.click();
    }

    @Step("Click on the 'Add member' button")
    public void clickOnAddMemberButtonOnModal() {
        log.info("Clicking on the 'Add member' button on the modal page");
        addMemberBtnOnModal.click();
    }
}
