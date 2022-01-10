package ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.constants.IConstants;

import java.io.File;

public class BasePage implements IConstants {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='file']")
    private WebElement uploadFile;

    public void openUrl(String url) {
        driver.get(url);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor  = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void uploadFile(String fileName) {
        File filePath = new File(String.format("src/test/resources/%s", fileName));
        uploadFile.sendKeys(filePath.getAbsolutePath());
    }
}
