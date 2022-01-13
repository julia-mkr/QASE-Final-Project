package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

import java.util.List;

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

    public GroupPage addMemberToGroup(String name) {
        clickOnDropdownMenu();
        memberNames.stream()
                .filter(names -> names.getText().matches(name))
                .forEach(WebElement::click);
        clickOnAddMemberButtonOnModal();
        return new GroupPage(driver);
    }

    public void clickOnDropdownMenu() {
        Waiters.waitForElementLocated(driver, dropdownMenu, 5);
        dropdownMenu.click();
    }

    public void clickOnAddMemberButtonOnModal() {
        addMemberBtnOnModal.click();
    }
}
