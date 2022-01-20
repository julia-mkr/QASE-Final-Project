package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProjectPage extends ProjectsPage {

    public DeleteProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement deleteProjectBtn;

    @Step("Confirm deleting of the project clicking on the 'Delete' button")
    public ProjectsPage confirmDeletingProject() {
        deleteProjectBtn.click();
        return new ProjectsPage(driver);
    }
}
