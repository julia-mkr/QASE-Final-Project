package ui.pages;

import ui.elements.TextField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateSuiteModalPage extends BasePage {

    public CreateSuiteModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    WebElement suiteName;
    @FindBy(id = "save-suite-button")
    WebElement createBtn;

    public ProjectRepositoryPage createSuiteFillingInRequiredFields(String suiteName) {
        this.suiteName.sendKeys(suiteName);
        clickOnCreateButton();
        return new ProjectRepositoryPage(driver);
    }

    public ProjectRepositoryPage createSuiteFillingInAllFields(String suiteName, String description, String preconditions) {
        this.suiteName.sendKeys(suiteName);
        new TextField(driver).writeTextForSuite(description, preconditions);
        clickOnCreateButton();
        return new ProjectRepositoryPage(driver);
    }

    public void clickOnCreateButton() {
        createBtn.click();
    }
}
