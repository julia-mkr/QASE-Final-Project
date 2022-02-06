package tests.api_tests;

import api.adapters.UploadAttachmentAdapter;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.apiTestData.ApiConstants;

public class UploadAttachmentTests implements ApiConstants {

    UploadAttachmentAdapter uploadAttachmentAdapter = new UploadAttachmentAdapter();

    @Test(groups = "Smoke", description = "The test uploads a file using API")
    @Description("Uploading of a file through API")
    public void uploadFileTest() {
        String hash = uploadAttachmentAdapter.uploadAttachment(PROJECT_CODE, FILE_FOR_UPLOADING);
        Assert.assertTrue(uploadAttachmentAdapter.isAttachmentUploaded(hash));
    }
}
