package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProjectPage extends ProjectsPage {

    public DeleteProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement deleteProjectBtn;

    public ProjectsPage confirmDeletingProject() {
        deleteProjectBtn.click();
        return new ProjectsPage(driver);
    }
}
