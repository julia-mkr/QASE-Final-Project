package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class UploadFileModalPage extends ProjectRepositoryPage {

    public UploadFileModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='file']")
    private static WebElement uploadFile;

    @Step("Upload the '{fileName}' file")
    public static void uploadFile(String fileName) {
        File filePath = new File(String.format("src/test/resources/%s", fileName));
        uploadFile.sendKeys(filePath.getAbsolutePath());
    }
}
