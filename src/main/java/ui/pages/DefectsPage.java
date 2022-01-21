package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

public class DefectsPage extends ProjectRepositoryPage {

    public DefectsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(), 'new defect') and contains(@class, 'btn')]")
    private WebElement createDefectBtn;
    private static final String DEFECT_TITLE = "//a[@class='defect-title' and text()='%s']";

    @Step("Click on the 'Create new defect' button")
    public CreateNewDefectPage clickOnCreateNewDefectButton() {
        Waiters.waitForElementLocated(driver, createDefectBtn, 5);
        createDefectBtn.click();
        return new CreateNewDefectPage(driver);
    }

    @Step("Click on the '{defectTitle}' defect title")
    public void clickOnDefectTitle(String defectTitle) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(DEFECT_TITLE, defectTitle)), 5);
        driver.findElement(By.xpath(String.format(DEFECT_TITLE, defectTitle))).click();
    }
}
