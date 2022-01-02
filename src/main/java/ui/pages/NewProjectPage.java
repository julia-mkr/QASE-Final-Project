package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewProjectPage extends BasePage {

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputTitle")
    WebElement projectName;
    @FindBy(id = "inputCode")
    WebElement projectCode;
    @FindBy(id = "inputDescription")
    WebElement descriptionField;
    @FindBy(id = "public-access-type")
    WebElement publicAccessRadioBtn;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement createProjectBtn;

    public ProjectRepositoryPage createNewPublicProject(String projectName, String projectCode, String descriptionField) {
        this.projectName.sendKeys(projectName);
        this.projectCode.clear();
        this.projectCode.sendKeys(projectCode);
        this.descriptionField.sendKeys(descriptionField);
        publicAccessRadioBtn.click();
        clickOnCreateProjectButton();
        return new ProjectRepositoryPage(driver);
    }

    public void clickOnCreateProjectButton() {
        createProjectBtn.click();
    }
}
