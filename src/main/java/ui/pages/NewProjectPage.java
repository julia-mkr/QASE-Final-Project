package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.InputField;

public class NewProjectPage extends ProjectsPage {

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputCode")
    private WebElement projectCode;
    @FindBy(id = "inputDescription")
    private WebElement descriptionInput;
    @FindBy(id = "public-access-type")
    private WebElement publicAccessRadioBtn;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement createProjectButton;

    public ProjectRepositoryPage createNewPublicProject(String projectName, String projectCode, String descriptionText) {
        new InputField(driver, PROJECT_NAME_LABEL).writeTextIntoInputField(projectName);
        this.projectCode.clear();
        this.projectCode.sendKeys(projectCode);
        descriptionInput.sendKeys(descriptionText);
        publicAccessRadioBtn.click();
        clickOnSaveProjectButton();
        return new ProjectRepositoryPage(driver);
    }

    public void clickOnSaveProjectButton() {
        createProjectButton.click();
    }
}
