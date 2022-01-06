package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.InputField;

public class NewProjectPage extends BasePage {

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputCode")
    WebElement projectCode;
    @FindBy(id = "inputDescription")
    WebElement descriptionInput;
    @FindBy(id = "public-access-type")
    WebElement publicAccessRadioBtn;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement createProjectBtn;

    public ProjectRepositoryPage createNewPublicProject(String projectName, String projectCode, String descriptionText) {
        new InputField(driver, PROJECT_NAME_LABEL).writeTextIntoInputField(projectName);
        this.projectCode.clear();
        this.projectCode.sendKeys(projectCode);
        descriptionInput.sendKeys(descriptionText);
        publicAccessRadioBtn.click();
        clickOnCreateProjectButton();
        return new ProjectRepositoryPage(driver);
    }

    public void clickOnCreateProjectButton() {
        createProjectBtn.click();
    }
}
