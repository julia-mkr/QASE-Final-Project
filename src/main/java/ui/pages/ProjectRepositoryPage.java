package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.SubMenu;
import ui.utils.Waiters;

@Log4j2
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
    @FindBy(xpath = "//*[contains(@alt,'No suites')]")
    private WebElement imageOnProjectRepository;
    @FindBy(xpath = "//*[text()='Create new suite']")
    private WebElement createNewSuiteBtn;

    private static final String SUITE_TITLE = "//h3[contains(@class, 'title')]//*[text()='%s']";
    private static final String TEST_CASE_TITLE = "//*[text()='%s' and contains(@class,'title')]";

    @Step("Click on the 'Create Suite' button")
    public CreateSuiteModalPage clickOnCreateSuiteButton() {
        Waiters.waitForElementLocated(driver, createSuiteBtn, 5);
        log.info("Clicking on the 'Create Suite' button on the 'Project Repository' page");
        createSuiteBtn.click();
        return new CreateSuiteModalPage(driver);
    }

    @Step("Click on the 'Create Case' button")
    public CreateTestCasePage clickOnCreateCaseButton() {
        Waiters.waitForElementLocated(driver, createTestBtn, 5);
        log.info("Clicking on the 'Create Case' button on the 'Project Repository' page");
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
        log.info("Clicking on the " + testCaseTitle + " title");
        driver.findElement(By.xpath(String.format(TEST_CASE_TITLE, testCaseTitle))).click();
        Waiters.waitForElementLocated(driver, deleteCaseBtn, 5);
        return this;
    }

    public boolean isImageOnProjectRepositoryDisplayed() {
        Waiters.waitForElementLocated(driver, imageOnProjectRepository, 10);
        return imageOnProjectRepository.isDisplayed();
    }

    public boolean isCreateNewSuiteButtonDisplayed() {
        Waiters.waitForElementLocated(driver, createNewSuiteBtn, 5);
        return createNewSuiteBtn.isDisplayed();
    }

    @Step("Verify, that the created '{suiteName}' suite is displayed on the 'Project Repository' page")
    public boolean isCreatedSuiteDisplayed(String suiteName) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(SUITE_TITLE, suiteName)), 5);
        return driver.findElement(By.xpath(String.format(SUITE_TITLE, suiteName))).isDisplayed();
    }
}
