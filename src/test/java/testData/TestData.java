package testData;

import ui.utils.PropertyReader;

public interface TestData {

    String EMAIL = System.getProperty("email", PropertyReader.getProperty("email"));
    String PASSWORD = System.getProperty("password", PropertyReader.getProperty("password"));
    String INVALID_EMAIL = System.getProperty("invalidEmail", PropertyReader.getProperty("invalidEmail"));
    String EXPECTED_LOGIN_ERROR_MESSAGE = "These credentials do not match our records.";
    String EXPECTED_EMPTY_REPOSITORY_TEXT = "Looks like you don’t have any suites and cases yet.";
    String TEXT_FOR_PROJECT_DESCRIPTION_FIELD = "Some description for this project";
    String LOGIN_URL = "https://app.qase.io/login";
    String PROJECT_TITLE_FOR_CREATION = "New project";
    String PROJECT_CODE_FOR_CREATION = "NP3";
    String PROJECT_TITLE = "Project 2";
    String PROJECT_TITLE_FOR_DELETION = "Project 3.0";
    String PROJECT_CODE_FOR_DELETION = "Proj3";
    String TEST_PLAN_TITLE = "Smoke";
    String TEST_PLAN_DESCRIPTION = "Test plan description for the project";
    String SUITE_NAME_FOR_TEST_PLAN = "Test cases without suite";
}
