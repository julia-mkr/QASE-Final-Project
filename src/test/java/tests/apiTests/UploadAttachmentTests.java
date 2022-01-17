package tests.apiTests;

import api.adapters.UploadAttachmentAdapter;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.apiTestData.ApiConstants;

public class UploadAttachmentTests implements ApiConstants {

    UploadAttachmentAdapter uploadAttachmentAdapter = new UploadAttachmentAdapter();

    @Test(groups = "Smoke", description = "The test uploads a file using API")
    public void uploadFileTest() {
        String hash = uploadAttachmentAdapter.uploadAttachment(PROJECT_CODE, "TestCase.txt");
        Assert.assertTrue(uploadAttachmentAdapter.isAttachmentUploaded(hash));
    }
}
