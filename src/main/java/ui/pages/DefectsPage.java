package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

@Log4j2
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
        log.info("Clicking on 'Create defect' button on the 'Defects' page");
        createDefectBtn.click();
        return new CreateNewDefectPage(driver);
    }

    @Step("Click on the '{defectTitle}' defect title")
    public void clickOnDefectTitle(String defectTitle) {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(DEFECT_TITLE, defectTitle)), 5);
        log.info("Clicking on the" + defectTitle + " title on the 'Defects' page");
        driver.findElement(By.xpath(String.format(DEFECT_TITLE, defectTitle))).click();
    }
}
