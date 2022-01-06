package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

import java.util.List;

public class ProjectRepositoryPage extends BasePage {

    public ProjectRepositoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "create-suite-button")
    WebElement createSuiteBtn;
    @FindBy(id = "create-case-button")
    WebElement createTestBtn;
    @FindBy(xpath = "//button[@title='Delete case']")
    WebElement deleteCaseBtn;
    @FindBy(xpath = "//span[contains(@class,'titleText')]")
    List<WebElement> suiteTitles;
    @FindBy(xpath = "//*[contains(@alt,'No suites')]")
    WebElement imageOnProjectRepository;
    @FindBy(xpath = "//*[contains(@class,'no-project')]")
    WebElement emptyProjectRepositoryText;

    private static final String TAB_NAVIGATION = "//*[@class='nav-link-title' and contains(text(), '%s')]";
    private static final String TEST_CASE_TITLE = "//*[text()='%s' and contains(@class,'caseTitle')]";

    public ProjectsPage clickOnNavigationTab(String tabName) {
        driver.findElement(By.xpath(String.format(TAB_NAVIGATION, tabName))).click();
        return new ProjectsPage(driver);
    }

    public CreateSuiteModalPage clickOnCreateSuiteButton() {
        createSuiteBtn.click();
        return new CreateSuiteModalPage(driver);
    }

    public CreateTestCasePage clickOnCreateCaseButton() {
        createTestBtn.click();
        return new CreateTestCasePage(driver);
    }

    public ProjectRepositoryPage clickOnTestCase(String testCaseTitle) {
        Waiters.waitForElementLocated(driver, createSuiteBtn, 5);
        driver.findElement(By.xpath(String.format(TEST_CASE_TITLE, testCaseTitle))).click();
        Waiters.waitForElementLocated(driver, deleteCaseBtn, 5);
        return this;
    }

    public boolean isImageOnProjectRepositoryDisplayed() {
        return imageOnProjectRepository.isDisplayed();
    }

    public String getTextThatProjectRepositoryIsEmpty() {
        return emptyProjectRepositoryText.getText();
    }

    public boolean isCreatedSuiteDisplayed(String suiteName) {
        Waiters.waitForElementsBecomeVisible(driver, suiteTitles, 5);
        for(WebElement element : suiteTitles) {
            if (element.getText().contains(suiteName)) {
                return true;
            }
        }  return false;
    }
}
