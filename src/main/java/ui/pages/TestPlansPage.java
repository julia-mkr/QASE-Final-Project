package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

@Log4j2
public class TestPlansPage extends ProjectRepositoryPage {

    public TestPlansPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "createButton")
    private WebElement createPlanBtn;
    private static final String TEST_PLAN_TITLE = "//*[@class='defect-title' and text()='%s']";

    @Step("Click on the 'Create plan' button")
    public CreateTestPlanPage clickOnCreateButton() {
        Waiters.waitForElementLocated(driver, createPlanBtn, 5);
        log.info("Clicking on the 'Create plan' button");
        createPlanBtn.click();
        return new CreateTestPlanPage(driver);
    }

    @Step("Verify, that the created test plan title: 'title' is displayed on the 'Test Plans' page")
    public boolean isCreatedTestPlanNameDisplayed(String title) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(TEST_PLAN_TITLE, title)), 5);
        return driver.findElement(By.xpath(String.format(TEST_PLAN_TITLE, title))).isDisplayed();
    }
}
