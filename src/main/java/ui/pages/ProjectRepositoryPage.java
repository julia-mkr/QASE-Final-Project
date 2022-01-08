package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.SubMenu;
import ui.utils.Waiters;

import java.util.List;

public class ProjectRepositoryPage extends ProjectsPage {

    public ProjectRepositoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "create-suite-button")
    private WebElement createSuiteBtn;
    @FindBy(id = "create-case-button")
    private WebElement createTestBtn;
    @FindBy(xpath = "//button[@title='Delete case']")
    private WebElement deleteCaseBtn;
    @FindBy(xpath = "//span[contains(@class,'titleText')]")
    private List<WebElement> suiteTitles;
    @FindBy(xpath = "//*[contains(@alt,'No suites')]")
    private WebElement imageOnProjectRepository;
    @FindBy(xpath = "//*[contains(@class,'no-project')]")
    private WebElement emptyProjectRepositoryText;

    private static final String TEST_CASE_TITLE = "//*[text()='%s' and contains(@class,'caseTitle')]";

    public CreateSuiteModalPage clickOnCreateSuiteButton() {
        createSuiteBtn.click();
        return new CreateSuiteModalPage(driver);
    }

    public CreateTestCasePage clickOnCreateCaseButton() {
        createTestBtn.click();
        return new CreateTestCasePage(driver);
    }

    public DefectsPage clickOnDefectSubMenuOption() {
        new SubMenu(driver, "Defects").clickOnSubMenuOption();
        return new DefectsPage(driver);
    }

    public MilestonesPage clickOnMilestonesSubMenuOption() {
        new SubMenu(driver, "Milestones").clickOnSubMenuOption();
        return new MilestonesPage(driver);
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
