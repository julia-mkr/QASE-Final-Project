package ui.pages;

import io.qameta.allure.Step;
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

    @Step("Click on the 'Create Suite' button")
    public CreateSuiteModalPage clickOnCreateSuiteButton() {
        createSuiteBtn.click();
        return new CreateSuiteModalPage(driver);
    }

    @Step("Click on the 'Create Case' button")
    public CreateTestCasePage clickOnCreateCaseButton() {
        createTestBtn.click();
        return new CreateTestCasePage(driver);
    }

    @Step("Click on the 'Defects' submenu option")
    public DefectsPage clickOnDefectsSubMenuOption() {
        new SubMenu(driver, DEFECTS_SUB_MENU_LABEL).clickOnSubMenuOption();
        return new DefectsPage(driver);
    }

    @Step("Click on the 'Milestones' submenu option")
    public MilestonesPage clickOnMilestonesSubMenuOption() {
        new SubMenu(driver, MILESTONES_SUB_MENU_LABEL).clickOnSubMenuOption();
        return new MilestonesPage(driver);
    }

    @Step("Click on the 'Test Plans' submenu option")
    public TestPlansPage clickOnTestPlansSubMenuOption() {
        new SubMenu(driver, TEST_PLANS_SUB_MENU_LABEL).clickOnSubMenuOption();
        return new TestPlansPage(driver);
    }

    @Step("Click on the '{testCaseTitle}' title")
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

    @Step("Verify, that the created '{suiteName}' suite is displayed on the 'Project Repository' page")
    public boolean isCreatedSuiteDisplayed(String suiteName) {
        Waiters.waitForElementsBecomeVisible(driver, suiteTitles, 5);
        for(WebElement element : suiteTitles) {
            if (element.getText().contains(suiteName)) {
                return true;
            }
        }  return false;
    }
}
