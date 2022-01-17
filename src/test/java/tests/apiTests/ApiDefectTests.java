package tests.apiTests;

import api.adapters.DefectAdapter;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.apiTestData.ApiDefectData;

public class ApiDefectTests implements ApiDefectData {

    DefectAdapter defectAdapter = new DefectAdapter();

    @Test(groups = "Smoke", description = "The test creates a new defect report using API")
    public void createDefectTest() {
        int defectId = defectAdapter.createDefect(PROJECT_CODE, API_DEFECT_DATA_1);
        String defectTitle = defectAdapter.getSpecificDefect(PROJECT_CODE, defectId).getTitle();
        Assert.assertEquals(defectTitle, API_DEFECT_DATA_1.getTitle());
    }

    @Test(groups = "Smoke", description = "The test resolves a defect using API")
    public void resolveSpecificDefectTest() {
        int defectId = defectAdapter.createDefect(PROJECT_CODE, API_DEFECT_DATA_2);
        defectAdapter.resolveSpecificDefect(PROJECT_CODE, defectId);
        String status = defectAdapter.getSpecificDefect(PROJECT_CODE, defectId).getStatus();
        Assert.assertEquals(status, RESOLVED_DEFECT_STATUS);
    }

    @Test(groups = "Smoke", description = "The test changes the status of a defect to 'In progress' using API")
    public void changeStatusToSpecificDefectTest() {
        int defectId = defectAdapter.createDefect(PROJECT_CODE, API_DEFECT_DATA_3);
        defectAdapter.updateSpecificDefectStatus(PROJECT_CODE, defectId,UPDATE_DEFECT_STATUS);
        String status = defectAdapter.getSpecificDefect(PROJECT_CODE, defectId).getStatus();
        Assert.assertEquals(status, IN_PROGRESS_STATUS);
    }
}
