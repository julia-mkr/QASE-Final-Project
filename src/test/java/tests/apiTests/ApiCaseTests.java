package tests.apiTests;

import api.adapters.CaseAdapter;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.apiTestData.ApiTestCaseData;

public class ApiCaseTests implements ApiTestCaseData {

    private final CaseAdapter caseAdapter = new CaseAdapter();

    @Test(groups = "Smoke", description = "The test creates a test case filling in the required fields " +
            "and selecting some values using API")
    public void createTestCaseTest() {
        int caseId = caseAdapter.createTestCase(PROJECT_CODE, API_CASE_DATA_1);
        String caseTitle = caseAdapter.getSpecificTestCase(PROJECT_CODE, caseId).getTitle();
        Assert.assertEquals(caseTitle, API_CASE_DATA_1.getTestCaseTitle());
    }

    @Test(groups = "Smoke", description = "The test creates a test case filling in the required fields, selecting some values, " +
            "and attaching a file to it using API")
    public void createTestCaseAndAttachFileTest() {
        int caseId = caseAdapter.createTestCaseAndUploadFileToIt(PROJECT_CODE, API_CASE_DATA_2);
        String caseTitle = caseAdapter.getSpecificTestCase(PROJECT_CODE, caseId).getTitle();
        Assert.assertEquals(caseTitle, API_CASE_DATA_2.getTestCaseTitle());
    }
}
