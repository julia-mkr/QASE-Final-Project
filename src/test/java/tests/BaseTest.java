package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import testData.*;
import ui.pages.*;
import ui.utils.VerificationUtils;

public class BaseTest implements TestData {
    WebDriver driver;
    ChromeOptions options;
    LoginPage loginPage;
    ProjectsPage projectsPage;
    NewProjectPage newProjectPage;
    ProjectRepositoryPage projectRepositoryPage;
    DeleteProjectPage deleteProjectPage;
    CreateSuiteModalPage createSuiteModalPage;
    CreateTestCasePage createTestCasePage;
    MilestonesPage milestonesPage;
    CreateMilestonePage createMilestonePage;
    DefectsPage defectsPage;
    CreateNewDefectPage createNewDefectPage;
    DefectPage defectPage;
    UserMenuPage userMenuPage;
    NavigationMenuPage navigationMenuPage;
    VerificationUtils verificationUtils;
    WorkspacePage workspacePage;
    InvitesPage invitesPage;
    InviteNewUserModalPage inviteNewUserModalPage;
    UserGroupsPage userGroupsPage;
    CreateGroupPage createGroupPage;
    GroupPage groupPage;
    AddMemberToGroupModalPage addMemberToGroupModalPage;
    TestPlansPage testPlansPage;
    CreateTestPlanPage createTestPlanPage;
    UploadFileModalPage uploadFileModalPage;

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
        milestonesPage = new MilestonesPage(driver);
        createMilestonePage = new CreateMilestonePage(driver);
        defectsPage = new DefectsPage(driver);
        createNewDefectPage = new CreateNewDefectPage(driver);
        defectPage = new DefectPage(driver);
        userMenuPage = new UserMenuPage(driver);
        navigationMenuPage = new NavigationMenuPage(driver);
        verificationUtils = new VerificationUtils(driver);
        workspacePage = new WorkspacePage(driver);
        invitesPage = new InvitesPage(driver);
        inviteNewUserModalPage = new InviteNewUserModalPage(driver);
        userGroupsPage = new UserGroupsPage(driver);
        createGroupPage = new CreateGroupPage(driver);
        groupPage = new GroupPage(driver);
        addMemberToGroupModalPage = new AddMemberToGroupModalPage(driver);
        testPlansPage = new TestPlansPage(driver);
        createTestPlanPage = new CreateTestPlanPage(driver);
        uploadFileModalPage = new UploadFileModalPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
