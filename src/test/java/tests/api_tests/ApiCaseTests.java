package tests.api_tests;

import api.adapters.CaseAdapter;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.apiTestData.ApiTestCaseData;

public class ApiCaseTests implements ApiTestCaseData {

    private final CaseAdapter caseAdapter = new CaseAdapter();

    @Test(groups = "Smoke", description = "The test creates a test case filling in the required fields " +
            "and adding some other values using API")
    @Description("Creation of a new test case with filling in the required fields and adding some values through API")
    public void createTestCaseTest() {
        int caseId = caseAdapter.createTestCase(PROJECT_CODE, API_CASE_DATA_1);
        String caseTitle = caseAdapter.getSpecificTestCase(PROJECT_CODE, caseId).getTitle();
        Assert.assertEquals(caseTitle, API_CASE_DATA_1.getTestCaseTitle());
    }

    @Test(groups = "Smoke", description = "The test creates a test case filling in the required fields, adding some other values, " +
            "and attaching a file to it using API")
    @Description("Creation of a new test case with filling in the required fields, adding some values and attaching a file through API")
    public void createTestCaseAndAttachFileTest() {
        int caseId = caseAdapter.createTestCaseAndUploadFileToIt(PROJECT_CODE, API_CASE_DATA_2);
        String caseTitle = caseAdapter.getSpecificTestCase(PROJECT_CODE, caseId).getTitle();
        Assert.assertEquals(caseTitle, API_CASE_DATA_2.getTestCaseTitle());
    }
}
