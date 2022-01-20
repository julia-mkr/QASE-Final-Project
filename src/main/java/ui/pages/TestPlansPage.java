package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

public class TestPlansPage extends ProjectRepositoryPage {

    public TestPlansPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "createButton")
    private WebElement createPlanBtn;
    private static final String TEST_PLAN_TITLE = "//*[@class='defect-title' and text()='%s']";

    @Step("Click on the 'Create' button")
    public CreateTestPlanPage clickOnCreateButton() {
        Waiters.waitForElementLocated(driver, createPlanBtn, 5);
        createPlanBtn.click();
        return new CreateTestPlanPage(driver);
    }

    @Step("Verify, that the created test plan title: 'title' is displayed on the 'Test Plans' page")
    public boolean isCreatedTestPlanNameDisplayed(String title) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(TEST_PLAN_TITLE, title)), 5);
        return driver.findElement(By.xpath(String.format(TEST_PLAN_TITLE, title))).isDisplayed();
    }
}
