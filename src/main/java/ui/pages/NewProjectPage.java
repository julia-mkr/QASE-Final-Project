package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.InputField;

@Log4j2
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

    @Step("Create a new public project entering the project name: '{projectName}', the project code: '{projectCode}' " +
            "and the description: '{descriptionText}'")
    public ProjectRepositoryPage createNewPublicProject(String projectName, String projectCode, String descriptionText) {
        new InputField(driver, PROJECT_NAME_LABEL).writeTextIntoInputField(projectName);
        log.info("Clearing the 'Project code' field");
        this.projectCode.clear();
        log.info("Typing the project code: " + projectCode + " into the 'Project code' field");
        this.projectCode.sendKeys(projectCode);
        log.info("Typing the description: " + descriptionText + " into the 'Description' field");
        descriptionInput.sendKeys(descriptionText);
        clickOnPublicAccessTypeRadioBtn();
        clickOnSaveProjectButton();
        return new ProjectRepositoryPage(driver);
    }

    @Step("Click on the 'Save project' button")
    public void clickOnSaveProjectButton() {
        log.info("Clicking on the 'Save project' button");
        createProjectButton.click();
    }

    @Step("Click on the 'Public' project access type")
    public void clickOnPublicAccessTypeRadioBtn() {
        log.info("Clicking on the 'Public' project access type");
        publicAccessRadioBtn.click();
    }
}
