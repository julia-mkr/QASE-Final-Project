package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryPage extends BasePage {

    public ProjectRepositoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@alt,'No suites')]")
    WebElement imageOnProjectRepository;
    @FindBy(xpath = "//*[contains(@class,'no-project')]")
    WebElement textOnProjectRepository;
    @FindBy(xpath = "//*[@class='nav-link-title' and contains(text(), 'Projects')]")
    WebElement projectsTab;
    @FindBy(id = "create-suite-button")
    WebElement createSuiteBtn;
    @FindBy(xpath = "//span[contains(@class,'titleText')]")
    List<WebElement> suiteTitles;

    public ProjectsPage clickOnProjectTab() {
        projectsTab.click();
        return new ProjectsPage(driver);
    }

    public boolean isImageOnProjectRepositoryDisplayed() {
        return imageOnProjectRepository.isDisplayed();
    }

    public String getTextOnProjectRepository() {
        return textOnProjectRepository.getText();
    }

    public CreateSuiteModalPage clickOnCreateSuiteButton() {
        createSuiteBtn.click();
        return new CreateSuiteModalPage(driver);
    }

    public boolean isCreatedSuiteDisplayed(String suiteName) {
        ArrayList<String> suiteNames = new ArrayList<>();
        Waiters.waitForElementsBecomeVisible(driver, suiteTitles, 5);
        for(WebElement element : suiteTitles) {
            suiteNames.add(element.getText());
        }
        return suiteNames.contains(suiteName);
    }
}
