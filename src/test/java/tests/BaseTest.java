package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import testConstants.*;
import ui.pages.*;

public class BaseTest implements TConstants {
    WebDriver driver;
    ChromeOptions options;
    LoginPage loginPage;
    ProjectsPage projectsPage;
    NewProjectPage newProjectPage;
    ProjectRepositoryPage projectRepositoryPage;
    DeleteProjectPage deleteProjectPage;
    CreateSuiteModalPage createSuiteModalPage;
    CreateTestCasePage createTestCasePage;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        initPages();
    }

    public void initPages() {
        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        newProjectPage = new NewProjectPage(driver);
        projectRepositoryPage = new ProjectRepositoryPage(driver);
        deleteProjectPage = new DeleteProjectPage(driver);
        createSuiteModalPage = new CreateSuiteModalPage(driver);
        createTestCasePage = new CreateTestCasePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
