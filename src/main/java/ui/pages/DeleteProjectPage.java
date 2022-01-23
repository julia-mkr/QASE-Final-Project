package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class DeleteProjectPage extends ProjectsPage {

    public DeleteProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement deleteProjectBtn;

    @Step("Confirm deleting of the project clicking on the 'Delete' button")
    public ProjectsPage confirmDeletingProject() {
        log.info("Clicking on the 'Delete project' button on the 'Delete Project' page");
        deleteProjectBtn.click();
        return new ProjectsPage(driver);
    }
}
